package dev.intelligentcreations.utr.common.data.impl;

import com.redgrapefruit.itemnbt3.CustomData;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;

public class AnalyzedFossilData implements CustomData {
    private int type;

    public AnalyzedFossilData() {
        type = 0;
    }

    public int getType() {
        return type;
    }

    public void setType(int counter) {
        this.type = counter;
    }

    @Override
    public @NotNull String getNbtCategory() {
        return "FossilType";
    }

    @Override
    public void readNbt(@NotNull NbtCompound nbt) {
        type = nbt.getInt("FossilType");
    }

    @Override
    public void writeNbt(@NotNull NbtCompound nbt) {
        nbt.putInt("FossilType", type);
    }
}
