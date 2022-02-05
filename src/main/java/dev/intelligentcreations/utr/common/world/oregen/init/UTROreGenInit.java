package dev.intelligentcreations.utr.common.world.oregen.init;

import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;

import static dev.intelligentcreations.utr.common.blocks.init.UTRBlockInit.DEEPSLATE_FOSSIL_ORE;
import static dev.intelligentcreations.utr.common.blocks.init.UTRBlockInit.FOSSIL_ORE;

public class UTROreGenInit {
    // Fossil Ore
    public static ConfiguredFeature<?, ?> FOSSIL_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    FOSSIL_ORE.getDefaultState(),
                    2)); // vein size
    public static PlacedFeature FOSSIL_ORE_PLACED_FEATURE = FOSSIL_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(3), // number of veins per chunk
            SquarePlacementModifier.of(), // spreading horizontally
            HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.belowTop(32))); // height

    // Deepslate Fossil Ore
    public static ConfiguredFeature<?, ?> DEEPSLATE_FOSSIL_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    DEEPSLATE_FOSSIL_ORE.getDefaultState(),
                    4)); // vein size
    public static PlacedFeature DEEPSLATE_FOSSIL_ORE_PLACED_FEATURE = DEEPSLATE_FOSSIL_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(6), // number of veins per chunk
            SquarePlacementModifier.of(), // spreading horizontally
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0))); // height
}
