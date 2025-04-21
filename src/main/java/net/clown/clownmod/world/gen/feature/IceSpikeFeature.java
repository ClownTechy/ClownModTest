package net.clown.clownmod.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class IceSpikeFeature extends Feature<DefaultFeatureConfig> {
    public IceSpikeFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        StructureWorldAccess world = context.getWorld();

        while (world.isAir(pos) && pos.getY() > world.getBottomY() + 2) {
            pos = pos.down();
        }

        if (!world.getBlockState(pos).isOf(Blocks.ICE)) {
            return false; // Only generate where ice is found
        } else {
            pos = pos.up(random.nextInt(4));
            int spikeHeight = random.nextInt(4) + 7;

            for (int i = 0; i < spikeHeight; i++) {
                float radius = (1.0F - (float) i / spikeHeight);
                int spread = (int) (radius * 3);  // Spread determines the "width" of the spike.

                for (int x = -spread; x <= spread; x++) {
                    for (int z = -spread; z <= spread; z++) {
                        if (Math.abs(x) != spread && Math.abs(z) != spread) {
                            BlockPos newPos = pos.add(x, i, z);
                            world.setBlockState(newPos, Blocks.AMETHYST_BLOCK.getDefaultState(), 3);  // Replace with amethyst
                        }
                    }
                }
            }

            return true;
        }
    }
}
