package net.clown.clownmod;

import net.clown.clownmod.block.ModBlocks;
import net.clown.clownmod.item.*;
import net.clown.clownmod.world.ModConfiguredFeatures;
import net.clown.clownmod.world.ModFeatures;
import net.clown.clownmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClownMod implements ModInitializer {
	public static final String MOD_ID = "clownmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		Registry.register(Registries.FEATURE, Identifier.of(MOD_ID, "ice_spike"), ModFeatures.ICE_SPIKE_FEATURE);

		ModWorldGeneration.generateModWorldGen();
	}

}