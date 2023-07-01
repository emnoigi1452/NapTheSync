package me.stella.Back.Main;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.scheduler.BukkitRunnable;

import me.stella.Back.BackEndBoot;
import me.stella.Back.PluginLib;
import me.stella.Front.FrontEndBoot;

public class H3 {
	
	public static DateTimeFormatter _dt;
	public static ZoneId _z;
	
	public static boolean _qs;
	public static boolean _hs;
	
	static {
		_dt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		_z = ZoneId.of("GMT+7");
		_qs = false; _hs = false;
	}
	
	@SuppressWarnings("deprecation")
	public synchronized static void _d(String _i, ConfigurationSection _d) {
		if(!(_uv(_i)))
			return;
		FrontEndBoot.logger.log(Level.INFO, "Updating history record for [" + _i + "]");
		List<H1> _h = new ArrayList<H1>();
		try {
			_d.getKeys(false).stream().forEach(_k -> {
				List<String> _t = _d.getStringList(_k);
				_t.stream().forEach(_t1 -> {
					_h.add(new H1(LocalDateTime.parse(_t1, H3._dt)
							.atZone(H3._z).toInstant().toEpochMilli(), 
							Integer.valueOf(_k).intValue()));
				});
			});
			Collections.sort(_h, new Comparator<H1>() {
				@Override
				public int compare(H1 a, H1 b) {
					return Long.valueOf(a._t_()).compareTo(Long.valueOf(b._t_()));
				}
			});
		} catch(Exception e) { e.printStackTrace(); }
		PluginLib.h2._l(BackEndBoot.c.getServer().getOfflinePlayer(_i).getUniqueId(), _h);
	}
	
	public synchronized static void _ih(ConfigurationSection _x) {
		(new BukkitRunnable() {
			public void run() {
				_x.getKeys(false).stream().forEach(_i -> {
					H3._d(_i, _x.getConfigurationSection(_i));
				});
				PluginLib.h2._p();
				H3._hs = true;
			}
		}).runTaskLaterAsynchronously(BackEndBoot.c, 20L);
	}
	
	public synchronized static void _iq(ConfigurationSection _x) {
		(new BukkitRunnable() {
			public void run() {
				_x.getKeys(false).stream().forEach(_u -> {
					ConfigurationSection _c = _x.getConfigurationSection(_u);
					_c.getKeys(false).stream().forEach(_p -> {
						for(int i = 0; i < _c.getInt(_p); i++)
							PluginLib.a1._w_(UUID.fromString(_u), Integer.valueOf(_p));
					});
				});
				try {
					PluginLib.a1._b2_();
				} catch(Exception e) { e.printStackTrace(); }
				H3._qs = true;
			}
		}).runTaskLaterAsynchronously(BackEndBoot.c, 20L);
	}
	
	@SuppressWarnings("deprecation")
	private static boolean _uv(String _o) {
		return BackEndBoot.c.getServer().getOfflinePlayer(_o).hasPlayedBefore();
	}

}
