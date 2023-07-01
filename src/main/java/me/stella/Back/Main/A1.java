package me.stella.Back.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class A1 {
	
	private File f;
	private FileConfiguration cfg;
	
	public A1(File f, String a) {
		this.f = new File(f, a);
		try {
			_b_(); _u_();
		} catch(Exception err) { err.printStackTrace(); }
	}
	
	public synchronized void _b_() throws Exception {
		if(!(f.exists()))
			f.createNewFile();
		FileConfiguration a1 = YamlConfiguration.loadConfiguration(f);
		if(!(a1.contains("Queue")))
			a1.set("Queue", new ArrayList<String>());
		a1.save(this.f);
	}
	
	public synchronized void _b2_() throws Exception {
		this.cfg.save(this.f.getAbsoluteFile());
	}
	
	public synchronized void _u_() {
		this.f = this.f.getAbsoluteFile();
		this.cfg = YamlConfiguration.loadConfiguration(this.f);
	}
	
	public boolean _b1_(UUID id) {
		return this.cfg.contains(_p2_(id));
	}
	
	public List<Integer> _i_(UUID id) {
		assert (_b1_(id));
		List<Integer> cb = new ArrayList<Integer>();
		for(String st: this.cfg.getStringList(_p2_(id)))
			cb.add(Integer.valueOf(st));
		return cb;
	}
	
	public synchronized void _w_(UUID i, int p) {
		if(!(_b1_(i)))
			_r_(i);
		List<String> y1 = this.cfg.getStringList(_p2_(i));
		y1.add(String.valueOf(p));
		this.cfg.set(_p2_(i), y1);
	}
	
	public synchronized void _r_(UUID i) {
		this.cfg.set(_p2_(i), null);
		try {
			_b2_();
		} catch(Exception err) { err.printStackTrace(); }
	}
	
	private String _p2_(UUID id) {
		return ("Queue." + id.toString());
	}
	
	public File _f() {
		return this.f;
	}
	
	

}
