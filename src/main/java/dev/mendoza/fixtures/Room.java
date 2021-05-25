package dev.mendoza.fixtures;

public class Room {
	private Room[] exits;
	private String name;
	private String shortDesc;
	private String longDesc;
	public Room(String name, String shortDesc, String longDesc) {
		super();
		this.name = name;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.exits = new Room[4];
	}
	
	public Room[] getExits() {
		return this.exits;
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
	
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	
	
}
