package net.alternateadventure.stapidoohickeys.blocks;

import net.minecraft.block.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class FluidFalling extends FluidMotionless {
    private final int tickRate;
    protected boolean hasFallen = false;

    public FluidFalling(Identifier identifier, Material material, int tickRate) {
        super(identifier, material);
        this.setTickRandomly(true);
        this.tickRate = tickRate;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        if (world.getBlockId(x, y - 1, z) == 0) {
            lowerBlock(world, x, y, z);
            hasFallen = true;
        } else if (world.getBlockId(x, y - 1, z) == this.id && world.getBlockMeta(x, y, z) < 15) {
            int leftovers = fillBlock(world, x, y - 1, z, world.getBlockMeta(x, y, z) + 1);
            if (leftovers == -1) {
                world.setBlock(x, y, z, 0);
            } else {
                world.method_154(x, y, z, this.id, leftovers);
            }
            hasFallen = true;
        }
        world.method_216(x, y, z, this.id, this.getTickRate());
    }

    public void lowerBlock(World world, int x, int y, int z) {
        world.method_154(x, y - 1, z, this.id, world.getBlockMeta(x, y, z));
        world.setBlock(x, y, z, 0);
    }

    public int fillBlock(World world, int x, int y, int z, int fillQuantity) {
        int leftovers = 0;
        int existingQuantity = world.getBlockMeta(x, y, z);
        int totalQuantity = existingQuantity + fillQuantity;
        if (totalQuantity >= 16) {
            leftovers = totalQuantity - 15;
        }
        if (totalQuantity > 15) {
            totalQuantity = 15;
        }
        world.method_154(x, y, z, this.id, totalQuantity);
        return leftovers - 1;
    }

    @Override
    public int getTickRate() {
        return tickRate;
    }

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        world.method_216(x, y, z, this.id, this.getTickRate());
    }

    @Override
    public void onBlockPlaced(World world, int x, int y, int z, BlockState replacedState) {
        super.onBlockPlaced(world, x, y, z, replacedState);
        world.method_216(x, y, z, this.id, this.getTickRate());
    }

}
