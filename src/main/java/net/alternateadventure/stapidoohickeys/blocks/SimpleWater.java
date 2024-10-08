package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class SimpleWater extends LazyBlockTemplate {
    public SimpleWater(Identifier identifier, Material material) {
        super(identifier, material);
        setOpacity(3);
    }

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        if (isStuck(world, x, y, z)) {
            return;
        }
        world.setBlock(x, y, z, BlockListener.realisticWater.id, 15);
    }

    public boolean isStuck(World world, int x, int y, int z) {
        return canNotMoveHere(world, x + 1, y, z) &&
                canNotMoveHere(world, x - 1, y, z) &&
                canNotMoveHere(world, x, y - 1, z) &&
                canNotMoveHere(world, x, y, z + 1) &&
                canNotMoveHere(world, x, y, z - 1);
    }

    public boolean canNotMoveHere(World world, int x, int y, int z) {
        if (world.getBlockId(x, y, z) == 0) {
            return false;
        } else return world.getBlockId(x, y, z) != BlockListener.realisticWater.id || world.getBlockMeta(x, y, z) >= 15;
    }

    @Environment(EnvType.CLIENT)
    public int getRenderLayer() {
        return 1;
    }

    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}