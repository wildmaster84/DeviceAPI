package me.wild.utils;

import java.util.function.Consumer;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import me.wild.objects.App;

public class BasicApp implements App {
	String appName;
	String version;
	ItemStack iconMaterial;
	Consumer<Player> onLaunch;
	
	public BasicApp(String appName, String version, ItemStack iconMaterial, Consumer<Player> onLaunch) {
		this.appName = appName;
		this.version = version;
		this.iconMaterial = iconMaterial;
		this.onLaunch = onLaunch;
	}

	private final AppConfigManager configManager = new AppConfigManager(appName); // Config manager for the app
	
    @Override
    public String getAppName() {
        return appName;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public ItemStack getIcon() {
        return iconMaterial;
    }

    @Override
    public void launch(Player player) {
        onLaunch.accept(player);
    }
    
    @Override
    public AppConfigManager getConfigManager() {
        return configManager;
    }
}
