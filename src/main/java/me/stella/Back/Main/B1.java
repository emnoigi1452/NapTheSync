package me.stella.Back.Main;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.stella.Back.BackEndBoot;
import me.stella.Back.PluginLib;
import me.stella.Front.Events.DataWriteEvent;

public class B1 implements Listener {
	
	public static Server sp = BackEndBoot.c.getServer();
	
	@EventHandler
	public void _o(final PlayerJoinEvent e) {
		final OfflinePlayer _ofp = ((OfflinePlayer)e.getPlayer());
		(new BukkitRunnable() {
			public void run() {
				final A1 a1 = PluginLib.a1; final A0 a0 = PluginLib.a0;
				if(a1._b1_(_ofp.getUniqueId())) {
					new BukkitRunnable() {
						public void run() {
							a1._i_(_ofp.getUniqueId()).stream()
								.forEach(_e -> {
									String _e1 = a0._p_(Integer.valueOf(_e).intValue()).replace("%player%", _ofp.getName());
									sp.dispatchCommand(sp.getConsoleSender(), _e1);
									_c(_ofp.getUniqueId(), Integer.valueOf(_e).intValue());
									_wh(_ofp.getUniqueId(), Integer.valueOf(_e).intValue());
								});
							a1._r_(_ofp.getUniqueId());
							PluginLib.h2._p(_ofp.getUniqueId());
						}
					}.runTask(BackEndBoot.c);
				}
				return;
			}
		}).runTask(BackEndBoot.c);
	}
	
	@EventHandler
	public void _o(PlayerQuitEvent e) {
		final UUID id = e.getPlayer().getUniqueId();
		new Thread(() -> {
			PluginLib.h2._p(id);
		});
	}
	
	private void _c(UUID i, int p) {
		BackEndBoot.c.getServer().getPluginManager().callEvent(new DataWriteEvent(i, System.currentTimeMillis(), p));
	}
	
	private void _wh(UUID i, int p) {
		PluginLib.h2._l(i, new H1(System.currentTimeMillis(), p));
	}
	
	public static List<HandlerList> _h() throws Exception {
		List<HandlerList> h1 = new ArrayList<HandlerList>();
		Method[] m = B1.class.getMethods();
		for(Method m1: m) {
			if(m1.isAnnotationPresent(EventHandler.class)) {
				Class<?> p1 = m1.getParameters()[0].getType();
				Object o = p1.getMethod("getHandlerList", new Class<?>[] {}).invoke(null, new Object[] {});
				h1.add((HandlerList)o);
			}
		}
		return h1;
	}
}
