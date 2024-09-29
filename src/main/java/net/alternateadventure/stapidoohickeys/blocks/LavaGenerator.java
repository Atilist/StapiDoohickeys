package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class LavaGenerator extends LazyBlockTemplate {
    public LavaGenerator(Identifier identifier, Material material) {
        super(identifier, material);
        this.setTickRandomly(true);
    }

    public void setTextureId(int textureId) {
        this.textureId = textureId;
    }

    @Override
    public int getTexture(int side) {
        return textureId;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        for (int i = y + 1; i < 128; i++) {
            if (world.getBlockId(x, i, z) == BlockListener.basaltSimple.id) {
                world.setBlock(x, i, z, BlockListener.realisticLava.id, 15);
            } else if (world.getBlockId(x, i, z) == BlockListener.basalt.id || world.getBlockId(x, i, z) == BlockListener.hotBasalt.id) {
                world.setBlock(x, i, z, BlockListener.realisticLava.id, world.getBlockMeta(x, i, z));
            } else if (world.getBlockId(x, i, z) == 0) {
                world.setBlock(x, i, z, BlockListener.realisticLava.id, 15);
                break;
            }
        }
        world.scheduleBlockUpdate(x, y, z, this.id, this.getTickRate());
    }

    @Override
    public int getTickRate() {
        return 8;
    }

    @Override
    public void onBlockPlaced(World world, int x, int y, int z, BlockState replacedState) {
        super.onBlockPlaced(world, x, y, z, replacedState);
        world.scheduleBlockUpdate(x, y, z, this.id, this.getTickRate());
    }
}
