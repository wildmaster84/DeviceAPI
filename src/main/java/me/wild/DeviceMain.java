package me.wild;

import org.bukkit.plugin.java.JavaPlugin;

import me.wild.api.DeviceAPI;
import me.wild.utils.Listeners;

public class DeviceMain extends JavaPlugin {
	private static DeviceAPI api;

	public void onEnable() {
		api = new DeviceAPI();
		this.getServer().getPluginManager().registerEvents(new Listeners(), this);
	}

	public static DeviceAPI getApi() {
		return api;
	}
}
