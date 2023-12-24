package net.alternateadventure.stapidoohickeys.blocks;

import net.minecraft.block.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class LazyBlockTemplate extends TemplateBlock {
    public LazyBlockTemplate(Identifier identifier, Material material) {
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
}
