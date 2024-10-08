package me.wild.objects;

import java.util.List;

import org.bukkit.entity.Player;

public interface OperatingSystem {
    String getOSName();
    List<App> getInstalledApps();
    void installApp(App app);
    void launchApp(String appName, Player player);
}