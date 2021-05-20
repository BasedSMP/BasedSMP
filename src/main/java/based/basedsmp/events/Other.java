package based.basedsmp.events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import based.basedsmp.RainbowText;
import net.md_5.bungee.api.ChatColor;

public class Other implements Listener {
	private RainbowText totemPopText = new RainbowText("Cry harder nn", ChatColor.ITALIC + "");
	private RainbowText deathWithTotem = new RainbowText("Dude.. how can you be so bad. Just switch totems.", ChatColor.ITALIC + "");
	@EventHandler(priority = EventPriority.MONITOR)
	public void totemPop(EntityResurrectEvent event) {
		if(!event.isCancelled() && event.getEntity().getType() == EntityType.PLAYER) {
			Player p = (Player)event.getEntity();
			
			p.sendMessage(totemPopText.getText());
		}
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void deathWithTotem(PlayerDeathEvent event) {
		Player p = event.getEntity();
		if(p.getInventory().contains(Material.TOTEM_OF_UNDYING)) {
			p.sendMessage(deathWithTotem.getText());
		}
	}
}
