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
    private HashMap<Player, List<App>> playerInstalledApps;

    public BasicOperatingSystem(String osName) {
        this.osName = osName;
        this.installedApps = new ArrayList<>();
        this.playerInstalledApps = new HashMap<Player, List<App>>();
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
    public List<App> getPlayerInstalledApps(Player player) {
        return playerInstalledApps.get(player);
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
