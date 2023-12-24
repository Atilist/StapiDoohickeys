package net.alternateadventure.stapidoohickeys.events.init;

import net.alternateadventure.stapidoohickeys.structures.GameStarCathedral;
import net.alternateadventure.stapidoohickeys.structures.GameStarTower;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.world.dimension.OverworldDimension;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;

public class ChunkListener {

    @EventListener
    public void populate(WorldGenEvent.ChunkDecoration event) {
        if (event.world.dimension instanceof OverworldDimension) populateOverworld(event);
    }

    public void populateOverworld (WorldGenEvent.ChunkDecoration event) {
        /*
        int x;
        int y;
        int z;
        for (int i = 0; i < 2; i++) {
            x = event.x + event.random.nextInt(16);
            y = 64 + event.random.nextInt(8);
            z = event.z + event.random.nextInt(16);
            new GameStarTower().method_1142(event.world, event.random, x, y, z);
        }
        if (event.random.nextInt(128) == 0){
            x = event.x + event.random.nextInt(16);
            y = 64 + event.random.nextInt(8);
            z = event.z + event.random.nextInt(16);
            new GameStarCathedral().method_1142(event.world, event.random, x, y, z);
        }

         */
    }
}
