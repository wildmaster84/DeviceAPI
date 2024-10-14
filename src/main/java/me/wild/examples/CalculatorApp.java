package me.wild.examples;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.wild.objects.App;
import me.wild.utils.AppConfigManager;

import org.bukkit.Material;

public class CalculatorApp implements App {
	private final AppConfigManager configManager;
	
	public CalculatorApp() {
        // Each app can have its own config manager
        this.configManager = new AppConfigManager(getAppName());
    }
	
    @Override
    public String getAppName() {
        return "Calculator";
    }
    
    @Override
	public int getAppSlot() {
		return 9; // GUI slot
	}

    @Override
    public String getVersion() {
        return "1.0.0"; // Example version
    }

    @Override
    public ItemStack getIcon() {
    	ItemStack icon = new ItemStack(Material.PAPER);
    	ItemMeta meta = icon.getItemMeta();
    	meta.setDisplayName(getAppName() + " v" + getVersion());
    	icon.setItemMeta(meta);
        return icon; // Example material for the app icon
    }

    @Override
    public void launch(Player player) {
        player.sendMessage("Launching Calculator App...");
        // GUI and app logic can be implemented here
        // You would define a function to call that constructs the app GUI
    }
    
    @Override
    public AppConfigManager getConfigManager() {
        return configManager; // Return the config manager for this app
    }
}

