package me.stella.Back.Main;

import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.stella.Back.PluginLib;
import me.stella.Front.FrontEndBoot;

public class C0 implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender _s, Command _c, String _l, String[] _p) {
		if(_p.length == 0)
			_p = new String[] { "help" };
		if(_u(_p[0])) {
			if(_p.length < 2)
				_s.sendMessage(PluginLib.a0._m("param_error"));
			else C1._se(_s, _p[0], _p[1]);
		} else {
			switch(_p[0].toLowerCase()) {
				case "help":
					C2._se(_s); break;
				case "history":
					if(_p.length < 2)
						_s.sendMessage(PluginLib.a0._m("param_error"));
					else {
						if(_p.length >= 3)
							C3._se(_s, _p[1], _p[2]);
						else C3._se(_s, _p[1]);
					}
					break;
				case "reload":
					C4._se(_s); break;
				case "show":
					if(_p.length < 2)
						_s.sendMessage(PluginLib.a0._m("param_error"));
					else C5._se(_s, _p[1]);
					break;
				default:
					FrontEndBoot.logger.log(Level.INFO, "Unknown command " + _p[0].toLowerCase() + "."); break;
			}
		}
		return true;
	}
	
	private boolean _u(String i) {
		UUID _i = UUID.randomUUID();
		try {
			_i = UUID.fromString(i);
		} catch(Exception e) { return false; }
		return _i.toString().equals(i);
	}

}
