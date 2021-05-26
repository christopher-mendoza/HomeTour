package dev.mendoza.fixtures;

public class Room {
	private Room[] exits;
	private String name;
	private String desc;
	private Fixture item;
	
	public Room(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
		this.exits = new Room[4]; // layout as {north, south, east, west}
	}
	
	public Room[] getExits() {
		return this.exits;
	}
	
	public Room getNorthExit() {
		if(this.exits[0] != null) {
			return this.exits[0];
		}
		return null;
	}
	
	public Room getSouthExit() {
		if(this.exits[1] != null) {
			return this.exits[1];
		}
		return null;
	}
	
	public Room getEastExit() {
		if(this.exits[2] != null) {
			return this.exits[2];
		}
		return null;
	}
	
	public Room getWestExit() {
		if(this.exits[3] != null) {
			return this.exits[3];
		}
		return null;
	}
	
	public void setNorthExit(Room room) {
		this.exits[0] = room;
		room.exits[1] = this;
	}
	
	public void setSouthExit(Room room) {
		this.exits[1] = room;
		room.exits[0] = this;
	}
	
	public void setEastExit(Room room) {
		this.exits[2] = room;
		room.exits[3] = this;
	}
	
	public void setWestExit(Room room) {
		this.exits[3] = room;
		room.exits[2] = this;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Fixture getItem() {
		return item;
	}
	public void setItem(Fixture item) {
		this.item = item;
	}

}
