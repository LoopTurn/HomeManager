package loopturn.zhome.core;

import org.bukkit.plugin.java.JavaPlugin;

import loopturn.zhome.commands.Home;
import loopturn.zhome.commands.SetHome;
import loopturn.zhome.managers.Config;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		new Config("config.yml");
		new Config("homes.yml");
		getCommand("sethome").setExecutor(new SetHome());
		getCommand("home").setExecutor(new Home());
	}

}
