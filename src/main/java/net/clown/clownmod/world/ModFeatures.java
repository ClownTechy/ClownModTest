package net.clown.clownmod.world;

import net.clown.clownmod.world.gen.feature.IceSpikeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class ModFeatures {
    public static final Feature<DefaultFeatureConfig> ICE_SPIKE_FEATURE = new IceSpikeFeature(DefaultFeatureConfig.CODEC);
}
