package dev.mendoza.game;

import java.util.ArrayList;
import java.util.List;

import dev.mendoza.fixtures.Fixture;
import dev.mendoza.fixtures.Room;

public class Player {
	private Room currentRoom;
	private List<Fixture> inventory;
	
	public Player(Room currentRoom) {
		super();
		this.currentRoom = currentRoom;
		this.inventory = new ArrayList<Fixture>();
	}

	public List<Fixture> getInventory() {
		return inventory;
	}

	public void setInventory(List<Fixture> inventory) {
		this.inventory = inventory;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	// Short description
	public void scout() {
		System.out.println("\nYou are in the " + this.currentRoom.getName() + ".");
		System.out.println(this.currentRoom.getDesc());
	}
	
	// Long description
	public void observe() {
		System.out.println("You observe your surroundings.");
		scout();
		options();
	}
	
	// Take item
	public void take(Fixture item) {
		System.out.println("You take " + item.getName() + ".");
		this.inventory.add(item);
	}
	
	// Print inventory
	public void bag() {
		for(Fixture i : this.inventory) {
			System.out.println();
			System.out.println(i.getName());
			System.out.println(i.getDesc());
		}
	}
	// Show available rooms to player
	public void options() {
		Room[] neighbours = this.currentRoom.getExits();
		System.out.println();
		if(neighbours[0] != null) {
			System.out.println("To the north you see the " + neighbours[0].getName() + ".");
		}
		if(neighbours[1] != null) {
			System.out.println("To the south you see the " + neighbours[1].getName() + ".");
		}
		if(neighbours[2] != null) {
			System.out.println("To the east you see the " + neighbours[2].getName() + ".");
		}
		if(neighbours[3] != null) {
			System.out.println("To the west you see the " + neighbours[3].getName() + ".");
		}
	}
	
	// Help command
	public void help() {
		System.out.println("To traverse around the manor: 'head' [direction]");
		System.out.println("\tWhere direction is 'north'/'south'/'east'/'west'");
		System.out.println("To observe your current room: 'observe'");
		System.out.println("To quit at any time: 'quit'");
		System.out.println("To access controls again: 'help'");
	}
}
