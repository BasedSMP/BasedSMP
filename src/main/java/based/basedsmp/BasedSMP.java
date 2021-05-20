package based.basedsmp;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import net.md_5.bungee.api.ChatColor;

public class BasedSMP extends JavaPlugin {
    private Server mc = Bukkit.getServer();
    private Logger log = this.getLogger();
    private PluginManager pm = mc.getPluginManager();

    @Override
    public void onEnable() {
        Reflections reflections = new Reflections("based.basedsmp.events");

        for (Class <? extends Listener> event : reflections.getSubTypesOf(Listener.class)) {
        	try {
        		pm.registerEvents(event.getDeclaredConstructor().newInstance(), this);
        		log.info("Registered " + event.getSimpleName());
        	} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
        		e.printStackTrace();
        	}
        }
        
    	Bukkit.getOnlinePlayers().forEach(player -> {
        	RainbowText text = new RainbowText("BasedSMP", ChatColor.BOLD + "" + ChatColor.ITALIC);
        	
    		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
    			public void run() { 
    				text.moveRainbow();
    				
    				player.setPlayerListHeaderFooter(text.getText(), "ping: " + player.getPing() + " | time: " + new SimpleDateFormat("hh:mm:ss").format(new Date()));
    			}
    		}, 0L, 2);
    	});
       }
}