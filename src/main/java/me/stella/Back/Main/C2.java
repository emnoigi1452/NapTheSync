package me.stella.Back.Main;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.stella.Back.BackEndBoot;
import me.stella.Back.PluginLib;

public class C2 {
	
	public static final String _n = "napthesync.utils.help";

	public static void _e(CommandSender _s) {
		boolean _b = b(_s);
		if(!_b) {
			_s.sendMessage(PluginLib.a0._m("no_permission"));
			return;
		}
		try {
			List<String> o = PluginLib.a0._h();
			o.stream().forEach(_l -> _s.sendMessage(_l));
		} catch(Throwable t) { t.printStackTrace(); }
	}
	
	public static void _se(final CommandSender _s) {
		(new BukkitRunnable() {
			public void run() {
				C2._e(_s);
			}
		}).runTask(BackEndBoot.c);
	}
	
	private static boolean b(CommandSender s) {
		if(s instanceof ConsoleCommandSender)
			return true;
		if(s instanceof Player)
			return (s.hasPermission(C2._n) || s.hasPermission(PluginLib._a));
		return false;
	}

}
