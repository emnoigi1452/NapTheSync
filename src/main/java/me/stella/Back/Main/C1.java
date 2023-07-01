package me.stella.Back.Main;

import java.util.List;
import java.util.UUID;

import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.stella.Back.BackEndBoot;
import me.stella.Back.PluginLib;
import me.stella.Front.Events.DataRequestEvent;

public class C1 {
	
	public static final String _n = "napthesync.sync.donation";
	
	public synchronized static void _e(CommandSender _s, String _p1, String _p2) {
		boolean _b = b(_s);
		if(!_b) {
			_s.sendMessage(PluginLib.a0._m("no_permission"));
			return;
		}
		try {
			if(!(_uv(_p1)))
				_s.sendMessage(PluginLib.a0._m("uuid_error"));
			else {
				if(!(_pc(_p2)))
					_s.sendMessage(PluginLib.a0._m("integer_error"));
				else {
					UUID _i = UUID.fromString(_p1);
					int _p = Integer.valueOf(_p2).intValue();
					PluginLib.a1._w_(_i, _p);
					BackEndBoot.c.getServer().getPluginManager().callEvent(
							new DataRequestEvent(_i, _p));
				}
			}
		} catch(Throwable t) { t.printStackTrace(); }
	}
	
	public synchronized static void _se(final CommandSender _s, final String _p1, final String _p2) {
		(new BukkitRunnable() {
			public void run() {
				C1._e(_s, _p1, _p2);
			}
		}).runTask(BackEndBoot.c);
	}
	
	private static boolean b(CommandSender s) {
		if(s instanceof ConsoleCommandSender)
			return true;
		if(s instanceof Player)
			return (s.hasPermission(C1._n) || s.hasPermission(PluginLib._a));
		return false;
	}
	
	private static boolean _pc(String _o) {
		try {
			List<Integer> _o1 = PluginLib.a0._ps();
			int af = Integer.valueOf(_o).intValue();
			return _o1.contains(af);
		} catch(Exception e) { return false; }
	}
	
	private static boolean _uv(String _o) {
		Server _b = BackEndBoot.c.getServer();
		return _b.getOfflinePlayer(UUID.fromString(_o)).hasPlayedBefore();
	}

}
