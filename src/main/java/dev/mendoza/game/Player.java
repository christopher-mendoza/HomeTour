package dev.mendoza.game;

import dev.mendoza.fixtures.Room;

public class Player {
	private Room currentRoom;

	public Player(Room currentRoom) {
		super();
		this.currentRoom = currentRoom;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	// Short description
	public void scout() {
		System.out.println("You enter the " + this.currentRoom.getName());
		System.out.println(this.currentRoom.getShortDesc());
	}
	
	// Long description
	public void observe() {
		System.out.println("You observe your surroundings.");
		System.out.println(this.currentRoom.getLongDesc());
	}
	
	// Show available rooms to player
	public void options() {
		Room[] neighbours = this.currentRoom.getExits();
		if(neighbours[0] != null) {
			System.out.println("To the north you see the " + neighbours[0].getName());
		}
		if(neighbours[1] != null) {
			System.out.println("To the south you see the " + neighbours[1].getName());
		}
		if(neighbours[2] != null) {
			System.out.println("To the east you see the " + neighbours[2].getName());
		}
		if(neighbours[3] != null) {
			System.out.println("To the west you see the " + neighbours[3].getName());
		}
	}
}
