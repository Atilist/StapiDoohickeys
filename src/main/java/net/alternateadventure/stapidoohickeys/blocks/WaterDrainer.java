package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class WaterDrainer extends LazyBlockTemplate {
    public WaterDrainer(Identifier identifier, Material material) {
        super(identifier, material);
        this.setTickRandomly(true);
    }

    @Override
    public int getTickRate() {
        return 1;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        for (int xOffset = -5; xOffset <= 5; xOffset++) {
            for (int yOffset = 1; yOffset <= 10; yOffset++) {
                for (int zOffset = -5; zOffset <= 5; zOffset++) {
                    int aboveId = world.getBlockId(x + xOffset, y + yOffset, z + zOffset);
                    if (aboveId == BlockListener.waterRealistic.id || aboveId == BlockListener.waterSimple.id || aboveId == Block.WATER.id || aboveId == Block.FLOWING_WATER.id) world.setBlock(x + xOffset, y + yOffset, z + zOffset, 0);
                }
            }
        }
        world.method_216(x, y, z, this.id, this.getTickRate());
    }

    @Override
    public void onBlockPlaced(World world, int x, int y, int z, BlockState replacedState) {
        super.onBlockPlaced(world, x, y, z, replacedState);
        world.method_216(x, y, z, this.id, this.getTickRate());
    }
}
