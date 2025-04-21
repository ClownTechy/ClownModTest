package net.clown.clownmod.world;

import net.clown.clownmod.ClownMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> ICE_SPIKE_PLACED_FEATURE_KEY = registerKey("ice_spike");
    public static final RegistryKey<PlacedFeature> END_RAW_SINGULARITY_BLOCK_PLACED_KEY = registerKey("end_raw_singularity_block_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        context.register(END_RAW_SINGULARITY_BLOCK_PLACED_KEY,
                new PlacedFeature(configuredFeatures.getOrThrow(ModConfiguredFeatures.END_RAW_SINGULARITY_BLOCK_KEY),
                        List.of(HeightRangePlacementModifier.trapezoid(YOffset.fixed(15), YOffset.fixed(60)))));

        context.register(ICE_SPIKE_PLACED_FEATURE_KEY,
                new PlacedFeature(configuredFeatures.getOrThrow(ModConfiguredFeatures.ICE_SPIKE_FEATURE_KEY),
                        List.of()));
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(ClownMod.MOD_ID, name));
    }
}
