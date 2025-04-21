package net.clown.clownmod.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.RegistryKey;
import net.clown.clownmod.util.ReturnLocationStore;
import java.util.UUID;

public class TeleportItem extends Item {

    public TeleportItem(Settings settings) {
        super(settings);
    }

    // 1. Set the drink animation
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    // 2. Set how long it takes to drink
    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 32;
    }

    // 3. What happens when player right-clicks (starts drinking)
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.setCurrentHand(hand);
        return TypedActionResult.consume(player.getStackInHand(hand));
    }

    // 4. What happens *after* drinking finishes
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient && user instanceof ServerPlayerEntity serverPlayer) {
            UUID uuid = user.getUuid();
            ServerWorld currentWorld = (ServerWorld) serverPlayer.getWorld();

            // Create custom dimension key
            RegistryKey<World> customDimKey = RegistryKey.of(RegistryKeys.WORLD, Identifier.of("ultra_space", "custom_dimension"));
            ServerWorld customDim = serverPlayer.getServer().getWorld(customDimKey);

            if (currentWorld.getRegistryKey() == World.OVERWORLD) {
                // Save return location
                ReturnLocationStore.set(uuid, new ReturnLocationStore.Location(
                        user.getX(), user.getY(), user.getZ(),
                        user.getYaw(), user.getPitch()
                ));

                // Teleport to custom dimension
                if (customDim != null) {
                    serverPlayer.teleport(customDim, 0.5, 100, 0.5, user.getYaw(), user.getPitch());
                    user.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 1.0F, 1.0F);
                    user.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }

            } else if (currentWorld.getRegistryKey() == customDimKey) {
                if (ReturnLocationStore.has(uuid)) {
                    var loc = ReturnLocationStore.get(uuid);
                    ServerWorld overworld = serverPlayer.getServer().getWorld(World.OVERWORLD);
                    if (overworld != null) {
                        serverPlayer.teleport(overworld, loc.x, loc.y, loc.z, loc.yaw, loc.pitch);
                        user.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 1.0F, 1.0F);
                        user.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                    }
                }
            }
        }

        return stack;
    }
}

