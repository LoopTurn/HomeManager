package loopturn.zhome.managers;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import loopturn.zhome.core.Main;

public class Config {
	
	private File file;
	private FileConfiguration fileConfig;
	private String name;
	
	// Create a config on call
	// Automatically registers it
	public Config(String name) {
		this.name = name;
		Main plugin = Main.getPlugin(Main.class);
		file = new File(plugin.getDataFolder(), this.name);
		
		createConfig(plugin, false);
		ConfigManager.getInstance().addConfig(this);
	}
	
	// Creates the config file the first time
	private final void createConfig(Main plugin, Boolean overwrite) {
		if(!file.exists()) {
			file.getParentFile().mkdirs();
			plugin.saveResource(name, overwrite);
		}
		
		fileConfig = new YamlConfiguration();
		try {
			fileConfig.load(file);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// Saves config file
	// returns true if completed sucessfully, false if failed
	public final boolean saveConfig(File file) {
		try {
			fileConfig.save(file);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Gets the config
	public final FileConfiguration getConfig() {
		return fileConfig;
	}


	public final String getName() {
		return name;
	}


	public final void setName(String name) {
		this.name = name;
	}

	public final File getFile() {
		return file;
	}

	public final void setFile(File file) {
		this.file = file;
	}
}
