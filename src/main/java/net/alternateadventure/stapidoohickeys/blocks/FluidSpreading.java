package net.alternateadventure.stapidoohickeys.blocks;

import net.minecraft.block.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class FluidSpreading extends FluidFalling{
    public FluidSpreading(Identifier identifier, Material material, int tickRate) {
        super(identifier, material, tickRate);
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
                return;
            }
            if (leftoverQuantity != sourceQuantity) {
                world.method_154(x, y, z, this.id, leftoverQuantity);
                return;
            }
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
}
