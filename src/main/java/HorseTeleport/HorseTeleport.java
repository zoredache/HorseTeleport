package HorseTeleport;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Listener.TeleportListener;

public class HorseTeleport extends JavaPlugin {

	PluginManager pm = getServer().getPluginManager();
	
	@Override
	public void onEnable() {
		pm.registerEvents(new TeleportListener(this), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
