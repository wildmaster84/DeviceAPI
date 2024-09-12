package me.wild;

import org.bukkit.plugin.java.JavaPlugin;

import me.wild.api.DeviceAPI;
import me.wild.utils.Listeners;

public class DeviceMain extends JavaPlugin {
	private static DeviceAPI api;
	private static DeviceMain instance;

	public void onEnable() {
		api = new DeviceAPI();
		instance = this;
		this.getServer().getPluginManager().registerEvents(new Listeners(), this);
	}

	public static DeviceAPI getApi() {
		return api;
	}
	
	public static DeviceMain getInstance() {
		return instance;
	}
}
