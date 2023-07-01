package me.stella.Front;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import me.stella.Back.BackEndBoot;

public class FrontEndBoot extends JavaPlugin {
	
	public static Logger logger = Logger.getLogger("Minecraft");
	private FrontEndAPI api;
	
	@Override
	public void onEnable() {
		try {
			BackEndBoot._a_(this);
		} catch(Throwable t) { t.printStackTrace(); }
		this.api = FrontEndAPI.getAPI();
	}
	
	@Override
	public void onDisable() {
		try {
			BackEndBoot._b_(this);
		} catch(Throwable t) { t.printStackTrace(); }
	}
	
	public FrontEndAPI getAPI() {
		return this.api;
	}

}
