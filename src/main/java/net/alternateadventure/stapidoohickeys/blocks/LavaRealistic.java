package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.minecraft.block.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class LavaRealistic extends FluidSpreading {
    public LavaRealistic(Identifier identifier, Material material, int tickRate) {
        super(identifier, material, tickRate);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        super.onTick(world, x, y, z, random);
        if (random.nextInt(32) == 0 && world.getBlockId(x, y - 1, z) != this.id && world.getBlockId(x, y - 1, z) != BlockListener.lavaGenerator.id) {
            world.method_154(x, y, z, BlockListener.basaltHot.id, world.getBlockMeta(x, y, z));
            return;
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
        } else if (BlockListener.convertedByLava.get(world.getBlockId(x, y - 1, z)) != null) {
            int convertedBlock = BlockListener.convertedByLava.get(world.getBlockId(x, y - 1, z));
            world.setBlock(x, y - 1, z, convertedBlock);
        }
        if (world.getBlockId(x, y + 1, z) == BlockListener.basaltHot.id) {
            world.method_154(x, y + 1, z, this.id, world.getBlockMeta(x, y + 1, z));
        } else if (world.getBlockId(x, y + 1, z) == BlockListener.basalt.id) {
            world.method_154(x, y + 1, z, BlockListener.basaltHot.id, world.getBlockMeta(x, y + 1, z));
        }
    }
}
