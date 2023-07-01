package me.stella.Front.Events;

import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DataRequestEvent extends Event {
	
	private static HandlerList handlers = new HandlerList();

	private UUID id;
	private int amount;
	
	public DataRequestEvent(UUID id, int node) {
		this.id = id;
		this.amount = node;
	}
	
	public UUID getRequestID() {
		return this.id;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

}
