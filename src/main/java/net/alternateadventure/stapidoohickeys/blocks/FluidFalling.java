package net.alternateadventure.stapidoohickeys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class FluidFalling extends FluidMotionless {
    private final int tickRate;
    protected boolean hasFallen = false;
    protected int optimizedBlockId = -1;
    protected float density;

    public FluidFalling(Identifier identifier, Material material, int tickRate, float density) {
        super(identifier, material);
        this.setTickRandomly(true);
        this.tickRate = tickRate;
        this.density = density;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        if (world.getBlockId(x, y - 1, z) == 0) {
            lowerBlock(world, x, y, z);
            hasFallen = true;
        } else if (world.getBlockId(x, y - 1, z) == this.id && world.getBlockMeta(x, y - 1, z) < 15) {
            int leftovers = fillBlock(world, x, y - 1, z, world.getBlockMeta(x, y, z) + 1);
            if (leftovers == -1) {
                world.setBlock(x, y, z, 0);
            } else {
                world.setBlock(x, y, z, this.id, leftovers);
            }
            hasFallen = true;
        }
        if (world.getBlockId(x, y + 1, z) == this.id) {
            world.scheduleBlockUpdate(x, y, z, this.id, this.getTickRate());
            return;
        }
        int pressure = 0;
        int height = y;
        for (; height >= 0; height--) {
            if (world.getBlockId(x, height, z) == this.id) {
                pressure += world.getBlockMeta(x, height, z) + 1;
            } else if (optimizedBlockId != -1 && world.getBlockId(x, height, z) == optimizedBlockId) {
                pressure += 16;
            } else {
                break;
            }
        }
        pressure *= density;
        crushBlock(world, x, height, z, pressure);
        world.scheduleBlockUpdate(x, y, z, this.id, this.getTickRate());
    }

    public void lowerBlock(World world, int x, int y, int z) {
        world.setBlock(x, y - 1, z, this.id, world.getBlockMeta(x, y, z));
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
        world.setBlock(x, y, z, this.id, totalQuantity);
        return leftovers - 1;
    }

    public void setOptimizedBlockId(int optimizedBlockId) {
        this.optimizedBlockId = optimizedBlockId;
    }

    public void crushBlock(World world, int x, int y, int z, float pressure) {
        int blockId = world.getBlockId(x, y, z);
        if (blockId == this.id || blockId == optimizedBlockId) {
            return;
        }
        Block block = Block.BLOCKS[blockId];
        if (block == null) {
            return;
        }
        float hardness = block.getHardness() * 10;
        float blastResistance = block.getBlastResistance(null) * 10;
        boolean airBelow = false;
        for (int i = 1; i <= 5; i++) {
            if (world.getBlockId(x, y - i, z) == 0) {
                airBelow = true;
                break;
            } else {
                block = Block.BLOCKS[world.getBlockId(x, y - i, z)];
                if (block == null) {
                    continue;
                }
                hardness += block.getHardness() * 10;
                blastResistance += block.getBlastResistance(null) * 10;
            }
        }
        if (pressure > hardness + blastResistance && airBelow) {
            world.setBlock(x, y, z, 0);
        }
    }

    @Override
    public int getTickRate() {
        return tickRate;
    }

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        world.scheduleBlockUpdate(x, y, z, this.id, this.getTickRate());
    }

    @Override
    public void onBlockPlaced(World world, int x, int y, int z, BlockState replacedState) {
        super.onBlockPlaced(world, x, y, z, replacedState);
        world.scheduleBlockUpdate(x, y, z, this.id, this.getTickRate());
    }

}
