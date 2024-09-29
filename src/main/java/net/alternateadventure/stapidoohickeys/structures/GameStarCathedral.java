package net.alternateadventure.stapidoohickeys.structures;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class GameStarCathedral extends Feature {

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        // Foundation
        for (int xOffset = -2; xOffset < 127; xOffset++) {
            for (int zOffset = -22; zOffset <= 22; zOffset++) {
                for (int yOffset = 1; yOffset <= 3; yOffset++) {
                    world.setBlock(x + xOffset, y + yOffset, z + zOffset, Block.STONE.id);
                }
                world.setBlock(x + xOffset, y + 1, z + zOffset, Block.STONE.id);
            }
        }
        for (int xOffset = -3; xOffset < 128; xOffset++) {
            for (int zOffset = -23; zOffset <= 23; zOffset++) {
                world.setBlock(x + xOffset, y + 1, z + zOffset, Block.STONE.id);
            }
        }

        // Floor carpet
        for (int xOffset = 0; xOffset < 125; xOffset++) {
            for (int zOffset = -20; zOffset <= 20; zOffset++) {
                world.setBlock(x + xOffset, y + 3, z + zOffset, Block.WOOL.id);
            }
        }
        for (int i = 0; i < 125; i++) {
            for (int j = -3; j <= 3; j++) {
                world.setBlock(x + i, y + 3, z + j, Block.WOOL.id, 14);
            }
        }

        // Main pillars
        for (int i = 0; i < 3; i++) {
            generatePillar(world, x + 11 * i + 13, y + 3, z + 11, 9);
            generatePillar(world, x + 11 * i + 13, y + 3, z - 11, 9);

            generatePillar(world, x + 11 * i + 13, y + 2, z + 22, 18);
            generatePillar(world, x + 11 * i + 13, y + 2, z - 22, 18);

            generateWall(world, x + 11 * i + 15, y, z);
        }
        for (int i = 0; i < 4; i++) {
            generatePillar(world, x + 11 * i + 79, y + 3, z + 11, 9);
            generatePillar(world, x + 11 * i + 79, y + 3, z - 11, 9);

            generatePillar(world, x + 11 * i + 79, y + 2, z + 22, 18);
            generatePillar(world, x + 11 * i + 79, y + 2, z - 22, 18);

            generateWall(world, x + 11 * i + 70, y, z);
        }

        // Central altar
        generateRhombus(world, x + 57, y + 5, z, 13, Block.SLAB.id);
        generateRhombus(world, x + 57, y + 5, z, 11, Block.DOUBLE_SLAB.id);
        generateRhombus(world, x + 57, y + 5, z, 10, Block.STONE.id);
        generateRhombus(world, x + 57, y + 5, z, 9, Block.WOOL.id, 10);
        generateRhombus(world, x + 57, y + 5, z, 8, Block.WOOL.id);

        generateSquare(world, x + 57, y + 4, z, 12, Block.SLAB.id);
        generateRhombus(world, x + 57, y + 4, z, 16, Block.SLAB.id);
        generateRhombus(world, x + 57, y + 4, z, 14, Block.DOUBLE_SLAB.id);
        generateSquare(world, x + 57, y + 4, z, 11, Block.DOUBLE_SLAB.id);
        generateSquare(world, x + 57, y + 4, z, 10, Block.STONE.id);

        // Central section and 2 side parts
        generateRectangle(world, x + 57, y + 1, z + 27, 9, 7, Block.STONE.id);
        generateRectangle(world, x + 57, y + 1, z - 27, 9, 7, Block.STONE.id);
        generateRectangle(world, x + 57, y + 2, z + 27, 9, 7, Block.STONE.id);
        generateRectangle(world, x + 57, y + 2, z - 27, 9, 7, Block.STONE.id);
        generateRectangle(world, x + 57, y + 3, z + 27, 9, 7, Block.WOOL.id);
        generateRectangle(world, x + 57, y + 3, z - 27, 9, 7, Block.WOOL.id);

        for (int height = 1; height <= 3; height++) {
            int blockId = Block.STONE.id;
            if (height == 3) blockId = Block.WOOL.id;
            generateRectangle(world, x + 57, y + height, z + 35, 8, 1, blockId);
            generateRectangle(world, x + 57, y + height, z - 35, 8, 1, blockId);
            generateRectangle(world, x + 57, y + height, z + 37, 7, 0, blockId);
            generateRectangle(world, x + 57, y + height, z - 37, 7, 0, blockId);
            generateRectangle(world, x + 57, y + height, z + 38, 5, 0, blockId);
            generateRectangle(world, x + 57, y + height, z - 38, 5, 0, blockId);
            generateRectangle(world, x + 57, y + height, z + 39, 2, 0, blockId);
            generateRectangle(world, x + 57, y + height, z - 39, 2, 0, blockId);
        }

        generateDottedLine(world, x + 62, y + 3, z + 11, 22, 2, 0, 1, Block.GLOWSTONE.id);
        generateDottedLine(world, x + 64, y + 3, z + 11, 22, 2, 0, 1, Block.GLOWSTONE.id);
        generateDottedLine(world, x + 62, y + 3, z - 11, 22, 2, 0, -1, Block.GLOWSTONE.id);
        generateDottedLine(world, x + 64, y + 3, z - 11, 22, 2, 0, -1, Block.GLOWSTONE.id);

        generateDottedLine(world, x + 52, y + 3, z + 11, 22, 2, 0, 1, Block.GLOWSTONE.id);
        generateDottedLine(world, x + 50, y + 3, z + 11, 22, 2, 0, 1, Block.GLOWSTONE.id);
        generateDottedLine(world, x + 52, y + 3, z - 11, 22, 2, 0, -1, Block.GLOWSTONE.id);
        generateDottedLine(world, x + 50, y + 3, z - 11, 22, 2, 0, -1, Block.GLOWSTONE.id);

        generatePillar(world, x + 46, y + 3, z + 11, 17);
        generatePillar(world, x + 46, y + 3, z - 11, 17);

        generatePillar(world, x + 46, y + 2, z + 22, 18);
        generatePillar(world, x + 46, y + 2, z - 22, 18);

        generatePillar(world, x + 68, y + 3, z + 11, 17);
        generatePillar(world, x + 68, y + 3, z - 11, 17);

        generatePillar(world, x + 68, y + 2, z + 22, 18);
        generatePillar(world, x + 68, y + 2, z - 22, 18);
        return true;
    }

    private void generatePillar(World world, int x, int y, int z, int height) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = 0; k < height; k++) {
                    world.setBlock(x + i, y + k, z + j, Block.STONE.id);
                }
            }
        }
    }

    private void generateSquare(World world, int x, int y, int z, int width, int blockId) {
        this.generateRectangle(world, x, y, z, width, width, blockId);
    }

    private void generateRectangle(World world, int x, int y, int z, int width, int length, int blockId) {
        for (int xOffset = -width; xOffset <= width; xOffset++) {
            for (int zOffset = -length; zOffset <= length; zOffset++) {
                world.setBlock(x + xOffset, y, z + zOffset, blockId);
            }
        }
    }

    private void generateRhombus(World world, int x, int y, int z, int width, int blockId) {
        this.generateRhombus(world, x, y, z, width, blockId, 0);
    }

    private void generateRhombus(World world, int x, int y, int z, int width, int blockId, int meta) {
        for (int xOffset = -width; xOffset <= width; xOffset++) {
            for (int zOffset = -width; zOffset <= width; zOffset++) {
                if (Math.abs(xOffset) + Math.abs(zOffset) > width) continue;
                world.setBlock(x + xOffset, y, z + zOffset, blockId, meta); // I really should update my mappings
            }
        }
    }

    private void generateDottedLine(World world, int x, int y, int z, int length, int spacing, int xDirection, int zDirection, int blockId) {
        for (int offset = 1; offset <= length; offset++) {
            if (offset % spacing != 0) continue;
            world.setBlock(x + offset * xDirection, y, z + offset * zDirection, blockId);
        }
    }

    private void generateWall(World world, int x, int y, int z) {
        for (int xOffset = 0; xOffset < 8; xOffset++) {
            for (int yOffset = 4; yOffset <= 19; yOffset++) {
                world.setBlock(x + xOffset, y + yOffset, z + 22, Block.BRICKS.id);
                world.setBlock(x + xOffset, y + yOffset, z - 22, Block.BRICKS.id);
                world.setBlock(x + xOffset, y + yOffset, z + 21, Block.SANDSTONE.id);
                world.setBlock(x + xOffset, y + yOffset, z - 21, Block.SANDSTONE.id);
            }
        }
        for (int yOffset = 6; yOffset < 16; yOffset++) {
            world.setBlock(x + 3, y + yOffset, z + 22, 0);
            world.setBlock(x + 3, y + yOffset, z - 22, 0);
            world.setBlock(x + 4, y + yOffset, z + 22, 0);
            world.setBlock(x + 4, y + yOffset, z - 22, 0);
            world.setBlock(x + 3, y + yOffset, z + 21, Block.GLASS.id);
            world.setBlock(x + 3, y + yOffset, z - 21, Block.GLASS.id);
            world.setBlock(x + 4, y + yOffset, z + 21, Block.GLASS.id);
            world.setBlock(x + 4, y + yOffset, z - 21, Block.GLASS.id);
        }
        for (int yOffset = 6; yOffset < 13; yOffset++) {
            world.setBlock(x + 1, y + yOffset, z + 22, 0);
            world.setBlock(x + 1, y + yOffset, z - 22, 0);
            world.setBlock(x + 6, y + yOffset, z + 22, 0);
            world.setBlock(x + 6, y + yOffset, z - 22, 0);
            world.setBlock(x + 1, y + yOffset, z + 21, Block.GLASS.id);
            world.setBlock(x + 1, y + yOffset, z - 21, Block.GLASS.id);
            world.setBlock(x + 6, y + yOffset, z + 21, Block.GLASS.id);
            world.setBlock(x + 6, y + yOffset, z - 21, Block.GLASS.id);
        }
    }
}
