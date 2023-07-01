package me.stella.Front;

import java.util.List;
import java.util.UUID;

import me.stella.Back.PluginLib;
import me.stella.Back.Main.H1;

public class FrontEndAPI {
	
	private static FrontEndAPI api;
	
	static {
		api = new FrontEndAPI();
	}
	
	public static FrontEndAPI getAPI() {
		return api;
	}
	
	public boolean hasDonated(UUID id) {
		return PluginLib.h2._b_(id);
	}
	
	public int getDonatedAmount(UUID id) {
		if(!(hasDonated(id)))
			return 0;
		List<H1> history = PluginLib.h2._o(id);
		int amount = 0;
		for(H1 entry: history)
			amount += entry._p_();
		return amount;
	}
	
	public boolean isAwaitSync(UUID id) {
		return PluginLib.a1._b1_(id);
	}

}
