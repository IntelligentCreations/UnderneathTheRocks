package dev.intelligentcreations.utr.common.itemgroup;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static dev.intelligentcreations.utr.common.items.init.UTRItemInit.FOSSIL;

public class UTRItemGroupInit {
    public static final ItemGroup MAIN = FabricItemGroupBuilder.build(
            new Identifier("utr", "main"),
            () -> new ItemStack(FOSSIL));
}
