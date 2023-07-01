package me.stella.Back.Main;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.stella.Back.BackEndBoot;

public class C5 {
	
	public static void _e(CommandSender _s, String _pg) {
		try {
			if(_s instanceof Player) {
				Player _p = ((Player)_s);
				if(!(_mc(_p)))
					return;
				if(_ic(_pg))
					((H4)_p.getMetadata(C3._hk).get(0).value())._dp(_s, Integer.valueOf(_pg));
			} else return;
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	public static void _se(final CommandSender _s, String _pg) {
		(new BukkitRunnable() {
			public void run() {
				C5._e(_s, _pg);
			}
		}).runTaskLater(BackEndBoot.c, 20L);
	}
	
	private static boolean _ic(String _ip) {
		try {
			Integer.valueOf(_ip);
			return true;
		} catch(Throwable t) { return false; }
	}
	
	private static boolean _mc(Player _pi) {
		return _pi.hasMetadata(C3._hk);
	}

}
