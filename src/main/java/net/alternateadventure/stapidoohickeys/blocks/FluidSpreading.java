package net.alternateadventure.stapidoohickeys.blocks;

import net.minecraft.block.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class FluidSpreading extends FluidFalling{
    public FluidSpreading(Identifier identifier, Material material, int tickRate) {
        super(identifier, material, tickRate);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        super.onTick(world, x, y, z, random);
        if (hasFallen) {
            hasFallen = false;
            return;
        }
        int leftoverQuantity = 0;
        int sourceQuantity = world.getBlockMeta(x, y, z);
        int fillQuantity = (world.getBlockMeta(x, y, z) + 1) / 2;
        int side = random.nextInt(4);
        switch (side) {
            case 0 -> leftoverQuantity = spreadFluid(world, x + 1, y, z, fillQuantity, sourceQuantity);
            case 1 -> leftoverQuantity = spreadFluid(world, x - 1, y, z, fillQuantity, sourceQuantity);
            case 2 -> leftoverQuantity = spreadFluid(world, x, y, z + 1, fillQuantity, sourceQuantity);
            case 3 -> leftoverQuantity = spreadFluid(world, x, y, z - 1, fillQuantity, sourceQuantity);
        }
        if (leftoverQuantity == -1) {
            world.setBlock(x, y, z, 0);
        } else {
            world.method_154(x, y, z, this.id, leftoverQuantity);
        }
    }

    public int spreadFluid(World world, int x, int y, int z, int fillQuantity, int sourceQuantity) {
        int targetQuantity = world.getBlockMeta(x, y, z);
        if (fillQuantity < 1 || targetQuantity >= sourceQuantity - fillQuantity) {
            return sourceQuantity;
        }
        if (world.getBlockId(x, y, z) == this.id) {
            return fillBlock(world, x, y, z, fillQuantity) + sourceQuantity - fillQuantity;
        } else if (world.getBlockId(x, y, z) == 0) {
            world.method_154(x, y, z, this.id, fillQuantity);
            return sourceQuantity - fillQuantity;
        }
        return sourceQuantity;
    }
}
