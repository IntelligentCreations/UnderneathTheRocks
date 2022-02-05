package dev.intelligentcreations.utr.common.items.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

import static dev.intelligentcreations.utr.common.itemgroup.UTRItemGroupInit.MAIN;

public class UTRItemInit {
    public static final Item FOSSIL = new Item(new FabricItemSettings().group(MAIN));
    public static final Item BLANK_SHEET = new Item(new FabricItemSettings().group(MAIN));
}
