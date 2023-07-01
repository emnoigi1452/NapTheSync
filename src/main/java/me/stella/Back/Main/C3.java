package me.stella.Back.Main;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import me.stella.Back.BackEndBoot;
import me.stella.Back.PluginLib;

public class C3 {
	
	public static final String _n = "napthesync.utils.history";
	public static final String _hk = "napthe-history";
	public static NumberFormat _f;
	
	static {
		_f = NumberFormat.getInstance();
		_f.setMinimumFractionDigits(0);
	}
	
	public static void _e(CommandSender _s, String _u) {
		C3._e(_s, _u, String.valueOf(1));
	}
	
	@SuppressWarnings("deprecation")
	public static void _e(CommandSender _s, String _u, String _pg) {
		boolean _b = b(_s);
		if(!_b) {
			_s.sendMessage(PluginLib.a0._m("no_permission"));
			return;
		}
		try {
			OfflinePlayer _ofp = BackEndBoot.c.getServer().getOfflinePlayer(_u);
			UUID _u1 = _ofp.getUniqueId();
			if(!(_uv(_u1.toString())))
				_s.sendMessage(PluginLib.a0._m("uuid_error"));
			else {
				if(!(PluginLib.a2._k_(_u1)))
					_s.sendMessage(PluginLib.a0._m("no_history"));
				else {
					List<H1> _h = PluginLib.a2._h_(_u1);
					String _t = PluginLib.a0._m("history_show");
					if(_s instanceof ConsoleCommandSender)
						_h.stream().forEach(e -> _s.sendMessage(_t.replace("[amount]", _ps(e._p_())).replace("[time]", _ts(e._td_()))));
					else if(_s instanceof Player) {
						Player _hp = ((Player)_s);
						if(!(_mc(_hp))) {
							List<String> _h4 = new ArrayList<String>();
							_h.stream().forEach(e -> _h4.add(_t.replace("[amount]", _ps(e._p_())).replace("[time]", _ts(e._td_()))));
							H4 _h4i = new H4(_h4);
							_hp.setMetadata(C3._hk, new FixedMetadataValue(BackEndBoot.c, _h4i));
						}
						if(!(_ic(_pg)))
							_s.sendMessage(PluginLib.a0._m("integer_error"));
						else ((H4)_hp.getMetadata(C3._hk).get(0).value())._dp(_s, Integer.valueOf(_pg));
					}
				}
			}
		} catch(Throwable t) { t.printStackTrace(); }
	}
	
	private static boolean _mc(Player _pi) {
		return _pi.hasMetadata(C3._hk);
	}
	
	private static boolean _ic(String _ip) {
		try {
			Integer.valueOf(_ip);
			return true;
		} catch(Throwable t) { return false; }
	}
	
	public static void _se(final CommandSender _s, final String _u) {
		(new BukkitRunnable() {
			public void run() {
				C3._e(_s, _u);
			}
		}).runTaskLater(BackEndBoot.c, 20L);
	}
	
	public static void _se(final CommandSender _s, final String _u, final String _i) {
		(new BukkitRunnable() {
			public void run() {
				C3._e(_s, _u, _i);
			}
		}).runTaskLater(BackEndBoot.c, 20L);
	}
	
	public static String _ts(Date d) {
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		return f.format(d);
	}
	
	public static String _ps(int p) {
		return _f.format((long)p);
	}
	
	private static boolean _uv(String _o) {
		Server _b = BackEndBoot.c.getServer();
		return _b.getOfflinePlayer(UUID.fromString(_o)).hasPlayedBefore();
	}
	
	private static boolean b(CommandSender s) {
		if(s instanceof ConsoleCommandSender)
			return true;
		if(s instanceof Player)
			return (s.hasPermission(C3._n) || s.hasPermission(PluginLib._a));
		return false;
	}
	

}
