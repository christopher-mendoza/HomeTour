package dev.mendoza.game;

import dev.mendoza.fixtures.Room;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Room[] house = new Room[6];
		RoomManager game = new RoomManager(house[1], house);
		game.init();
		Player user = new Player(game.getStartingRoom());
		user.scout();
		user.observe();
		user.options();
//		System.out.println(game.getStartingRoom().getShortDesc());
//		System.out.println(game.getStartingRoom().getLongDesc());
//		Room[] test = game.getRooms();
//		for(int i = 0; i < test.length; i++)
//		{
//			System.out.println(test[i].getName());
//		}
	}

}
