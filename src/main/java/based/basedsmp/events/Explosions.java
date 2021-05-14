package based.basedsmp.events;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class Explosions implements Listener {
	private Logger log = Bukkit.getServer().getLogger();

    @EventHandler
    public void anchorBlowUp(BlockExplodeEvent event) {
        event.blockList().clear();
        log.info(event.getBlock().getType().toString());
        
        /*
         * This does blocks ALL block explode events
         * including beds.
         * This has to be fixed at some point, but
         * currently event.getBlock()
         * doesn't give the right block.
         */
    }
    
    @EventHandler(ignoreCancelled = true)
    public void creeperBlowUp(EntityExplodeEvent event) {
    	if(event.getEntityType() == EntityType.CREEPER) {
    		event.blockList().iterator().forEachRemaining(Block::breakNaturally);
    		event.blockList().clear();
    	}
    }
    
	@EventHandler
	public void crystalBlowUp(EntityExplodeEvent event) {
		if(event.getEntityType() == EntityType.ENDER_CRYSTAL) {
			event.blockList().clear();
		}
	}
}
