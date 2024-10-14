package me.wild.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import me.wild.DeviceMain;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class DeviceConfigManager {
    private final File configFile;
    private final FileConfiguration config;
    private final String sanitizedDeviceName;

    public DeviceConfigManager(UUID player, String deviceName) {
        // Sanitize the app name to prevent issues with file creation
        this.sanitizedDeviceName = sanitizeDeviceName(deviceName);
        File appConfigFolder = new File(DeviceMain.getInstance().getDataFolder(), "devices/" + player.toString());
        
        if (!appConfigFolder.exists()) {
            appConfigFolder.mkdirs();
        }
        
        this.configFile = new File(appConfigFolder, sanitizedDeviceName + ".yml");
        this.config = YamlConfiguration.loadConfiguration(configFile);
    }

    // Helper method to sanitize the app name for file safety
    private String sanitizeDeviceName(String deviceName) {
        // Replace illegal characters with underscores and collapse multiple underscores
        String sanitized = deviceName.replaceAll("[^a-zA-Z0-9-_]", "_").replaceAll("_+", "_");

        // Trim leading or trailing underscores
        return sanitized.replaceAll("^_+|_+$", "");
    }

    // Get a value from the config
    public Object get(String path) {
        return config.get(path);
    }

    // Set a value in the config
    public void set(String path, Object value) {
        config.set(path, value);
        saveConfig();
    }

    // Remove a value from the config
    public void remove(String path) {
        config.set(path, null); // Set to null to remove
        saveConfig();
    }

    // Save changes to the config file
    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get all keys stored in the config file
    public Set<String> getKeys(boolean deep) {
        return config.getKeys(deep);
    }
}

