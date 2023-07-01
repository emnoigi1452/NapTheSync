package me.stella.Back.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class A2 {
	
	private File f;
	private FileConfiguration cfg;
	
	public A2(File f, String a) {
		this.f = new File(f, a);
		try {
			_b_(); _u_(); _c_();
		} catch(Exception err) { err.printStackTrace(); }
	}
	
	public synchronized void _c_() throws Exception {
		FileConfiguration _a = YamlConfiguration.loadConfiguration(this.f);
		for(String _d: _a.getConfigurationSection("History").getKeys(false)) {
			if(_d.equals("Creation"))
				continue;
			String _p = "History." + _d;
			List<String> _u = _a.getStringList(_p); Set<String> z = new HashSet<String>();
			List<String> _o = _u.stream().filter(_x -> !(z.add(_x))).collect(Collectors.toList());
			_a.set(_p, _o); 
		}
		_b1_();
	}
	
	public synchronized void _b_() throws Exception {
		if(!(f.exists()))
			f.createNewFile();
		FileConfiguration a1 = YamlConfiguration.loadConfiguration(f);
		if(!(a1.contains("History")))
			a1.set("History.Creation", System.currentTimeMillis());
		a1.save(this.f);
	}
	
	public synchronized void _b1_() throws Exception {
		this.cfg.save(this.f.getAbsoluteFile());
	}
	
	public synchronized void _u_() {
		this.f = this.f.getAbsoluteFile();
		this.cfg = YamlConfiguration.loadConfiguration(this.f);
	}
	
	public boolean _k_(UUID i) {
		return this.cfg.contains(_kp_(i));
	}
	
	public ConfigurationSection _sct() {
		return this.cfg.getConfigurationSection("History");
	}
	
	public List<H1> _h_(UUID id) {
		assert (_k_(id));
		List<String> d1 = this.cfg.getStringList(_kp_(id));
		Set<String> f1 = new HashSet<String>();
		List<String> d = d1.stream()
				.filter(_dp -> !(f1.add(_dp)))
				.collect(Collectors.toList());
		List<H1> h = new ArrayList<H1>();
		for(String _d1: d)
			h.add(new H1(_d1));
		Collections.sort(h, new Comparator<H1>() {
			@Override
			public int compare(H1 a, H1 b) {
				return -(Long.valueOf(a._t_()).compareTo(Long.valueOf(b._t_())));
			}
		});
		return h;
	}
	
	public synchronized void _w_(UUID id, long t, int p) {
		if(!(_k_(id)))
				_g_(id);
		H1 _himpl = new H1(t, p);
		List<String> dp = this.cfg.getStringList(_kp_(id));
		if(dp.contains(_himpl._c()))
			return;
		dp.add(_himpl._c());
		this.cfg.set(_kp_(id), dp);
	}
	
	private String _kp_(UUID id) {
		return "History.".concat(id.toString());
	}
	
	private void _g_(UUID id) {
		this.cfg.set(_kp_(id), new ArrayList<String>());
	}
	
	public File _f_() {
		return this.f;
	}

}
