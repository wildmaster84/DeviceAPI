package me.wild.utils;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.InventoryView;

import me.wild.DeviceMain;
import me.wild.objects.App;
import me.wild.objects.Device;
import net.md_5.bungee.api.ChatColor;

public class Listeners implements Listener {

	// Dirty way to track placed devices
	@EventHandler
	public void onEntityInteract(PlayerInteractAtEntityEvent event) {
		if (!(event.getRightClicked() instanceof ArmorStand)) {
			return;
		}
		ArmorStand armorStand = (ArmorStand) event.getRightClicked();
		if (armorStand.getHelmet() != null) {
			for (Device device : DeviceMain.getApi().getDevices()) {
				if (ChatColor.stripColor(armorStand.getHelmet().getItemMeta().getDisplayName()).equalsIgnoreCase(device.getName())) {
					device.open(event.getPlayer());
					event.setCancelled(true);
					break;
				}
			}
			
		}
	}
	
	@EventHandler
	public void onDeviceClick(InventoryClickEvent event) {
		if (event.getClickedInventory() == null || event.getCurrentItem() == null) return;
		InventoryView view = event.getView();
		String title = ChatColor.stripColor(view.getTitle());
		for (Device device : DeviceMain.getApi().getDevices()) {
			if (ChatColor.stripColor(device.getOperatingSystem().getOSName()).equalsIgnoreCase(title)) {
				event.setCancelled(true);
				for (App app : device.getOperatingSystem().getInstalledApps()) {
			        if (app.getIcon().isSimilar(event.getCurrentItem())) {
			            app.launch((Player)event.getWhoClicked());
			            break;  // Exit once the matching app is found and launched
			        }
			    }
				break;
			}
		}
	}
}
