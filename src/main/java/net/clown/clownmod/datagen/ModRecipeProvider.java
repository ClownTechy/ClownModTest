package net.clown.clownmod.datagen;

import net.clown.clownmod.ClownMod;
import net.clown.clownmod.block.ModBlocks;
import net.clown.clownmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {


        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SINGULARITY_SHARD, RecipeCategory.MISC, ModBlocks.SINGULARITY_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SINGULARITY_BOTTLE)
                .pattern("SSS")
                .pattern("SXS")
                .pattern("SSS")
                .input('S', ModItems.SINGULARITY_SHARD)
                .input('X', Items.GLASS_BOTTLE)
                .criterion(hasItem(ModItems.SINGULARITY_SHARD), conditionsFromItem(ModItems.SINGULARITY_SHARD))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SINGULARITY_SHARD, 9)
                .input(ModBlocks.SINGULARITY_BLOCK)
                .criterion(hasItem(ModBlocks.SINGULARITY_BLOCK), conditionsFromItem(ModBlocks.SINGULARITY_BLOCK))
                .offerTo(exporter, Identifier.of(ClownMod.MOD_ID, "singularity_shard_from_singularity_block"));

    }
}
