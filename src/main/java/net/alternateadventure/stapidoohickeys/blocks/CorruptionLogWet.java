package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class CorruptionLogWet extends TemplateBlock {

    int topTextureInternal;
    int sideTextureInternal;

    public CorruptionLogWet(Identifier identifier, Material material) {
        super(identifier, material);
        this.setTranslationKey(identifier.namespace, identifier.path);
        this.setTickRandomly(true);
    }

    public void specifyTextures(int topTexture, int sideTexture) {
        topTextureInternal = topTexture;
        sideTextureInternal = sideTexture;
    }

    @Override
    public int getTexture(int i, int j) {
        if (i <= 1) return topTextureInternal;
        return sideTextureInternal;
    }

    @Override
    public int getTickRate() {
        return 4;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        super.onTick(world, x, y, z, random);
        world.method_216(x, y, z, this.id, this.getTickRate());
        /*
        if (random.nextInt(2) != 0) {
            return;
        }
         */
        int randomX = random.nextInt(3) - 1;
        int randomY = random.nextInt(3) - 1;
        int randomZ = random.nextInt(3) - 1;
        if (world.getBlockId(x + randomX, y + randomY, z + randomZ) == Block.LOG.id) {
            world.setBlock(x + randomX, y + randomY, z + randomZ, BlockListener.corruptionLogWet.id);
        } else if (world.getBlockId(x + randomX, y + randomY, z + randomZ) == Block.LEAVES.id) {
            world.setBlock(x + randomX, y + randomY, z + randomZ, BlockListener.corruptionLeavesWet.id);
        }
    }
}
