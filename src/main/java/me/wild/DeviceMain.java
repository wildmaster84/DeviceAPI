package me.wild;

import org.bukkit.plugin.java.JavaPlugin;

import me.wild.api.DeviceAPI;

public class DeviceMain extends JavaPlugin {
	private static DeviceAPI api;

	public void onEnable() {
		api = new DeviceAPI();
	}

	public static DeviceAPI getApi() {
		return api;
	}
}
