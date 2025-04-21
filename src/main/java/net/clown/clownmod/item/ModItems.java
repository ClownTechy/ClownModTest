package net.clown.clownmod.item;

import net.clown.clownmod.ClownMod;
import net.clown.clownmod.item.custom.TeleportItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.command.TeleportCommand;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;

import java.util.List;

public class ModItems {
    public static final Item SINGULARITY_BOTTLE = registerItem("singularity_bottle", new TeleportItem(new Item.Settings())  {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.clownmod.singularity_bottle.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item SINGULARITY_SHARD = registerItem("singularity_shard", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ClownMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ClownMod.LOGGER.info("Registering Mod Items for " + ClownMod.MOD_ID);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(SINGULARITY_BOTTLE);
            fabricItemGroupEntries.add(SINGULARITY_SHARD);

        });
    }
    public UseAction getUseAction(ItemStack stack) {
        return stack.contains(DataComponentTypes.FOOD) ? UseAction.EAT : UseAction.NONE;
    }
    }



