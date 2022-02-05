package dev.intelligentcreations.utr.common.screenhandlers.impl.slots;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class InsertLimitedSlot extends Slot {
    private final ItemStack itemStack;

    public InsertLimitedSlot(Inventory inventory, int index, int x, int y, ItemStack stack) {
        super(inventory, index, x, y);
        this.itemStack = stack;
    }

    public boolean canInsert(ItemStack stack) {
        return stack.isItemEqual(this.itemStack);
    }
}
