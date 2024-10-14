package me.wild.api;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import me.wild.objects.App;
import me.wild.objects.Device;
import me.wild.objects.OperatingSystem;
import me.wild.objects.ScreenSize;
import me.wild.utils.BasicApp;
import me.wild.utils.BasicDevice;
import me.wild.utils.BasicOperatingSystem;

public class DeviceAPI {
    private List<Device> devices;
    
    public DeviceAPI() {
    	devices = new ArrayList<>();
    }

    // Creates an app
    public App createApp(String appName, int slot, String version, ItemStack iconMaterial, Consumer<Player> onLaunch) {
        return new BasicApp(appName, slot, version, iconMaterial, onLaunch);
    }
    
    // Creates an operating system
    public BasicOperatingSystem createOS(String name) {
		return new BasicOperatingSystem(name);
    }
    
    // Creates a device
    public Device createDevice(String deviceName, String title, OperatingSystem os, ScreenSize screenSize, ItemStack fillerMaterial) {
    	Device device = new BasicDevice(deviceName, title, os, screenSize, fillerMaterial);
    	devices.add(device);
        return device;
    }
    
    // Retrieves all registered devices.
    public List<Device> getDevices() {
    	return devices;
    }
}

