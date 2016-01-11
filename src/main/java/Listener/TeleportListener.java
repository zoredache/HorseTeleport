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
		
		if(command.startsWith("tp") || command.startsWith("warp") || command.startsWith("home") || command.startsWith("spawn")) {
			if(command.startsWith("tphere") || command.startsWith("tpahere")) {
				String playerTeleportingName = null;
				if(command.startsWith("tphere")) {
					playerTeleportingName = command.substring(7);
				}
				if(command.startsWith("tpahere")) {
					playerTeleportingName = command.substring(8);
				}
				
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(p.getName().equals(playerTeleportingName)) {
						teleportingPlayer = p;
					}
				}
				
				if(HorseTeleporter.teleport(executingPlayer, teleportingPlayer, command)) {
					event.setCancelled(true);
				}
				return;
			}

			if(HorseTeleporter.teleport(executingPlayer, executingPlayer, command)) {
				event.setCancelled(true);
			}
			return;
		}
		return;
	}
}
