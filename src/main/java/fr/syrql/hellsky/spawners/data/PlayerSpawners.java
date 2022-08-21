package fr.syrql.hellsky.spawners.data;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class PlayerSpawners {

    private String playerName;
    private List<CreatureSpawner> creatureSpawners;

    public PlayerSpawners(String playerName, List<CreatureSpawner> creatureSpawners) {
        this.playerName = playerName;
        this.creatureSpawners = creatureSpawners;
    }

    public String getPlayer() {
        return playerName;
    }

    public void setPlayer(String playerName) {
        this.playerName = playerName;
    }

    public List<CreatureSpawner> getCreatureSpawners() {
        return creatureSpawners;
    }

    public void setCreatureSpawners(List<CreatureSpawner> creatureSpawners) {
        this.creatureSpawners = creatureSpawners;
    }
}
