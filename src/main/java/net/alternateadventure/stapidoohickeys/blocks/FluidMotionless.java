package net.alternateadventure.stapidoohickeys.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class FluidMotionless extends TemplateBlock {

    public FluidMotionless(Identifier identifier, Material material) {
        super(identifier, material);
        this.setTranslationKey(identifier.namespace, identifier.path);
    }

    public void setTextureId(int textureId) {
        this.textureId = textureId;
    }

    @Override
    public int getTexture(int side) {
        return textureId;
    }

    @Override
    public Box getBoundingBox(World world, int x, int y, int z) {
        this.updateBoundingBox(world, x, y, z);
        return super.getBoundingBox(world, x, y, z);
    }

    @Override
    public void updateBoundingBox(BlockView blockView, int x, int y, int z) {
        this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F * (float) (blockView.getBlockMeta(x, y, z) + 1), 1.0F);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}
