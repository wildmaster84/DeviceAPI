package me.wild.objects;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface Device extends InventoryHolder {
    String getName();
    OperatingSystem getOperatingSystem();
    ScreenSize getScreenSize();  // New method for screen size
    ItemStack getFillerMaterial();  // Optional filler material
    void open(Player player);
    void runApp(String appName, Player player);
    Inventory getInventory();
}
