package net.clown.clownmod.world;

import net.clown.clownmod.ClownMod;
import net.clown.clownmod.world.gen.feature.IceSpikeFeature;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class ModFeatures {

    public static final Feature<DefaultFeatureConfig> ICE_SPIKE_FEATURE =
            new IceSpikeFeature(DefaultFeatureConfig.CODEC);

    public static final RegistryKey<Feature<?>> ICE_SPIKE_FEATURE_KEY =
            RegistryKey.of(RegistryKeys.FEATURE, Identifier.of(ClownMod.MOD_ID, "ice_spike"));

    public static void bootstrap(Registerable<Feature<?>> context) {
        context.register(ICE_SPIKE_FEATURE_KEY, ICE_SPIKE_FEATURE);
    }
}
