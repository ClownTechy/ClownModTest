package net.clown.clownmod.datagen;

import net.clown.clownmod.block.ModBlocks;
import net.clown.clownmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SINGULARITY_BLOCK);
        addDrop(ModBlocks.RAW_SINGULARITY_BLOCK, oreDrops(ModBlocks.RAW_SINGULARITY_BLOCK, ModItems.SINGULARITY_SHARD));
    }
}
