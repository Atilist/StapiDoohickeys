package net.alternateadventure.stapidoohickeys.structures;

import net.minecraft.block.Block;
import net.minecraft.class_239;
import net.minecraft.world.World;

import java.util.Random;

public class GameStarTower extends class_239 {

    @Override
    public boolean method_1142(World world, Random random, int x, int y, int z) {
        if (world.getBlockId(x, y, z) != Block.GRASS_BLOCK.id && world.getBlockId(x, y, z) != Block.SAND.id) {
            return false;
        }
        for (int i = -8; i < 8; i++) {
            for (int j = -8; j < 8; j++) {
                if (world.getBlockId(x + i, y, z + j) != Block.GRASS_BLOCK.id && world.getBlockId(x + i, y, z + j) != Block.SAND.id && world.getBlockId(x + i, y, z + j) != 0) {
                    return false;
                }
            }
        }
        for (int i = -8; i < 8; i++) {
            for (int j = -8; j < 8; j++) {
                if (world.getBlockId(x + i, y + 4, z + j) != 0) {
                    return false;
                }
            }
        }
        for (int i = -8; i < 8; i++) {
            for (int j = -8; j < 8; j++) {
                for (int k = 1; k < 4; k++) {
                    world.setBlock(x + i, y + k, z + j, 0);
                }
            }
        }
        for (int i = -6; i <= 6; i++) {
            for (int j = -6; j <= 6; j++) {
                world.setBlock(x + i, y, z + j, Block.STONE.id);
            }
        }
        for (int xInverter = -1; xInverter <= 1; xInverter+=2) {
            for (int zInverter = -1; zInverter <= 1; zInverter+=2) {
                world.setBlock(x + 7 * xInverter, y, z + zInverter, Block.STONE.id);
                world.setBlock(x + 7 * xInverter, y, z, Block.STONE.id);
                world.setBlock(x, y, z + 7 * zInverter, Block.STONE.id);
                world.setBlock(x + xInverter, y, z + 7 * zInverter, Block.STONE.id);
                world.setBlock(x + 5 * xInverter, y + 22, z + zInverter, Block.STONE.id);
                world.setBlock(x + 5 * xInverter, y + 22, z, Block.STONE.id);
                world.setBlock(x, y + 22, z + 5 * zInverter, Block.STONE.id);
                world.setBlock(x + xInverter, y + 22, z + 5 * zInverter, Block.STONE.id);
                world.setBlock(x + 8 * xInverter, y, z + zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 8 * xInverter, y, z + 2 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 8 * xInverter, y, z + 3 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 7 * xInverter, y, z + 3 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 7 * xInverter, y, z + 4 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 7 * xInverter, y, z + 5 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 6 * xInverter, y, z + 5 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 6 * xInverter, y, z + 6 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 5 * xInverter, y, z + 6 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 5 * xInverter, y, z + 7 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 4 * xInverter, y, z + 7 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 3 * xInverter, y, z + 7 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 3 * xInverter, y, z + 8 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 2 * xInverter, y, z + 8 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + xInverter, y, z + 8 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + xInverter, y, z + 8 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x, y, z + 8 * zInverter, Block.COBBLESTONE.id);
                world.setBlock(x + 8 * xInverter, y, z, Block.COBBLESTONE.id);
                for (int i = 1; i <= 19; i++) {
                    world.setBlock(x + 6 * xInverter, y + i, z + 3 * zInverter, Block.OBSIDIAN.id);
                    world.setBlock(x + 6 * xInverter, y + i, z + 4 * zInverter, Block.STONE.id);
                    world.setBlock(x + 5 * xInverter, y + i, z + 5 * zInverter, Block.OBSIDIAN.id);
                    world.setBlock(x + 4 * xInverter, y + i, z + 6 * zInverter, Block.STONE.id);
                    world.setBlock(x + 3 * xInverter, y + i, z + 6 * zInverter, Block.OBSIDIAN.id);
                    world.setBlock(x + 5 * xInverter, y + i, z + 3 * zInverter, Block.STONE.id);
                    world.setBlock(x + 5 * xInverter, y + i, z + 4 * zInverter, Block.STONE.id);
                    world.setBlock(x + 4 * xInverter, y + i, z + 5 * zInverter, Block.STONE.id);
                    world.setBlock(x + 3 * xInverter, y + i, z + 5 * zInverter, Block.STONE.id);
                }
                for (int i = 1; i <= 9; i++) {
                    world.setBlock(x + 7 * xInverter, y + i, z + 2 * zInverter, Block.OBSIDIAN.id);
                    world.setBlock(x + 7 * xInverter, y + i, z + zInverter, Block.GLASS.id);
                    world.setBlock(x + 7 * xInverter, y + i, z, Block.GLASS.id);
                    world.setBlock(x, y + i, z + 7 * zInverter, Block.GLASS.id);
                    world.setBlock(x + xInverter, y + i, z + 7 * zInverter, Block.GLASS.id);
                    world.setBlock(x + 2 * xInverter, y + i, z + 7 * zInverter, Block.OBSIDIAN.id);
                    world.setBlock(x + 6 * xInverter, y + i, z + 2 * zInverter, Block.STONE.id);
                    world.setBlock(x + 2 * xInverter, y + i, z + 6 * zInverter, Block.STONE.id);
                }
                world.setBlock(x + 6 * xInverter, y + 10, z + 2 * zInverter, Block.OBSIDIAN.id);
                world.setBlock(x + 6 * xInverter, y + 10, z + zInverter, Block.OBSIDIAN.id);
                world.setBlock(x + 6 * xInverter, y + 10, z, Block.OBSIDIAN.id);
                world.setBlock(x, y + 10, z + 6 * zInverter, Block.OBSIDIAN.id);
                world.setBlock(x + xInverter, y + 10, z + 6 * zInverter, Block.OBSIDIAN.id);
                world.setBlock(x + 2 * xInverter, y + 10, z + 6 * zInverter, Block.OBSIDIAN.id);
                world.setBlock(x + 5 * xInverter, y + 10, z + 2 * zInverter, Block.STONE.id);
                world.setBlock(x + 2 * xInverter, y + 10, z + 5 * zInverter, Block.STONE.id);
                for (int i = 11; i <= 19; i++) {
                    world.setBlock(x + 6 * xInverter, y + i, z + 2 * zInverter, Block.OBSIDIAN.id);
                    world.setBlock(x + 6 * xInverter, y + i, z + zInverter, Block.GLASS.id);
                    world.setBlock(x + 6 * xInverter, y + i, z, Block.GLASS.id);
                    world.setBlock(x, y + i, z + 6 * zInverter, Block.GLASS.id);
                    world.setBlock(x + xInverter, y + i, z + 6 * zInverter, Block.GLASS.id);
                    world.setBlock(x + 2 * xInverter, y + i, z + 6 * zInverter, Block.OBSIDIAN.id);
                    world.setBlock(x + 5 * xInverter, y + i, z + 2 * zInverter, Block.STONE.id);
                    world.setBlock(x + 2 * xInverter, y + i, z + 5 * zInverter, Block.STONE.id);
                }
                for (int i = 20; i <= 25; i++) {
                    world.setBlock(x + 5 * xInverter, y + i, z + 2 * zInverter, Block.STONE.id);
                    world.setBlock(x + 5 * xInverter, y + i, z + 3 * zInverter, Block.STONE.id);
                    world.setBlock(x + 4 * xInverter, y + i, z + 4 * zInverter, Block.OBSIDIAN.id);
                    world.setBlock(x + 3 * xInverter, y + i, z + 5 * zInverter, Block.STONE.id);
                    world.setBlock(x + 2 * xInverter, y + i, z + 5 * zInverter, Block.STONE.id);
                }
                generatePillar(world, random, x + 5 * xInverter, y + 24, z + 2 * zInverter, 3, Block.GLASS.id);
                generatePillar(world, random, x + 5 * xInverter, y + 23, z + zInverter, 5, Block.GLASS.id);
                generatePillar(world, random, x + 5 * xInverter, y + 23, z, 5, Block.GLASS.id);
                generatePillar(world, random, x, y + 23, z + 5 * zInverter, 5, Block.GLASS.id);
                generatePillar(world, random, x + xInverter, y + 23, z + 5 * zInverter, 5, Block.GLASS.id);
                generatePillar(world, random, x + 2 * xInverter, y + 24, z + 5 * zInverter, 3, Block.GLASS.id);
                world.setBlock(x + 4 * xInverter, y + 28, z, Block.GLASS.id);
                world.setBlock(x, y + 28, z + 4 * zInverter, Block.GLASS.id);
                world.setBlock(x + 3 * xInverter, y + 29, z, Block.GLASS.id);
                world.setBlock(x, y + 29, z + 3 * zInverter, Block.GLASS.id);
                world.setBlock(x + 2 * xInverter, y + 30, z, Block.GLASS.id);
                world.setBlock(x, y + 30, z + 2 * zInverter, Block.GLASS.id);
                world.setBlock(x + xInverter, y + 30, z, Block.GLASS.id);
                world.setBlock(x, y + 30, z + zInverter, Block.GLASS.id);
                world.setBlock(x + 4 * xInverter, y + 26, z + 3 * zInverter, Block.GLASS.id);
                world.setBlock(x + 3 * xInverter, y + 26, z + 4 * zInverter, Block.GLASS.id);
                world.setBlock(x + 4 * xInverter, y + 27, z + 2 * zInverter, Block.GLASS.id);
                world.setBlock(x + 3 * xInverter, y + 27, z + 3 * zInverter, Block.GLASS.id);
                world.setBlock(x + 2 * xInverter, y + 27, z + 4 * zInverter, Block.GLASS.id);
                world.setBlock(x + 4 * xInverter, y + 28, z + zInverter, Block.GLASS.id);
                world.setBlock(x + 3 * xInverter, y + 28, z + 2 * zInverter, Block.GLASS.id);
                world.setBlock(x + 2 * xInverter, y + 28, z + 3 * zInverter, Block.GLASS.id);
                world.setBlock(x + xInverter, y + 28, z + 4 * zInverter, Block.GLASS.id);
                world.setBlock(x + 3 * xInverter, y + 29, z + zInverter, Block.GLASS.id);
                world.setBlock(x + 2 * xInverter, y + 29, z + 2 * zInverter, Block.GLASS.id);
                world.setBlock(x + xInverter, y + 29, z + 3 * zInverter, Block.GLASS.id);
                world.setBlock(x + 2 * xInverter, y + 29, z + zInverter, Block.GLASS.id);
                world.setBlock(x + xInverter, y + 29, z + 2 * zInverter, Block.GLASS.id);
                world.setBlock(x + xInverter, y + 30, z + zInverter, Block.GLASS.id);
                generatePillar(world, random, x + 6 * xInverter, y + 20, z + 2 * zInverter, 2, Block.OBSIDIAN.id);
                generatePillar(world, random, x + 6 * xInverter, y + 21, z + zInverter, 2, Block.OBSIDIAN.id);
                world.setBlock(x + 6 * xInverter, y + 22, z, Block.OBSIDIAN.id);
                world.setBlock(x, y + 22, z + 6 * zInverter, Block.OBSIDIAN.id);
                generatePillar(world, random, x + xInverter, y + 21, z + 6 * zInverter, 2, Block.OBSIDIAN.id);
                generatePillar(world, random, x + 2 * xInverter, y + 20, z + 6 * zInverter, 2, Block.OBSIDIAN.id);
                world.setBlock(x + 6 * xInverter, y + 20, z + zInverter, Block.GLASS.id);
                world.setBlock(x + xInverter, y + 20, z + 6 * zInverter, Block.GLASS.id);
                generatePillar(world, random, x + 6 * xInverter, y + 20, z, 2, Block.GLASS.id);
                generatePillar(world, random, x, y + 20, z + 6 * zInverter, 2, Block.GLASS.id);
                world.setBlock(x + 4 * xInverter, y + 19, z + 4 * zInverter, Block.STONE.id);
                world.setBlock(x + 3 * xInverter, y + 20, z + 4 * zInverter, Block.STONE.id);
                world.setBlock(x + 4 * xInverter, y + 20, z + 3 * zInverter, Block.STONE.id);
                world.setBlock(x + 7 * xInverter, y + 1, z, 0);
                world.setBlock(x, y + 1, z + 7 * zInverter, 0);
                world.setBlock(x + 7 * xInverter, y + 2, z, 0);
                world.setBlock(x, y + 2, z + 7 * zInverter, 0);
            }
        }
        world.setBlock(x, y + 30, z, Block.GLASS.id);
        generateFloor(world, random, x, y + 12, z);
        generateFloor(world, random, x, y + 16, z);
        generateFloor(world, random, x, y + 21, z);

        /*
        * Add dungeon code below this comment
        * Relative y-coordinates of floors (place dungeon blocks one above):
        * 0
        * 12
        * 16
        * 21
        */

        return true;
    }

    private void generateFloor(World world, Random random, int x, int y, int z) {
        for (int i = -6; i <= 6; i++) {
            generateLine(world, random, x, y, z + i);
        }
        world.setBlock(x, y, z, 0);
        world.setBlock(x + 1, y, z + 1, 0);
        world.setBlock(x + 1, y, z - 1, 0);
        world.setBlock(x - 1, y, z + 1, 0);
        world.setBlock(x - 1, y, z - 1, 0);
        world.setBlock(x + 1, y, z, 0);
        world.setBlock(x - 1, y, z, 0);
        world.setBlock(x, y, z + 1, 0);
        world.setBlock(x, y, z - 1, 0);
    }

    private void generateLine(World world, Random random, int x, int y, int z) {
        boolean insideTower = false;
        boolean insideWall = false;
        for (int i = -6; i <= 6; i++) {
            if (!insideTower) {
                if (world.getBlockId(x + i, y, z) != 0) {
                    insideWall = true;
                    continue;
                } else if (insideWall) {
                    insideWall = false;
                    insideTower = true;
                    if (i > 0) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            if (world.getBlockId(x + i, y, z) != 0) {
                break;
            }
            world.setBlock(x + i, y, z, Block.STONE.id);
        }
    }

    private void generatePillar(World world, Random random, int x, int y, int z, int height, int id) {
        for (int i = 0; i < height; i++) {
            world.setBlock(x, y + i, z, id);
        }
    }
}
