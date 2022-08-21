package fr.syrql.hellsky.spawners.factory;

import fr.syrql.hellsky.spawners.data.PlayerSpawners;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Player;

import java.util.List;

public class SpawnerFactory {

    public PlayerSpawners create(String playerName, List<CreatureSpawner> creatureSpawners) {
        return new PlayerSpawners(playerName, creatureSpawners);
    }
}