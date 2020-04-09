package loopturn.zhome.managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class HomeManager {
	
	private static HomeManager homeManager = new HomeManager();
	private Config homes = ConfigManager.getInstance().getConfigByName("homes.yml");
	
	// Get instance of homemanager
	public static HomeManager getInstance() {
		return homeManager;
	}
	
	// Blocked off constructor
	private HomeManager() {}

	// Get all players homes
	public LinkedList<Home> getPlayersHomes(Player p) {
		LinkedList<Home> playersHomes = new LinkedList<Home>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ConfigManager.getInstance().getConfigByName("homes.yml").getFile()));
			String line;
			while((line = reader.readLine()) != null) {
				String[] home = line.toString().split(",");
				if(home[0] == p.getUniqueId().toString()) {
					playersHomes.add(new Home(Bukkit.getPlayer(home[0]), home[1], Bukkit.getWorld(home[2]), Double.parseDouble(home[3]), Double.parseDouble(home[4]), Double.parseDouble(home[5])));
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return playersHomes;
	}

	// Registers a home
	public void addHome(Home home) {
		File file = homes.getFile();
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(home.getPlayer().getUniqueId() + "," + home.getName() + "," + home.getWorld() + "," + home.getX() + "," + home.getY() + "," + home.getZ());
			writer.close();
			homes.saveConfig(homes.getFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}