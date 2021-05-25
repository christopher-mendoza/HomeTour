package dev.mendoza.game;

import dev.mendoza.fixtures.Room;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Room[] house = new Room[6];
		RoomManager game = new RoomManager(house[1], house);
		game.init();
		System.out.println(game.getStartingRoom().getName());
		System.out.println(game.getStartingRoom().getShortDesc());
		System.out.println(game.getStartingRoom().getLongDesc());
	}

}
