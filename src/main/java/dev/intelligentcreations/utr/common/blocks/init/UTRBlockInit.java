package dev.intelligentcreations.utr.common.blocks.init;

import dev.intelligentcreations.utr.common.blocks.impl.AnalyzerBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class UTRBlockInit {
    public static final Block FOSSIL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool());
    public static final Block DEEPSLATE_FOSSIL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(6.0f).requiresTool());
    public static final AnalyzerBlock ANALYZER_BLOCK = new AnalyzerBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool());
}
