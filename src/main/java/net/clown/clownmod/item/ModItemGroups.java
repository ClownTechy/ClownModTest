package net.clown.clownmod.item;

import net.clown.clownmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.clown.clownmod.ClownMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CLOWNMOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ClownMod.MOD_ID, "clownmod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SINGULARITY_BOTTLE))
                    .displayName(Text.translatable("itemgroup.clownmod.clownmod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SINGULARITY_BOTTLE);
                        entries.add(ModItems.SINGULARITY_SHARD);

                    }).build());

    public static final ItemGroup CLOWNMOD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ClownMod.MOD_ID, "clownmod_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SINGULARITY_BLOCK))
                    .displayName(Text.translatable("itemgroup.clownmod.clownmod_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SINGULARITY_BLOCK);
                        entries.add(ModBlocks.RAW_SINGULARITY_BLOCK);

                    }).build());




    public static void registerItemGroups() {
        ClownMod.LOGGER.info("Registering Item Groups for" + ClownMod.MOD_ID);

    }
}
