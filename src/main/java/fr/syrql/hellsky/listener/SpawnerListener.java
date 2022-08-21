package fr.syrql.hellsky.listener;

import fr.syrql.hellsky.Hell;
import fr.syrql.hellsky.spawners.data.PlayerSpawners;
import fr.syrql.hellsky.spawners.factory.SpawnerFactory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Collections;

public class SpawnerListener implements Listener {

    private final Hell hell;

    public SpawnerListener(Hell hell) {
        this.hell = hell;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PlayerSpawners playerSpawners = this.hell.getSpawnerProvider().get(player.getName());

        if (playerSpawners != null) return;

        this.hell.getSpawnerProvider().provide(player.getName(),
                new SpawnerFactory().create(player.getName(), Collections.emptyList()));

    }
}
