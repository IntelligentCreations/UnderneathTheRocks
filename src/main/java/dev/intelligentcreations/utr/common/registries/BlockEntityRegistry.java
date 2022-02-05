package dev.intelligentcreations.utr.common.registries;

import dev.intelligentcreations.utr.common.blockentities.impl.AnalyzerBlockEntity;
import dev.intelligentcreations.utr.common.blockentities.init.UTRBlockEntityInit;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static dev.intelligentcreations.utr.UnderneathTheRocks.MOD_ID;
import static dev.intelligentcreations.utr.common.blocks.init.UTRBlockInit.ANALYZER_BLOCK;

public class BlockEntityRegistry {
    public static final Identifier ANALYZER_IDENTIFIER = new Identifier(MOD_ID, "analyzer");

    public static void register() {
        UTRBlockEntityInit.ANALYZER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, ANALYZER_IDENTIFIER, FabricBlockEntityTypeBuilder.create(AnalyzerBlockEntity::new, ANALYZER_BLOCK).build(null));
    }
}
