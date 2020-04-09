package loopturn.zhome.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import loopturn.zhome.managers.Home;
import loopturn.zhome.utils.Messages;

public class SetHome implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// Sender can only be players
		if(!(sender instanceof Player)) {
			Messages.sendPlayerInstanceError(sender);
			return true;
		}
		
		Player p = (Player) sender;
		// If sender has permission
		if(!p.hasPermission("zhome.sethome")) {
			Messages.sendPermissionError(p);
			return true;
		}
		
		if(args.length < 1) {
			Messages.sendArgsLengthError(p, "/sethome (HomeName)");
			return true;
		}
		
		setHome(p, args[0]);
		Messages.sendHomeSet(p);
		return true;
	}
	
	private void setHome(Player p, String name) {
		Location l = p.getLocation();
		Home home = new Home(p, name, p.getWorld(), l.getX(), l.getY(), l.getZ());
		home.addHome();
	}

}
