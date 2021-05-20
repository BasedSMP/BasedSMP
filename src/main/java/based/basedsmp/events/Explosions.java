package based.basedsmp.events;

import org.bukkit.World.Environment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class Explosions implements Listener {
    @EventHandler
    public void anchorExplode(BlockExplodeEvent event) {
        if(event.getBlock().getWorld().getEnvironment() == Environment.NORMAL) event.blockList().clear();
    }
    
	@EventHandler(ignoreCancelled = true)
	public void entityExplode(EntityExplodeEvent event) {
		if(event.getEntityType() == EntityType.ENDER_CRYSTAL) event.setYield(0);
    	if(event.getEntityType() == EntityType.CREEPER) event.setYield(1);
	}
}
