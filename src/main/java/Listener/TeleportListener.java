package Listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

import HorseTeleport.HorseTeleporter;

public class TeleportListener implements Listener {
	
	private Plugin plugin;

	public TeleportListener(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onCommandExecute(PlayerCommandPreprocessEvent event) {
		Player executingPlayer = event.getPlayer();
		Player teleportingPlayer = null;
		String chat = event.getMessage();
		String command = chat.substring(1, chat.length()).toLowerCase();
		
		if(command.startsWith("tp ") || command.startsWith("tpa ") ||
                   command.startsWith("home") || command.startsWith("warp ")) {

			if(HorseTeleporter.teleport(executingPlayer, executingPlayer, command)) {
				event.setCancelled(true);
			}
			return;
		}
		return;
	}
}
