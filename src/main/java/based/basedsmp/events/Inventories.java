package based.basedsmp.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class Inventories implements Listener {
	
    @EventHandler
    public void disableEnderEgg(InventoryClickEvent event) {
    	InventoryType inv = event.getWhoClicked().getOpenInventory().getType();
    	Material item = event.getCurrentItem().getType();
    	
    	if(inv == InventoryType.SHULKER_BOX || inv == InventoryType.ENDER_CHEST) {
    		if(item == Material.DRAGON_EGG) {
    			event.setCancelled(true);
    		}
    	}
    }
}
