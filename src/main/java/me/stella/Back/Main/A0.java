package me.stella.Back.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import net.md_5.bungee.api.ChatColor;

public class A0 {
	
	private File f;
	private YamlConfiguration c;
	private String p;
	
	public A0(String o) {
		_f_(o);
	}
	
	public void _f_(String p) {
		this.p = p;
		this.f = _f1_(p);
		this.c = YamlConfiguration.loadConfiguration(this.f);
	}
	
	public String _d_() {
		return this.p;
	}
	
	public String _p_(int value) {
		return this.c.getString("Donate." + String.valueOf(value));
	}
	
	public List<Integer> _ps() {
		List<Integer> _p1 = new ArrayList<Integer>();
		this.c.getConfigurationSection("Donate").getKeys(false)
			.stream().mapToInt(i -> Integer.valueOf(i).intValue())
			.forEach(_i -> _p1.add(_i));
		return _p1;
	}
	
	public List<String> _h() {
		List<String> _ps = new ArrayList<String>();
		this.c.getStringList("Help").stream()
			.forEach(s -> _ps.add(_c(s)));
		return _ps;
	}
	
	public String _m(String o) {
		String _o = "Messages." + o;
		if(this.c.contains(_o))
			return _c(this.c.getString(_o));
		return (new String());
	}
	
	private String _c(String _p) {
		return ChatColor.translateAlternateColorCodes('&', _p);
	}
	
	private File _f1_(String o) {
		return (new File(o)).getAbsoluteFile();
	}

}
