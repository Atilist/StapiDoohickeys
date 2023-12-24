package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.minecraft.block.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class BasaltHot extends FluidFalling {
    public BasaltHot(Identifier identifier, Material material, int tickRate) {
        super(identifier, material, tickRate);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        super.onTick(world, x, y, z, random);
        if (hasFallen) {
            hasFallen = false;
            return;
        }
        if (world.getBlockId(x, y - 1, z) == BlockListener.lavaGenerator.id) {
            world.method_154(x, y, z, BlockListener.lavaRealistic.id, world.getBlockMeta(x, y, z));
        } else if (world.getBlockId(x, y - 1, z) == BlockListener.basalt.id && world.getBlockMeta(x, y - 1, z) < 15) {
            world.method_154(x, y - 1, z, this.id, world.getBlockMeta(x, y - 1, z));
        } else if (random.nextInt(256) == 0) {
            world.method_154(x, y, z, BlockListener.basalt.id, world.getBlockMeta(x, y, z));
        }
    }
}
