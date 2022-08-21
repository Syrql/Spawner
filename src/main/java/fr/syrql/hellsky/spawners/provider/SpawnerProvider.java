package fr.syrql.hellsky.spawners.provider;

import fr.syrql.hellsky.Hell;
import fr.syrql.hellsky.provide.IProvider;
import fr.syrql.hellsky.spawners.data.PlayerSpawners;
import fr.syrql.hellsky.io.readable.IReadable;
import fr.syrql.hellsky.io.writeable.IWriteable;
import fr.syrql.hellsky.utils.FileUtils;
import fr.syrql.hellsky.utils.IOUtil;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SpawnerProvider implements IProvider<String, PlayerSpawners>, IWriteable, IReadable {

    private final Hell hell;
    private Map<String, PlayerSpawners> botMap;
    private final File saveDir;

    public SpawnerProvider(Hell hell) {
        this.hell = hell;
        this.botMap = new HashMap<>();
        this.saveDir = new File(hell.getDataFolder(), "/datas/");
    }

    @Override
    public void provide(String key, PlayerSpawners value) {
        this.botMap.put(key, value);
        this.write();
    }

    @Override
    public void remove(String key) {
        PlayerSpawners bot = this.botMap.get(key);

        if (bot == null) return;
        this.botMap.remove(key);
    }

    @Override
    public PlayerSpawners get(String key) {
        return this.botMap.get(key);
    }

    @Override
    public void read() {

        File[] files = saveDir.listFiles();
        if (files == null) {
            this.botMap = new HashMap<>();
            return;
        }

        IOUtil ioUtil = this.hell.getIoUtil();
        for (File file : files) {
            if (file.isFile()) {
                final String json = FileUtils.loadContent(file);
                final PlayerSpawners playerData = ioUtil.deserialize(json);
                this.botMap.put(playerData.getPlayer(), playerData);
            }
        }
    }

    @Override
    public void write() {
        if (this.getPlayerSpawners() == null) return;

        final IOUtil ioUtil = this.hell.getIoUtil();
        for (PlayerSpawners playerData : this.getPlayerSpawners()) {
            final File file = new File(saveDir, playerData.getPlayer() + ".json");
            final String json = ioUtil.serialize(playerData);
            FileUtils.save(file, json);
        }
    }

    public Collection<PlayerSpawners> getPlayerSpawners() {
        return this.botMap.values();
    }
}
