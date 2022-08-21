package fr.syrql.hellsky;

import fr.syrql.hellsky.commands.SpawnerCommand;
import fr.syrql.hellsky.listener.SpawnerListener;
import fr.syrql.hellsky.spawners.provider.SpawnerProvider;
import fr.syrql.hellsky.utils.IOUtil;
import fr.syrql.hellsky.utils.config.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Hell extends JavaPlugin {

    private SpawnerProvider spawnerProvider;
    private IOUtil ioUtil;

    private ConfigManager configManager;

    @Override
    public void onEnable() {
        this.log("&3===&b=============================================&3===");
        this.log("- &bName&7: HellSky");
        this.log("- &bVersion&7: " + this.getDescription().getVersion());
        this.log("- &bAuthor&7: SYRQL");
        this.log("");
        this.log("- &7Using &c" + this.getServer().getVersion() + " &7version.");
        this.log("");
        this.log("");

        this.saveDefaultConfig();
        this.registerProvider();
        this.registerManagers();
        this.registerListeners();
        long timeAtStart = System.currentTimeMillis();

        long timeAtEnd = System.currentTimeMillis();
        long timeTakenInMS = timeAtEnd - timeAtStart;
        this.log("- &bEnabled. Took &a" + timeTakenInMS + " &bms.");
        this.log("&3===&b=============================================&3===");
    }

    @Override
    public void onDisable() {
        this.spawnerProvider.write();
    }

    private void registerManagers() {
        this.ioUtil = new IOUtil();
        this.configManager = new ConfigManager(this);
    }

    private void registerProvider() {
        this.spawnerProvider = new SpawnerProvider(this);
        this.spawnerProvider.read();
    }

    private void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new SpawnerListener(), this);
    }

    private void registerCommands() {
        new SpawnerCommand(this);
    }

    public void log(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public IOUtil getIoUtil() {
        return ioUtil;
    }

    public SpawnerProvider getSpawnerProvider() {
        return spawnerProvider;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
