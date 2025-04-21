package net.clown.clownmod.datagen;

import net.clown.clownmod.block.ModBlocks;
import net.clown.clownmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGULARITY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_SINGULARITY_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SINGULARITY_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SINGULARITY_BOTTLE, Models.GENERATED);
    }
}
