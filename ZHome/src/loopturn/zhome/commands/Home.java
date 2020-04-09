package loopturn.zhome.commands;

import java.util.LinkedList;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import loopturn.zhome.managers.HomeManager;
import loopturn.zhome.utils.Messages;

public class Home implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// Check if player
		if(!(sender instanceof Player)) {
			Messages.sendPlayerInstanceError(sender);
			return true;
		}
		Player p = (Player) sender;
		
		// Check perms
		if(!sender.hasPermission("zhome.home")) {
			Messages.sendPermissionError(sender);
			return true;
		}
		
		if(args.length < 1) {
			Messages.sendArgsLengthError(p, "/home (HomeName)");
			return true;
		}
		
		LinkedList<loopturn.zhome.managers.Home> homes = HomeManager.getInstance().getPlayersHomes(p);
		loopturn.zhome.managers.Home home = homes.get(0);
		p.teleport(new Location(home.getWorld(), home.getX(), home.getY(), home.getZ()));
		return true;
	}

}
