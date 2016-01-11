package HorseTeleport;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

public class HorseTeleporter {

	public static boolean teleport(Player executingPlayer, Player teleportingPlayer, String command) {
		if(teleportingPlayer.isInsideVehicle() && teleportingPlayer.getVehicle().getType().equals(EntityType.HORSE)) {
			Horse horse = (Horse) teleportingPlayer.getVehicle();
			horse.eject();
			executingPlayer.performCommand(command);
			horse.teleport(teleportingPlayer.getLocation());
			horse.setPassenger(teleportingPlayer);
			return true;
		}
		return false;
	}
	
}
