package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class CorruptionGrass extends TemplateBlock {

    int topTextureInternal;
    int sideTextureInternal;
    int bottomTextureInternal;

    public CorruptionGrass(Identifier identifier, Material material) {
        super(identifier, material);
        this.setTranslationKey(identifier.namespace, identifier.path);
        this.setTickRandomly(true);
    }

    public void specifyTextures(int topTexture, int sideTexture, int bottomTexture) {
        topTextureInternal = topTexture;
        sideTextureInternal = sideTexture;
        bottomTextureInternal = bottomTexture;
    }

    @Override
    public int getTexture(int i, int j) {
        if (i == 0) return bottomTextureInternal;
        if (i == 1) return topTextureInternal;
        return sideTextureInternal;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        super.onTick(world, x, y, z, random);
        /*
        if (random.nextInt(4) != 0) {
            return;
        }

         */
        if (world.getBlockId(x, y + 1, z) != 0) {
            world.setBlock(x, y, z, Block.DIRT.id);
            return;
        }
        int randomX = random.nextInt(3) - 1;
        int randomY = random.nextInt(3) - 1;
        int randomZ = random.nextInt(3) - 1;
        if (world.getBlockId(x + randomX, y + randomY, z + randomZ) == Block.GRASS_BLOCK.id) {
            world.setBlock(x + randomX, y + randomY, z + randomZ, BlockListener.corruptionGrass.id);
        } else if (world.getBlockId(x + randomX, y + randomY, z + randomZ) == Block.WATER.id) {
            world.setBlock(x + randomX, y + randomY, z + randomZ, BlockListener.corruptionGrassWet.id);
        }
    }
}
