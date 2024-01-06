package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.minecraft.block.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class LavaRealistic extends FluidSpreading {
    public LavaRealistic(Identifier identifier, Material material, int tickRate) {
        super(identifier, material, tickRate);
        this.setLuminance(1.0F);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        super.onTick(world, x, y, z, random);
        if (random.nextInt(4096) == 0 && world.getBlockId(x, y - 1, z) == BlockListener.lavaRealistic.id && world.getBlockMeta(x, y - 1, z) == 15 && world.getBlockId(x, y + 1, z) == 0) {
            world.method_154(x, y, z, BlockListener.basaltHot.id, world.getBlockMeta(x, y, z));
            return;
        }
        if (random.nextInt(128) == 0 && !(world.getBlockId(x, y - 1, z) == this.id && world.getBlockMeta(x, y - 1, z) < 15) && world.getBlockId(x, y - 1, z) != BlockListener.lavaGenerator.id) {
            int surroundingLava = 0;
            surroundingLava += getSurroundingLava(world, x + 1, y, z);
            surroundingLava += getSurroundingLava(world, x - 1, y, z);
            surroundingLava += getSurroundingLava(world, x, y - 1, z);
            surroundingLava += getSurroundingLava(world, x, y, z + 1);
            surroundingLava += getSurroundingLava(world, x, y, z - 1);
            if (surroundingLava < world.getBlockMeta(x, y, z) + 64) {
                world.method_154(x, y, z, BlockListener.basaltHot.id, world.getBlockMeta(x, y, z));
                return;
            }
        }
        if (world.getBlockId(x, y - 1, z) == BlockListener.basaltHot.id) {
            if (random.nextInt(2) == 0) {
                world.method_154(x, y - 1, z, this.id, world.getBlockMeta(x, y - 1, z));
            } else {
                world.method_154(x, y, z, BlockListener.basaltHot.id, world.getBlockMeta(x, y, z));
            }
        } else if (world.getBlockId(x, y - 1, z) == BlockListener.basalt.id && world.getBlockMeta(x, y - 1, z) < 15) {
            if (random.nextInt(2) > 0) {
                world.method_154(x, y - 1, z, BlockListener.basaltHot.id, world.getBlockMeta(x, y - 1, z));
            } else {
                world.method_154(x, y, z, BlockListener.basaltHot.id, world.getBlockMeta(x, y, z));
            }
        }
        if (world.getBlockId(x, y + 1, z) == BlockListener.basaltHot.id) {
            if (random.nextInt(8) == 0) {
                world.method_154(x, y + 1, z, this.id, world.getBlockMeta(x, y + 1, z));
            } else {
                world.method_154(x, y, z, BlockListener.basaltHot.id, world.getBlockMeta(x, y, z));
            }
        } else if (world.getBlockId(x, y + 1, z) == BlockListener.basalt.id) {
            world.method_154(x, y + 1, z, BlockListener.basaltHot.id, world.getBlockMeta(x, y + 1, z));
        }
        convertBlock(world, x + 1, y, z);
        convertBlock(world, x - 1, y, z);
        convertBlock(world, x, y + 1, z);
        convertBlock(world, x, y - 1, z);
        convertBlock(world, x, y, z + 1);
        convertBlock(world, x, y, z - 1);
    }

    public void convertBlock(World world, int x, int y, int z) {
        if (BlockListener.convertedByLava.get(world.getBlockId(x, y, z)) != null) {
            int convertedBlock = BlockListener.convertedByLava.get(world.getBlockId(x, y, z));
            world.setBlock(x, y, z, convertedBlock);
        }
    }

    public int getSurroundingLava(World world, int x, int y, int z) {
        if (world.getBlockId(x, y, z) != BlockListener.lavaRealistic.id) {
            return 0;
        }
        else return world.getBlockMeta(x, y, z) + 1;
    }

    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }
}
