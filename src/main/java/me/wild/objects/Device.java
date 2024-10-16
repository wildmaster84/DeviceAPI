package me.wild.objects;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import me.wild.utils.DeviceConfigManager;

public interface Device extends InventoryHolder {
    String getName();
    String getTitle();
    void setTitle(String newtitle);
    OperatingSystem getOperatingSystem();
    ScreenSize getScreenSize();  // New method for screen size
    ItemStack getFillerMaterial();  // Optional filler material
    void open(Player player);
    void runApp(String appName, Player player);
    Inventory getInventory();
    default DeviceConfigManager getConfigManager() {
        return null; // Return null by default for apps that don't use config
    }
}
