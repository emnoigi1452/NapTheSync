package me.stella.Back.Main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Content;
import net.md_5.bungee.api.chat.hover.content.Text;

public class U1 {
	
	public static String _v() {
		return Bukkit.getServer().getClass().getName().split("\\.")[3];
	}
	
	@SuppressWarnings("deprecation")
	public static HoverEvent _b(String _a) {
		switch(U1._v()) {
			case "v1_12_R1":
				return new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(_a).create());
			case "v1_17_R1":
				List<Content> _h = new ArrayList<Content>();
				_h.add(new Text(new ComponentBuilder(_a).create()));
				return new HoverEvent(HoverEvent.Action.SHOW_TEXT, _h);
			default: return null;
		}
	}

}
