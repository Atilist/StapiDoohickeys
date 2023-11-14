package net.alternateadventure.stapidoohickeys.events.init;

import net.alternateadventure.stapidoohickeys.blocks.*;
import net.alternateadventure.stapidoohickeys.wrappers.ExampleBlockWithModel;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class BlockListener {

    public static Block corruptionGrass;
    public static Block corruptionGrassWet;
    public static Block corruptionLogWet;
    public static Block corruptionLeavesWet;
    public static Block corruptionLeavesWetMature;
    public static Block corruptionGrassWetSeeded;
    public static Block corruptionGrassEvolved;
    public static Block corruptionDirtEvolved;

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        System.out.println(NAMESPACE);
        corruptionGrass = new CorruptionGrass(Identifier.of(NAMESPACE, "corruption_grass"), Material.CLAY).setHardness(0.5F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        corruptionGrassWet = new CorruptionGrassWet(Identifier.of(NAMESPACE, "corruption_grass_wet"), Material.CLAY).setHardness(0.5F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        corruptionLogWet = new CorruptionLogWet(Identifier.of(NAMESPACE, "corruption_log_wet"), Material.WOOD).setHardness(0.5F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        corruptionLeavesWet = new CorruptionLeavesWet(Identifier.of(NAMESPACE, "corruption_leaves_wet"), Material.LEAVES).setHardness(0.5F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        corruptionLeavesWetMature = new CorruptionLeavesWetMature(Identifier.of(NAMESPACE, "corruption_leaves_wet_mature"), Material.LEAVES).setHardness(0.5F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        corruptionGrassWetSeeded = new CorruptionGrassWetSeeded(Identifier.of(NAMESPACE, "corruption_grass_wet_seeded"), Material.CLAY).setHardness(0.5F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        corruptionGrassEvolved = new CorruptionGrassEvolved(Identifier.of(NAMESPACE, "corruption_grass_evolved"), Material.CLAY).setHardness(0.5F).setSoundGroup(Block.DIRT_SOUND_GROUP);
        corruptionDirtEvolved = new CorruptionDirtEvolved(Identifier.of(NAMESPACE, "corruption_dirt_evolved"), Material.CLAY).setHardness(0.5F).setSoundGroup(Block.DIRT_SOUND_GROUP);
    }
}
