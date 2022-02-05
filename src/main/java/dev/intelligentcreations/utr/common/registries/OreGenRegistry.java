package dev.intelligentcreations.utr.common.registries;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;

import static dev.intelligentcreations.utr.UnderneathTheRocks.MOD_ID;
import static dev.intelligentcreations.utr.common.world.oregen.init.UTROreGenInit.*;

public class OreGenRegistry {
    public static void register() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(MOD_ID, "fossil_ore_placement"), FOSSIL_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("utr", "fossil_ore_placement"),
                FOSSIL_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(MOD_ID, "fossil_ore_placement")));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(MOD_ID, "deepslate_fossil_ore_placement"), DEEPSLATE_FOSSIL_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("utr", "deepslate_fossil_ore_placement"),
                DEEPSLATE_FOSSIL_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(MOD_ID, "deepslate_fossil_ore_placement")));
    }
}
