package fr.syrql.hellsky.utils.config;

import fr.syrql.hellsky.Hell;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConfigManager {

    private Hell hell;
    private final FileConfiguration config;

    public ConfigManager(Hell hell) {
        this.hell = hell;
        this.config = hell.getConfig();
    }

    public String getString(String path) {
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(hell.getConfig().getString(path)));
    }

    public List<String> getStringList(String path) {

        List<String> stringList = hell.getConfig().getStringList(path);
        ArrayList<String> toReturn = new ArrayList<>();

        stringList.forEach(line -> toReturn.add(ChatColor.translateAlternateColorCodes('&', line)));

        return toReturn;
    }

    public void setDouble(String path, double value) { config.set(path, value); }

    public int getInt(String path) {
        return config.getInt(path);
    }

    public boolean getBoolean(String path) {
        return config.getBoolean(path);
    }

    private double getDouble(String path) {
        return config.getDouble(path);
    }

    public double getFloat(String path) {
        return config.getDouble(path);
    }
    public long getLong(String path){
        return config.getLong(path);
    }

    public FileConfiguration getConfig() { return config; }

    public void updateConfig() {
        hell.saveConfig();
        hell.reloadConfig();
    }
}
