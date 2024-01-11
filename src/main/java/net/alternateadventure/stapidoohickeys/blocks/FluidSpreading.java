package net.alternateadventure.stapidoohickeys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class FluidSpreading extends FluidFalling {
    public FluidSpreading(Identifier identifier, Material material, int tickRate, float density) {
        super(identifier, material, tickRate, density);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        super.onTick(world, x, y, z, random);
        if (hasFallen) {
            hasFallen = false;
            return;
        }
        int sourceQuantity = world.getBlockMeta(x, y, z);
        int side = random.nextInt(4);
        int leftoverQuantity = 0;
        for (int i = 1; i <= 8; i++) {
            switch (side) {
                case 0 -> leftoverQuantity = spreadFluid(world, x + i, y, z, sourceQuantity);
                case 1 -> leftoverQuantity = spreadFluid(world, x - i, y, z, sourceQuantity);
                case 2 -> leftoverQuantity = spreadFluid(world, x, y, z + i, sourceQuantity);
                case 3 -> leftoverQuantity = spreadFluid(world, x, y, z - i, sourceQuantity);
            }
            if (leftoverQuantity == 32) {
                break;
            }
            if (leftoverQuantity != sourceQuantity) {
                world.method_154(x, y, z, this.id, leftoverQuantity);
                return;
            }
        }
        for (int i = 1; i <= 8; i++) {
            switch (side) {
                case 0 -> leftoverQuantity = balanceFluid(world, x + i, y, z, sourceQuantity);
                case 1 -> leftoverQuantity = balanceFluid(world, x - i, y, z, sourceQuantity);
                case 2 -> leftoverQuantity = balanceFluid(world, x, y, z + i, sourceQuantity);
                case 3 -> leftoverQuantity = balanceFluid(world, x, y, z - i, sourceQuantity);
            }
            if (leftoverQuantity == 32) {
                break;
            }
            if (leftoverQuantity != sourceQuantity) {
                world.method_154(x, y, z, this.id, leftoverQuantity);
                return;
            }
        }
        if (random.nextInt(64) == 0) {
            return;
        }
        if (world.getBlockId(x, y + 1, z) == this.id) {
            return;
        }
        if (surroundedByFluid(world, x, y, z)) {
            return;
        }
        float pressure = 0;
        int height = y;
        int randomLowerBound = 0;
        if (random.nextInt(8) == 0) {
            randomLowerBound = random.nextInt(y);
        }
        for (; height >= randomLowerBound; height--) {
            if (world.getBlockId(x, height, z) == this.id) {
                pressure += world.getBlockMeta(x, height, z) + 1;
            } else if (optimizedBlockId != -1 && world.getBlockId(x, height, z) == optimizedBlockId) {
                pressure += 16;
            } else {
                height++;
                break;
            }
        }
        pressure *= density;
        switch (side) {
            case 0 -> destroyBlock(world, x + 1, height, z, pressure, 0);
            case 1 -> destroyBlock(world, x - 1, height, z, pressure, 1);
            case 2 -> destroyBlock(world, x, height, z + 1, pressure, 2);
            case 3 -> destroyBlock(world, x, height, z - 1, pressure, 3);
        }
    }

    public int balanceFluid(World world, int x, int y, int z, int sourceQuantity) {
        if (world.getBlockId(x, y, z) != this.id) {
            return 32;
        }
        int targetQuantity = world.getBlockMeta(x, y, z);
        int excessQuantity = sourceQuantity - targetQuantity;
        if (excessQuantity < 1) {
            return sourceQuantity;
        }
        int outgoingExcess = excessQuantity / 2;
        world.method_154(x, y, z, this.id, outgoingExcess + targetQuantity);
        return sourceQuantity - outgoingExcess;
    }

    public int spreadFluid(World world, int x, int y, int z, int sourceQuantity) {
        if (world.getBlockId(x, y, z) == this.id) {
            return sourceQuantity;
        }
        if (sourceQuantity <= 0 || world.getBlockId(x, y, z) != 0) {
            return 32;
        }
        int outgoingExcess = sourceQuantity / 2;
        if (outgoingExcess <= 0) {
            return sourceQuantity;
        }
        world.method_154(x, y, z, this.id, outgoingExcess);
        return sourceQuantity - outgoingExcess;
    }

    public boolean surroundedByFluid(World world, int x, int y, int z) {
        if (world.getBlockId(x + 1, y, z) != this.id) {
            return false;
        }
        if (world.getBlockId(x - 1, y, z) != this.id) {
            return false;
        }
        if (world.getBlockId(x, y, z + 1) != this.id) {
            return false;
        }
        return world.getBlockId(x, y, z - 1) == this.id;
    }

    public void destroyBlock(World world, int x, int y, int z, float pressure, int direction) {
        int blockId = world.getBlockId(x, y, z);
        if (blockId == this.id || blockId == optimizedBlockId) {
            return;
        }
        Block block = Block.BLOCKS[blockId];
        if (block == null) {
            return;
        }
        float hardness = block.getHardness() * 10;
        float blastResistance = block.getBlastResistance(null) * 10;
        boolean exposedToAir = false;
        int xDirection = 0;
        int zDirection = 0;
        switch (direction) {
            case 0 -> xDirection = 1;
            case 1 -> xDirection = -1;
            case 2 -> zDirection = 1;
            case 3 -> zDirection = -1;
        }
        for (int i = 1; i <= 5; i++) {
            for (int j = -5 + i; j <= 5 - i; j++) {
                int xCompact = x + xDirection * i + zDirection * j;
                int zCompact = z + zDirection * i + xDirection * j;
                if (world.getBlockId(xCompact, y, zCompact) == 0) {
                    exposedToAir = true;
                    break;
                } else {
                    block = Block.BLOCKS[world.getBlockId(xCompact, y, zCompact)];
                    if (block == null) {
                        continue;
                    }
                    hardness += block.getHardness() * 10;
                    blastResistance += block.getBlastResistance(null) * 10;
                }
            }
        }
        if (pressure > hardness + blastResistance && exposedToAir) {
            world.setBlock(x, y, z, 0);
        }
    }
}
