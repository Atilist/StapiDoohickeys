package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class CorruptionLeavesWetMature extends TemplateBlock {

    int textureInternal;

    public CorruptionLeavesWetMature(Identifier identifier, Material material) {
        super(identifier, material);
        this.setTranslationKey(identifier.namespace, identifier.path);
        this.setTickRandomly(true);
    }

    public void specifyTextures(int texture) {
        textureInternal = texture;
    }

    @Override
    public int getTexture(int i, int j) {
        return textureInternal;
    }

    @Override
    public int getTickRate() {
        return 4;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        super.onTick(world, x, y, z, random);
        /*
        if (random.nextInt(2) != 0) {
            return;
        }
         */
        int randomX = random.nextInt(7) - 3;
        int randomY = random.nextInt(7) - 7;
        int randomZ = random.nextInt(7) - 3;
        if (world.getBlockId(x + randomX, y + randomY, z + randomZ) == BlockListener.corruptionGrassWet.id && random.nextInt(4) == 0) {
            world.setBlock(x + randomX, y + randomY, z + randomZ, BlockListener.corruptionGrassWetSeeded.id);
            world.setBlock(x, y, z, 0);
            return;
        } else if (random.nextInt(16) == 0) {
            world.setBlock(x, y, z, 0);
            return;
        }
        world.scheduleBlockUpdate(x, y, z, this.id, this.getTickRate());
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}
