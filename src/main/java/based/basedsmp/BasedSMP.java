package based.basedsmp;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import based.basedsmp.events.PVPExplosions;

public class BasedSMP  extends JavaPlugin {
	private Server mc = Bukkit.getServer();
	private Logger log = this.getLogger();
	private PluginManager pm = mc.getPluginManager();
	
	@Override
    public void onEnable() {
		log.info("\n------------------\n"
				+ "based???\n"
				+ "based on what??\n"
				+ "------------------");
		
		pm.registerEvents(new PVPExplosions(), this);
    }

}
