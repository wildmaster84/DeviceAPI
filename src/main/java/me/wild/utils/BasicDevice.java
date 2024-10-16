package me.wild.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.wild.objects.App;
import me.wild.objects.Device;
import me.wild.objects.OperatingSystem;
import me.wild.objects.ScreenSize;

public class BasicDevice implements Device {
    private String name;
    private String title;
    private OperatingSystem os;
    private final ScreenSize screenSize;
    private final ItemStack fillerMaterial;
    private Inventory deviceGUI;

    public BasicDevice(String name, String title, OperatingSystem os, ScreenSize screenSize, ItemStack fillerMaterial) {
        this.name = name;
        this.title = title;
        this.os = os;
        this.screenSize = screenSize;
        this.fillerMaterial = fillerMaterial; // This can be null if no filler is wanted
        constructGUI();
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public void setTitle(String newtitle) {
    	title = newtitle;
    	constructGUI();
    }

    @Override
    public OperatingSystem getOperatingSystem() {
        return os;
    }
    
    @Override
    public ScreenSize getScreenSize() {
        return screenSize;
    }

    @Override
    public ItemStack getFillerMaterial() {
        return fillerMaterial;
    }

    @Override
    public void open(Player player) {
        player.openInventory(deviceGUI);
    }

    @Override
    public void runApp(String appName, Player player) {
        os.launchApp(appName, player);
    }

	@Override
	public Inventory getInventory() {
		// TODO Auto-generated method stub
		return deviceGUI;
	}
	
	// Creates the gui
	private void constructGUI() {
        deviceGUI = Bukkit.createInventory(this, 9 * getScreenSize().getRows(), getTitle());
        if (fillerMaterial != null) {
            // Fill the entire GUI with filler items first
            for (int i = 0; i < screenSize.getTotalSize(); i++) {
            	deviceGUI.setItem(i, fillerMaterial);
            }
        }

        // Create GUI items for installed apps
        for (App app : os.getInstalledApps()) {
            deviceGUI.setItem(app.getAppSlot(), app.getIcon());
        }
    }
}
