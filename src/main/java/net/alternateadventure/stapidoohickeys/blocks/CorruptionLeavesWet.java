package net.alternateadventure.stapidoohickeys.blocks;

import net.alternateadventure.stapidoohickeys.events.init.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class CorruptionLeavesWet extends TemplateBlock {

    int textureInternal;

    public CorruptionLeavesWet(Identifier identifier, Material material) {
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
        int randomX = random.nextInt(3) - 1;
        int randomY = random.nextInt(3) - 1;
        int randomZ = random.nextInt(3) - 1;
        if (world.getBlockId(x + randomX, y + randomY, z + randomZ) == Block.LEAVES.id) {
            world.setBlock(x + randomX, y + randomY, z + randomZ, BlockListener.corruptionLeavesWet.id);
        } else if (random.nextInt(4) == 0) {
            world.setBlock(x, y, z, BlockListener.corruptionLeavesWetMature.id);
            return;
        }
        world.scheduleBlockUpdate(x, y, z, this.id, this.getTickRate());
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}
