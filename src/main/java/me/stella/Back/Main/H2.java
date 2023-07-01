package me.stella.Back.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.configuration.ConfigurationSection;

import me.stella.Back.PluginLib;

public class H2 {
	
	private Map<UUID, List<H1>> h;
	
	public H2(ConfigurationSection sh) {
		h = Collections.synchronizedMap(new HashMap<UUID, List<H1>>());
		sh.getKeys(false).stream().forEach(e -> {
			if(_i(e)) {
				List<H1> _h1 = new ArrayList<H1>();
				Set<String> _o_ = new HashSet<String>();
				_o_.addAll(sh.getStringList(e));
				for(String u: _o_)
					_h1.add(new H1(u));
				_l(UUID.fromString(e), _h1);
			}
		});
	}
	
	public boolean _i(String _o) {
		try {
			return UUID.fromString(_o).toString().equals(_o);
		} catch(Exception err) { return false; }
	}
	
	public boolean _b_(UUID i) {
		return this.h.containsKey(i);
	}
	
	public List<H1> _o(UUID i) {
		return _b_(i) ? this.h.get(i) : new ArrayList<H1>();
	}
	
	public synchronized void _p(final UUID i) {
		final List<H1> h1 = _o(i);
		new Thread(() -> {
			h1.stream().forEach(p -> {
				PluginLib.a2._w_(i, p._t_(), p._p_());
			});
			try {
				PluginLib.a2._b1_();
			} catch (Exception e1) { e1.printStackTrace(); }
		}).start();
	}
	
	public synchronized void _p() {
		new Thread(() -> {
			this.h.keySet().stream().forEach(e -> {
				List<H1> _hs = this.h.get(e);
				_hs.stream().forEach(p1 -> {
					PluginLib.a2._w_(e, p1._t_(), p1._p_());
				});
			});
			try {
				PluginLib.a2._b1_();
			} catch (Exception e1) { e1.printStackTrace(); }
		}).start();
	}
	
	public synchronized void _l(UUID i, H1 h) {
		List<H1> h1 = _o(i); h1.add(h);
		this.h.put(i, h1);
	}
	
	public synchronized void _l(UUID i, List<H1> _h) {
		List<H1> h1 = _o(i);
		h1.addAll(_h);
		this.h.put(i, h1);
	}

}
