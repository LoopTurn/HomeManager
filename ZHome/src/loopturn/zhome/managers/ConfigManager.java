package loopturn.zhome.managers;

import java.util.LinkedList;

public class ConfigManager {
	
	private static ConfigManager configManager = new ConfigManager();
	private LinkedList<Config> configs = new LinkedList<Config>();

	// Restricting constructor
	private ConfigManager() {
		
	}
	
	// Used to get instance
	public static ConfigManager getInstance() {
		return configManager;
	}


	// Registers a config
	public void addConfig(Config config) {
		configs.add(config);
	}
	
	// Returns config if found, if not found returns null
	public Config getConfigByName(String name) {
		for(Config config : configs) {
			if(config.getName().equalsIgnoreCase(name)) {
				return config;
			}
		}
		return null;
	}
	
}
