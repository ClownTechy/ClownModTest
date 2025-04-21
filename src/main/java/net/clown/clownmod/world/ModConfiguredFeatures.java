package net.clown.clownmod.world;

import net.clown.clownmod.ClownMod;
import net.clown.clownmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_RAW_SINGULARITY_BLOCK_KEY = registerKey("raw_singularity_block");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ICE_SPIKE_FEATURE_KEY = registerKey("ice_spike");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        context.register(ICE_SPIKE_FEATURE_KEY,
                new ConfiguredFeature<>(ModFeatures.ICE_SPIKE_FEATURE, new DefaultFeatureConfig()));

        List<OreFeatureConfig.Target> endSingularityBlock =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.RAW_SINGULARITY_BLOCK.getDefaultState()));
        context.register(END_RAW_SINGULARITY_BLOCK_KEY,
                new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(endSingularityBlock, 4, 1.0F)));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ClownMod.MOD_ID, name));
    }
}
