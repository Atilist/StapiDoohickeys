package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class WaterRealistic extends FluidSpreading {
    public WaterRealistic(Identifier identifier, Material material, int tickRate) {
        super(identifier, material, tickRate, 1.0F);
        setOpacity(3);
    }

    @Environment(EnvType.CLIENT)
    public int getRenderLayer() {
        return 1;
    }

    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        int selfMeta = world.getBlockMeta(x, y, z);
        if (selfMeta == 15 && isStuck(world, x, y, z)) {
            world.setBlock(x, y, z, BlockListener.waterSimple.id);
            return;
        }
        if (random.nextInt(32 + 64 * selfMeta) == 0) {
            if (selfMeta == 0) {
                world.setBlock(x, y, z, 0);
                return;
            }
            world.method_154(x, y, z, this.id, selfMeta - 1);
        }
        if (world.getBlockMeta(x, y, z) < 15) {
            activateStaticWater(world, x + 1, y, z);
            activateStaticWater(world, x - 1, y, z);
            activateStaticWater(world, x, y + 1, z);
            activateStaticWater(world, x, y, z + 1);
            activateStaticWater(world, x, y, z - 1);
            activateRegularWater(world, x + 1, y, z);
            activateRegularWater(world, x - 1, y, z);
            activateRegularWater(world, x, y + 1, z);
            activateRegularWater(world, x, y - 1, z);
            activateRegularWater(world, x, y, z + 1);
            activateRegularWater(world, x, y, z - 1);
        }
        super.onTick(world, x, y, z, random);
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
        } else return world.getBlockId(x, y, z) != BlockListener.waterRealistic.id || world.getBlockMeta(x, y, z) >= 15;
    }

    public void activateStaticWater(World world, int x, int y, int z) {
        if (world.getBlockId(x, y, z) == BlockListener.waterSimple.id) {
            world.method_154(x, y, z, this.id, 15);
        }
    }

    public void activateRegularWater(World world, int x, int y, int z) {
        if (world.getBlockId(x, y, z) == Block.WATER.id || world.getBlockId(x, y, z) == Block.FLOWING_WATER.id) {
            world.setBlock(x, y, z, BlockListener.waterSimple.id);
        }
    }
}
