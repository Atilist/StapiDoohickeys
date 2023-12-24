package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.minecraft.block.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class WaterGenerator extends LazyBlockTemplate {
    public WaterGenerator(Identifier identifier, Material material) {
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
            if (world.getBlockId(x, i, z) == 0) {
                world.method_154(x, i, z, BlockListener.waterRealistic.id, 15);
                break;
            }
        }
        world.method_216(x, y, z, this.id, this.getTickRate());
    }

    @Override
    public int getTickRate() {
        return 8;
    }

    @Override
    public void onBlockPlaced(World world, int x, int y, int z, BlockState replacedState) {
        super.onBlockPlaced(world, x, y, z, replacedState);
        world.method_216(x, y, z, this.id, this.getTickRate());
    }
}
