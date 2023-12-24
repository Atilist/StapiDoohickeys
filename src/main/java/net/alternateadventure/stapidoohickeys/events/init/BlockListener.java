package net.alternateadventure.stapidoohickeys.events.init;

import net.alternateadventure.stapidoohickeys.blocks.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

import java.util.HashMap;

public class BlockListener {

    public static Block corruptionGrass;
    public static Block corruptionGrassWet;
    public static Block corruptionLogWet;
    public static Block corruptionLeavesWet;
    public static Block corruptionLeavesWetMature;
    public static Block corruptionGrassWetSeeded;
    public static Block corruptionGrassEvolved;
    public static Block corruptionDirtEvolved;

    public static FluidMotionless basalt;
    public static BasaltHot basaltHot;
    public static LavaRealistic lavaRealistic;
    public static LavaGenerator lavaGenerator;

    public static HashMap<Integer, Integer> convertedByLava = new HashMap<>();

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

        basalt = new FluidMotionless(Identifier.of(NAMESPACE, "basalt"), Material.STONE);
        basaltHot = new BasaltHot(Identifier.of(NAMESPACE, "basalt_hot"), Material.STONE, 4);
        lavaRealistic = new LavaRealistic(Identifier.of(NAMESPACE, "lava_realistic"), Material.STONE, 4);
        lavaGenerator = new LavaGenerator(Identifier.of(NAMESPACE, "lava_generator"), Material.STONE);

        convertedByLava.put(Block.LEAVES.id, 0);
        convertedByLava.put(Block.LOG.id, 0);
        convertedByLava.put(Block.GRASS.id, 0);
        convertedByLava.put(Block.SNOW.id, 0);
        convertedByLava.put(Block.SNOW_BLOCK.id, Block.WATER.id);
        convertedByLava.put(Block.ICE.id, Block.WATER.id);
        convertedByLava.put(Block.SAND.id, Block.GLASS.id);
        convertedByLava.put(Block.WATER.id, Block.STONE.id);
    }
}
