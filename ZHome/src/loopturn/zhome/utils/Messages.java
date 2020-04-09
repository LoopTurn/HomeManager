package loopturn.zhome.utils;

import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class Messages {
	
	public static void sendMessage(CommandSender sender, String message) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
	}
	
	public static void sendPlayerInstanceError(CommandSender sender) {
		sendMessage(sender, "&cYou must be a player to use this command!");
	}

	public static void sendPermissionError(CommandSender sender) {
		sendMessage(sender, "&cYou do not have permission to use this!");
	}

	public static void sendArgsLengthError(CommandSender sender, String string) {
		sendMessage(sender, "&cYou didn't specify the correct arguments! Ex. " + string);
	}

	public static void sendHomeSet(CommandSender sender) {
		sendMessage(sender, "&aYour home has been set!");
	}

}
