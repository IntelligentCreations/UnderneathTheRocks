package dev.intelligentcreations.utr.common.registries;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static dev.intelligentcreations.utr.UnderneathTheRocks.MOD_ID;
import static dev.intelligentcreations.utr.common.blocks.init.UTRBlockInit.*;
import static dev.intelligentcreations.utr.common.registries.BlockEntityRegistry.ANALYZER_IDENTIFIER;

public class BlockRegistry {
    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "fossil_ore"), FOSSIL_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "deepslate_fossil_ore"), DEEPSLATE_FOSSIL_ORE);
        Registry.register(Registry.BLOCK, ANALYZER_IDENTIFIER, ANALYZER_BLOCK);
    }
}
