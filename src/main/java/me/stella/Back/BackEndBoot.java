package me.stella.Back;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import me.stella.Back.Main.A0;
import me.stella.Back.Main.A1;
import me.stella.Back.Main.A2;
import me.stella.Back.Main.B1;
import me.stella.Back.Main.C0;
import me.stella.Back.Main.H2;
import me.stella.Back.Main.H3;
import me.stella.Front.FrontEndBoot;
import me.stella.Front.Placeholders.PlaceholderAPI;

public class BackEndBoot {
	
	public static JavaPlugin c;
	
	public static void _a_(JavaPlugin b) {
		c = b; b.saveDefaultConfig();
		PluginLib.a0 = new A0(_wp_());
		PluginLib.a1 = new A1(c.getDataFolder(), "Queue.yml");
		PluginLib.a2 = new A2(c.getDataFolder(), "History.yml");
		FrontEndBoot.logger.log(Level.INFO, "Finished setting up internal files!");
		new Thread(() -> {
			File _od = new File(c.getDataFolder(), "data.yml");
			if(_od.exists()) {
				FrontEndBoot.logger.log(Level.INFO, "Attempting to implement old versions of saved data.");
				try {
					FileConfiguration _f = YamlConfiguration.loadConfiguration(_od);
					H3._iq(_f.getConfigurationSection("Data"));
					H3._ih(_f.getConfigurationSection("history"));
					while(!(H3._hs && H3._qs))
						Thread.sleep(2500L);
					_f.save(_od.getAbsoluteFile());
					_od.delete();
					FrontEndBoot.logger.log(Level.INFO, "Finished importing data to the latest version.");
				} catch(Throwable _t) { _t.printStackTrace(); }
			}
		}).start();
		PluginLib.b1 = new B1();
		PluginLib.h2 = new H2(PluginLib.a2._sct());
		c.getServer().getPluginManager().registerEvents(PluginLib.b1, c);
		FrontEndBoot.logger.log(Level.INFO, "Finished setting up the listeners...");
		b.getCommand("napthesync").setExecutor(new C0());
		if(c.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null)
			(new PlaceholderAPI()).register();
		FrontEndBoot.logger.log(Level.INFO, "Finished setting up all the components.");
	}
	
	public static void _b_(JavaPlugin a) throws Exception {
		for(HandlerList h: B1._h())
			h.unregister(PluginLib.b1);
		new Thread(() -> {
			try {
				Thread.sleep(1000L);
				PluginLib.h2._p();
				PluginLib.a1._b2_();
				PluginLib.a2._b1_();
			} catch(Exception e) { e.printStackTrace(); }
		}).start();
	}
	
	private static String _wp_() {
		return (new File(c.getDataFolder(), "config.yml")).getAbsolutePath();
	}
	
}
