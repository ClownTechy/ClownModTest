package net.clown.clownmod.world;

import net.clown.clownmod.ClownMod;
import net.clown.clownmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

import static com.mojang.text2speech.Narrator.LOGGER;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_RAW_SINGULARITY_BLOCK_KEY = registerKey("raw_singularity_block");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ICE_SPIKE_FEATURE_KEY = registerKey("mega_spike");



    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> endSingularityBlock =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.RAW_SINGULARITY_BLOCK.getDefaultState()));

        register(context, END_RAW_SINGULARITY_BLOCK_KEY, Feature.ORE, new OreFeatureConfig(endSingularityBlock, 4, 1.0F));

        register(context, ICE_SPIKE_FEATURE_KEY, ModFeatures.ICE_SPIKE_FEATURE, new DefaultFeatureConfig());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ClownMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}