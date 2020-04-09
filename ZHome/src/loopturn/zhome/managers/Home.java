package loopturn.zhome.managers;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class Home {
	
	private Player player;
	private String name;
	private World world;
	private Double X;
	private Double Y;
	private Double Z;
	
	public Home(Player player, String name, World world, Double X, Double Y, Double Z) {
		this.player = player;
		this.name = name;
		this.world = world;
		this.X = X;
		this.Y = Y;
		this.Z = Z;
	}
	
	public void addHome() {
		HomeManager.getInstance().addHome(this);
	}
	
	public final World getWorld() {
		return world;
	}

	public final void setWorld(World world) {
		this.world = world;
	}

	public final Double getX() {
		return X;
	}

	public final void setX(Double x) {
		X = x;
	}

	public final Double getY() {
		return Y;
	}

	public final void setY(Double y) {
		Y = y;
	}

	public final Double getZ() {
		return Z;
	}

	public final void setZ(Double z) {
		Z = z;
	}
	
	public final Player getPlayer() {
		return player;
	}

	public final void setPlayer(Player home) {
		this.player = player;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}
	
}