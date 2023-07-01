package me.stella.Back.Main;

import java.util.Collections;
import java.util.List;

import org.bukkit.command.CommandSender;

import me.stella.Back.PluginLib;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class H4 {
	
	public static final String _c = "/napthesync show <page>";
	
	private List<String> _lh;
	private int _pm;
	
	public H4(List<String> a) {
		this._lh = Collections.synchronizedList(a);
		this._pm = ((int)(a.size() / 10)) + 1;
	}
	
	public int _hs() {
		return this._lh.size();
	}
	
	public int _gmp() {
		return this._pm;
	}
	
	public synchronized void _dp(CommandSender _s, int _ap) {
		if(_ap > _gmp())
			return;
		for(int i = (_ap - 1)*10; ((i < _ap*10) && (i < _hs())); i++)
			_s.sendMessage(this._lh.get(i));
		ComponentBuilder _bd = new ComponentBuilder("");
		_bd.append(_bpb(_ap-1));
		_bd.append(PluginLib.a0._m("page-num").replace("[now]", String.valueOf(_ap)).replace("[max]", String.valueOf(this._pm)));
		_bd.append(_bpn(_ap+1));
		_s.spigot().sendMessage(_bd.create());
	}
	
	private BaseComponent[] _bpb(int _p) {
		ComponentBuilder _t = new ComponentBuilder(PluginLib.a0._m("page-previous"));
		if(_p == 1)
			return _t.create();
		_t.event(new ClickEvent(Action.RUN_COMMAND, H4._c.replace("<page>", String.valueOf(_p))));
		_t.event(U1._b(PluginLib.a0._m("page-previous-hover")));
		return _t.create();
	}
	
	private BaseComponent[] _bpn(int _p) {
		ComponentBuilder _t = new ComponentBuilder(PluginLib.a0._m("page-next"));
		if(_p == 1)
			return _t.create();
		_t.event(new ClickEvent(Action.RUN_COMMAND, H4._c.replace("<page>", String.valueOf(_p))));
		_t.event(U1._b(PluginLib.a0._m("page-next-hover")));
		return _t.create();
	}

}
