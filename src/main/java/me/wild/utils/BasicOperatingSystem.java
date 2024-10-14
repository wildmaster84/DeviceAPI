package me.wild.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.bukkit.entity.Player;

import me.wild.objects.App;
import me.wild.objects.OperatingSystem;

public class BasicOperatingSystem implements OperatingSystem {
    private String osName;
    private List<App> installedApps;

    public BasicOperatingSystem(String osName) {
        this.osName = osName;
        this.installedApps = new ArrayList<>();
    }

    @Override
    public String getOSName() {
        return osName;
    }

    @Override
    public List<App> getInstalledApps() {
        return installedApps;
    }
    
    @Override
	public App getApp(int slot) {
    	for (App app : this.installedApps) {
    		if (app.getAppSlot() == slot) return app;
    	}
		return null;
	}

    @Override
    public void installApp(App app) {
        installedApps.add(app);
    }

    @Override
    public void launchApp(String appName, Player player) {
        for (App app : installedApps) {
            if (app.getAppName().equalsIgnoreCase(appName)) {
                app.launch(player);
                return;
            }
        }
        player.sendMessage("App not found: " + appName);
    }
}
