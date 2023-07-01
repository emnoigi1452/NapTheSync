package me.stella.Front.Events;

import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DataWriteEvent extends Event {
	
	private static HandlerList list = new HandlerList();
	
	private UUID author;
	private long time;
	private int price;
	
	public DataWriteEvent(UUID id, long time, int price) {
		this.author = id;
		this.time = time;
		this.price = price;
	}
	
	public UUID getDonator() {
		return this.author;
	}
	
	public long getDonateTime() {
		return this.time;
	}
	
	public int getDonateAmount() {
		return this.price;
	}
	
	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return list;
	}
	
	public static HandlerList getHandlerList() {
		return list;
	}

}
