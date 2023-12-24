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
        int fillQuantity;
        if (world.getBlockId(x, y + 1, z) == this.id && sourceQuantity == 15) {
            fillQuantity = 7 + world.getBlockMeta(x, y + 1, z) / 2;
            sourceQuantity += world.getBlockMeta(x, y + 1, z);
        } else {
            fillQuantity = world.getBlockMeta(x, y, z) / 2;
        }
        int side = random.nextInt(4);
        switch (side) {
            case 0 -> leftoverQuantity = spreadFluid(world, x + 1, y, z, fillQuantity + 1, sourceQuantity);
            case 1 -> leftoverQuantity = spreadFluid(world, x - 1, y, z, fillQuantity + 1, sourceQuantity);
            case 2 -> leftoverQuantity = spreadFluid(world, x, y, z + 1, fillQuantity + 1, sourceQuantity);
            case 3 -> leftoverQuantity = spreadFluid(world, x, y, z - 1, fillQuantity + 1, sourceQuantity);
        }
        if (leftoverQuantity <= -1) {
            return;
        }
        if (sourceQuantity > 15 && leftoverQuantity < 15) {
            world.setBlock(x, y + 1, z, 0);
            world.method_154(x, y, z, this.id, leftoverQuantity + 1);
        } else if (leftoverQuantity > 15) {
            if (world.getBlockMeta(x, y + 1, z) < 15) {
                world.method_154(x, y + 1, z, this.id, leftoverQuantity - 15);
            } else {
                world.setBlock(x, y + 1, z, 0);
            }
        } else {
            world.method_154(x, y, z, this.id, leftoverQuantity);
        }
    }

    public int spreadFluid(World world, int x, int y, int z, int fillQuantity, int sourceQuantity) {
        if (world.getBlockId(x, y, z) != this.id && world.getBlockId(x, y, z) != 0) {
            return -1;
        }
        int targetQuantity = world.getBlockMeta(x, y, z);
        if (targetQuantity >= sourceQuantity - fillQuantity || targetQuantity == 15) {
            return -1;
        }
        if (world.getBlockId(x, y, z) == this.id) {
            return fillBlock(world, x, y, z, fillQuantity) + sourceQuantity - fillQuantity;
        } else if (world.getBlockId(x, y, z) == 0) {
            world.method_154(x, y, z, this.id, fillQuantity - 1);
            return sourceQuantity - fillQuantity;
        }
        return -1;
    }
}
