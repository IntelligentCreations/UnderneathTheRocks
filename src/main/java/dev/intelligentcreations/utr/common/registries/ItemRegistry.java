package dev.intelligentcreations.utr.common.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static dev.intelligentcreations.utr.UnderneathTheRocks.MOD_ID;
import static dev.intelligentcreations.utr.common.blocks.init.UTRBlockInit.*;
import static dev.intelligentcreations.utr.common.itemgroup.UTRItemGroupInit.MAIN;
import static dev.intelligentcreations.utr.common.items.init.UTRItemInit.*;
import static dev.intelligentcreations.utr.common.registries.BlockEntityRegistry.ANALYZER_IDENTIFIER;

public class ItemRegistry {
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fossil"), FOSSIL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blank_sheet"), BLANK_SHEET);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fossil_ore"), new BlockItem(FOSSIL_ORE, new FabricItemSettings().group(MAIN)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "deepslate_fossil_ore"), new BlockItem(DEEPSLATE_FOSSIL_ORE, new FabricItemSettings().group(MAIN)));
        Registry.register(Registry.ITEM, ANALYZER_IDENTIFIER, new BlockItem(ANALYZER_BLOCK, new FabricItemSettings().group(MAIN)));
    }
}
