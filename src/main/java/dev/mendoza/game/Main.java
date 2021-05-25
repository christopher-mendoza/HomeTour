package dev.mendoza.game;

import dev.mendoza.fixtures.Room;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Room test = new Room("room1", "this is a room", "this is a longer room description");
		Room test2 = new Room("room2", "this is another room", "this is another longer room description");
		
		test.setNorthExit(test2);
		Room[] arrayHolder = test.getExits();
		for(int i = 0; i < test.getExits().length; i++) {
			System.out.println(i);
			System.out.println(arrayHolder[i].getName());
		}
	}

}
