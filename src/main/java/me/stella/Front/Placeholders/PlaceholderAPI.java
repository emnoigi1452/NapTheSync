package me.stella.Front.Placeholders;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.stella.Back.PluginLib;
import me.stella.Back.Main.C3;
import me.stella.Front.FrontEndAPI;

public class PlaceholderAPI extends PlaceholderExpansion {
	
	@Override
	public boolean canRegister() {
		return true;
	}

	@Override
	public @NotNull String getIdentifier() {
		return "napthesync";
	}

	@Override
	public @NotNull String getAuthor() {
		return "StellarSeal";
	}

	@Override
	public @NotNull String getVersion() {
		return "v1.1-dev";
	}

	@Override
	public boolean persist() {
		return true;
	}
	
	@Override
	public String onRequest(OfflinePlayer player, String param) {
		switch(param.toLowerCase()) {
			case "has_donate":
				return String.valueOf(PluginLib.a2._k_(player.getUniqueId()));
			case "donated":
				return String.valueOf(FrontEndAPI.getAPI().getDonatedAmount(player.getUniqueId()));
			case "donated_format":
				return C3._f.format((long)FrontEndAPI.getAPI().getDonatedAmount(player.getUniqueId()));
			case "is_syncing":
				return String.valueOf(FrontEndAPI.getAPI().isAwaitSync(player.getUniqueId()));
		}
		return null;
	}
	
}
