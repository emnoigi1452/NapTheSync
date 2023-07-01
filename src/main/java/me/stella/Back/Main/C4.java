package me.stella.Back.Main;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.stella.Back.BackEndBoot;
import me.stella.Back.PluginLib;

public class C4 {
	
	public static final String _n = "napthesync.utils.reload";

	public static void _e(CommandSender _s) {
		boolean _b = b(_s);
		if(!_b) {
			_s.sendMessage(PluginLib.a0._m("no_permission"));
			return;
		}
		try {
			PluginLib.a0._f_(PluginLib.a0._d_());
			PluginLib.a1._b2_();
			PluginLib.a2._b1_();
			_s.sendMessage(PluginLib.a0._m("reloaded"));
		} catch(Throwable t) { t.printStackTrace(); }
	}
	
	public static void _se(final CommandSender _s) {
		(new BukkitRunnable() {
			public void run() {
				C4._e(_s);
			}
		}).runTaskLater(BackEndBoot.c, 20L);
	}
	
	private static boolean b(CommandSender s) {
		if(s instanceof ConsoleCommandSender)
			return true;
		if(s instanceof Player)
			return (s.hasPermission(C4._n) || s.hasPermission(PluginLib._a));
		return false;
	}


}
