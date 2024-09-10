package me.wild.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.wild.objects.App;
import me.wild.objects.Device;
import me.wild.objects.OperatingSystem;
import me.wild.objects.ScreenSize;

public class BasicDevice implements Device {
    private String name;
    private OperatingSystem os;
    private final ScreenSize screenSize;
    private final ItemStack fillerMaterial;

    public BasicDevice(String name, OperatingSystem os, ScreenSize screenSize, ItemStack fillerMaterial) {
        this.name = name;
        this.os = os;
        this.screenSize = screenSize;
        this.fillerMaterial = fillerMaterial; // This can be null if no filler is wanted
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public OperatingSystem getOperatingSystem() {
        return os;
    }
    
    @Override
    public ScreenSize getScreenSize() {
        return screenSize;
    }

    @Override
    public ItemStack getFillerMaterial() {
        return fillerMaterial;
    }

    @Override
    public void open(Player player) {
        // GUI logic here (Spigot Inventory API)
        Inventory deviceGUI = Bukkit.createInventory(null, 9 * getScreenSize().getRows(), os.getOSName());
     // Add filler items if a filler material is provided
        if (fillerMaterial != null) {
            // Fill the entire GUI with filler items first
            for (int i = 0; i < screenSize.getTotalSize(); i++) {
            	deviceGUI.setItem(i, fillerMaterial);
            }
        }

        // Create GUI items for installed apps
        int slot = 0;
        for (App app : os.getInstalledApps()) {
            if (slot >= screenSize.getTotalSize()) {
                break;  // No more room for apps
            }
            deviceGUI.setItem(slot, app.getIcon());
            slot++;
        }

        // Open the GUI for the player
        player.openInventory(deviceGUI);
    }

    @Override
    public void runApp(String appName, Player player) {
        os.launchApp(appName, player);
    }
}
