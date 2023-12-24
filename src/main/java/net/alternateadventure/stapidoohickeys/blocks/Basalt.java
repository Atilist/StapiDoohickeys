package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.minecraft.block.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class Basalt extends FluidMotionless {
    public Basalt(Identifier identifier, Material material) {
        super(identifier, material);
        this.setTickRandomly(true);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        if (world.getBlockMeta(x, y, z) == 15) {
            world.setBlock(x, y, z, BlockListener.basaltSimple.id);
        }
    }
}
