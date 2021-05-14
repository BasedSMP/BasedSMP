package based.basedsmp.events;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class PVPExplosions implements Listener {
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
	
	@EventHandler
	public void crystalBlowUp(EntityExplodeEvent event) {
		if(event.getEntity().toString().contains("EnderCrystal")) {
			event.blockList().clear();
		}
	}
}
