package net.alternateadventure.stapidoohickeys.structures;

import net.minecraft.block.Block;
import net.minecraft.class_239;
import net.minecraft.world.World;

import java.util.Random;

public class GameStarCathedral extends class_239 {

    @Override
    public boolean method_1142(World world, Random random, int x, int y, int z) {
        for (int i = 0; i < 125; i++) {
            for (int j = -20; j <= 20; j++) {
                for (int k = 1; k <= 2; k++) {
                    world.setBlock(x + i, y + k, z + j, Block.STONE.id);
                }
                world.setBlock(x + i, y + 3, z + j, Block.WOOL.id);
            }
        }
        for (int i = 0; i < 125; i++) {
            for (int j = -3; j <= 3; j++) {
                world.method_154(x + i, y + 3, z + j, Block.WOOL.id, 14);
            }
        }
        for (int i = 0; i < 3; i++) {
            generatePillar(world, x + 11 * i + 10, y + 3, z + 10, 9);
            generatePillar(world, x + 11 * i + 10, y + 3, z - 10, 9);
        }
        for (int i = 0; i < 4; i++) {
            generatePillar(world, x + 11 * i + 78, y + 3, z + 10, 9);
            generatePillar(world, x + 11 * i + 78, y + 3, z - 10, 9);
        }
        generatePillar(world, x + 43, y + 3, z + 10, 17);
        generatePillar(world, x + 43, y + 3, z - 10, 17);

        generatePillar(world, x + 67, y + 3, z + 10, 17);
        generatePillar(world, x + 67, y + 3, z - 10, 17);
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
}
