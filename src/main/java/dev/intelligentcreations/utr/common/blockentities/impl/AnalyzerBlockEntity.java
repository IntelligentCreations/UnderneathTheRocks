package dev.intelligentcreations.utr.common.blockentities.impl;

import com.redgrapefruit.itemnbt3.DataClient;
import dev.intelligentcreations.utr.common.data.impl.AnalyzedFossilData;
import dev.intelligentcreations.utr.common.screenhandlers.impl.AnalyzerScreenHandler;
import dev.intelligentcreations.utr.common.utils.impl.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

import static dev.intelligentcreations.utr.common.blockentities.init.UTRBlockEntityInit.ANALYZER_BLOCK_ENTITY;
import static dev.intelligentcreations.utr.common.blocks.impl.AnalyzerBlock.WORKING;
import static dev.intelligentcreations.utr.common.items.init.UTRItemInit.*;

public class AnalyzerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
    private static Random random = new Random();
    private int analyzingTime;
    private int maxAnalyzingTime;

    public AnalyzerBlockEntity(BlockPos pos, BlockState state) {
        super(ANALYZER_BLOCK_ENTITY, pos, state);
        this.analyzingTime = 0;
        this.maxAnalyzingTime = 2400;
    }

    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            return analyzingTime;
        }

        @Override
        public void set(int index, int value) {
            analyzingTime = value;
        }

        //this is supposed to return the amount of integers you have in your delegate, in our example only one
        @Override
        public int size() {
            return 1;
        }
    };

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;

    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AnalyzerScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
        maxAnalyzingTime = nbt.getShort("MaxAnalyzingTime");
        analyzingTime = nbt.getShort("AnalyzingTime");
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, this.inventory);
        nbt.putShort("MaxAnalyzingTime", (short) this.maxAnalyzingTime);
        nbt.putShort("AnalyzingTime", (short) this.analyzingTime);
        super.writeNbt(nbt);
    }

    public static void tick(World world, BlockPos pos, BlockState state, AnalyzerBlockEntity be) {
        be.tickAnalyzer(world, pos, state);
    }

    private void tickAnalyzer(World world, BlockPos pos, BlockState state) {
        ItemStack input1 = this.getStack(0);
        ItemStack input2 = this.getStack(1);
        ItemStack output1 = this.getStack(2);
        ItemStack output2 = this.getStack(3);

        if (world == null) {
            return;
        }

        if (!world.isClient) {
            if (output1.getCount() >= 1 || output2.getCount() >= 1) {
                world.setBlockState(pos, state.with(WORKING, false));
                if (this.analyzingTime != 0) {
                    this.analyzingTime = 0;
                    this.markDirty();
                }
                return;
            }

            if (input1.isEmpty() || input2.isEmpty()) {
                world.setBlockState(pos, state.with(WORKING, false));
                if (this.analyzingTime != 0) {
                    this.analyzingTime = 0;
                    this.markDirty();
                }
            } else {
                world.setBlockState(pos, state.with(WORKING, true));
                ++this.analyzingTime;
                this.markDirty();
            }

            if (this.analyzingTime >= this.maxAnalyzingTime) {
                if (output1.isEmpty() && output2.isEmpty()) {
                    int fossilType = random.nextInt(8);
                    this.setStack(2, new ItemStack(ANALYZED_FOSSIL, 1));
                    this.setStack(3, new ItemStack(ANALYZING_REPORT, 1));
                    DataClient.use(AnalyzedFossilData::new, this.getStack(2), (data) -> {
                        data.setType(fossilType);
                    });
                    DataClient.use(AnalyzedFossilData::new, this.getStack(3), (data) -> {
                        data.setType(fossilType);
                    });
                } else {
                    this.analyzingTime = 0;
                    this.markDirty();
                    return;
                }
                input1.decrement(1);
                input2.decrement(1);
                this.analyzingTime = 0;
                this.markDirty();
            }
        }
    }

    /*
    @Override
    public boolean isEmpty() {
        Iterator<ItemStack> invIterator = this.inventory.iterator();

        ItemStack stack;
        do {
            if (!invIterator.hasNext()) {
                return true;
            }

            stack = invIterator.next();
        } while (stack.isEmpty());

        return false;
    }
    */

    @Override
    public ItemStack getStack(int index) {
        return this.inventory.get(index);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return Inventories.splitStack(this.inventory, slot, amount);
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(this.inventory, slot);
    }

    @Override
    public void setStack(int index, ItemStack stack) {
        ItemStack target = this.inventory.get(index);
        boolean sameItem = !stack.isEmpty() && stack.isItemEqualIgnoreDamage(target) && ItemStack.areNbtEqual(stack, target);

        this.inventory.set(index, stack);
        if (stack.getCount() > this.getMaxCountPerStack()) {
            stack.setCount(this.getMaxCountPerStack());
        }

        if (index == 0 && !sameItem) {
            this.analyzingTime = 0;
            this.markDirty();
        }
    }
}
