package Listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.plugin.Plugin;

public class TeleportListener implements Listener {
	
	private Plugin plugin;

	public TeleportListener(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onCommandExecute(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		String chat = event.getMessage();
		String command = chat.substring(1, chat.length());
		
		if(command.startsWith("tp") || command.startsWith("warp") || command.startsWith("home") || command.startsWith("spawn")) {
			if(player.isInsideVehicle() && player.getVehicle().getType().equals(EntityType.HORSE)) {
				Horse horse = (Horse) player.getVehicle();
				horse.eject();
				player.performCommand(command);
				horse.teleport(player.getLocation());
				horse.setPassenger(player);
				event.setCancelled(true);
				return;
			}
			return;
		}
		return;
	}
}
