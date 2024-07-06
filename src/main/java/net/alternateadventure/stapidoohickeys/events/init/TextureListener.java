package net.alternateadventure.stapidoohickeys.events.init;

import net.alternateadventure.stapidoohickeys.blocks.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class TextureListener {

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        ItemListener.coolItem.setTexture(Identifier.of(NAMESPACE, "item/coolItem"));

        ((CorruptionGrass) BlockListener.corruptionGrass).specifyTextures (
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_grass_top")).index,
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_grass_side")).index,
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_grass_bottom")).index
        );
        ((CorruptionGrassWet) BlockListener.corruptionGrassWet).specifyTextures (
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_grass_wet_top")).index,
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_grass_wet_side")).index,
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_grass_wet_bottom")).index
        );
        ((CorruptionLogWet) BlockListener.corruptionLogWet).specifyTextures (
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_log_wet_top")).index,
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_log_wet_side")).index
        );
        ((CorruptionLeavesWet) BlockListener.corruptionLeavesWet).specifyTextures (
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_leaves_wet")).index
        );
        ((CorruptionLeavesWetMature) BlockListener.corruptionLeavesWetMature).specifyTextures (
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_leaves_wet_mature")).index
        );
        ((CorruptionGrassWetSeeded) BlockListener.corruptionGrassWetSeeded).specifyTextures (
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_grass_wet_seeded")).index,
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_grass_wet_side")).index,
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_grass_wet_bottom")).index
        );
        ((CorruptionGrassEvolved) BlockListener.corruptionGrassEvolved).specifyTextures (
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_grass_evolved_top")).index,
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_grass_evolved_side")).index,
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_grass_evolved_bottom")).index
        );
        ((CorruptionDirtEvolved) BlockListener.corruptionDirtEvolved).specifyTextures (
                Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/corruption_dirt_evolved")).index
        );

        BlockListener.basaltSimple.setTextureId(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/fluid/basalt")).index);
        BlockListener.basalt.setTextureId(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/fluid/basalt")).index);
        BlockListener.hotBasalt.setTextureId(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/fluid/basalt_hot")).index);
        BlockListener.realisticLava.setTextureId(Block.LAVA.textureId);
        BlockListener.lavaGenerator.setTextureId(Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, "block/lava_generator")).index);

        BlockListener.realisticWater.setTextureId(Block.WATER.textureId);
        BlockListener.simpleWater.setTextureId(Block.WATER.textureId);
        BlockListener.waterGenerator.setTextureId(Block.WATER.textureId);
        BlockListener.waterDrainer.setTextureId(Block.SPONGE.textureId);
    }
}
