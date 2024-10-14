package me.wild.objects;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.wild.utils.AppConfigManager;

public interface App {
    String getAppName();
    int getAppSlot();
    String getVersion(); // New method for version
    ItemStack getIcon(); // New method for icon material
    void launch(Player player);
    default AppConfigManager getConfigManager() {
        return null; // Return null by default for apps that don't use config
    }
}
