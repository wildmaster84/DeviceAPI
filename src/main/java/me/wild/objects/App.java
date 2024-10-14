package me.wild.objects;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.wild.utils.AppConfigManager;

public interface App {
    String getAppName();
    int getAppSlot();
    String getVersion();
    ItemStack getIcon();
    void setIcon(ItemStack item);
    void launch(Player player);
    default AppConfigManager getConfigManager() {
        return null; // Return null by default for apps that don't use config
    }
}
