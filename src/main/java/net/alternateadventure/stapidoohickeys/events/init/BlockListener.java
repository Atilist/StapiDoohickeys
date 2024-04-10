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

    public static LazyBlockTemplate basaltSimple;
    public static Basalt basalt;
    public static BasaltHot basaltHot;
    public static LavaRealistic lavaRealistic;
    public static LavaGenerator lavaGenerator;

    public static WaterRealistic waterRealistic;
    public static WaterSimple waterSimple;
    public static WaterGenerator waterGenerator;
    public static WaterDrainer waterDrainer;

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

        basaltSimple = new LazyBlockTemplate(Identifier.of(NAMESPACE, "basalt_simple"), Material.STONE);
        basalt = new Basalt(Identifier.of(NAMESPACE, "basalt"), Material.STONE);
        basaltHot = new BasaltHot(Identifier.of(NAMESPACE, "basalt_hot"), Material.STONE, 4);
        lavaRealistic = new LavaRealistic(Identifier.of(NAMESPACE, "lava_realistic"), Material.LAVA, 4);
        lavaGenerator = new LavaGenerator(Identifier.of(NAMESPACE, "lava_generator"), Material.STONE);

        waterRealistic = new WaterRealistic(Identifier.of(NAMESPACE, "water_realistic"), Material.WATER, 4);
        waterSimple = new WaterSimple(Identifier.of(NAMESPACE, "water_simple"), Material.WATER);
        waterGenerator = new WaterGenerator(Identifier.of(NAMESPACE, "water_generator"), Material.METAL);
        waterDrainer = new WaterDrainer(Identifier.of(NAMESPACE, "water_drainer"), Material.METAL);

        convertedByLava.put(Block.LEAVES.id, 0);
        convertedByLava.put(Block.LOG.id, 0);
        convertedByLava.put(Block.GRASS.id, 0);
        convertedByLava.put(Block.SNOW.id, 0);
        convertedByLava.put(Block.WOOL.id, 0);
        convertedByLava.put(Block.SNOW_BLOCK.id, Block.WATER.id);
        convertedByLava.put(Block.ICE.id, Block.WATER.id);
        convertedByLava.put(Block.SAND.id, Block.GLASS.id);
        convertedByLava.put(Block.WATER.id, Block.STONE.id);
        convertedByLava.put(BlockListener.waterRealistic.id, Block.STONE.id);
        convertedByLava.put(BlockListener.waterSimple.id, Block.STONE.id);
        convertedByLava.put(Block.GRASS_BLOCK.id, Block.GRAVEL.id);
        convertedByLava.put(Block.DIRT.id, Block.GRAVEL.id);
        convertedByLava.put(Block.STONE.id, Block.COBBLESTONE.id);
        convertedByLava.put(Block.COBBLESTONE.id, Block.GRAVEL.id);
        convertedByLava.put(Block.MOSSY_COBBLESTONE.id, Block.COBBLESTONE.id);

        waterRealistic.setOptimizedBlockId(waterSimple.id);
    }
}
