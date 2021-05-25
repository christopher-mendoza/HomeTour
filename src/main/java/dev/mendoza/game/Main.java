package dev.mendoza.game;

import java.util.Scanner;

import dev.mendoza.fixtures.Room;

public class Main {

	public static void main(String[] args) {
		// Initial Startup
		Room[] house = new Room[6];
		RoomManager game = new RoomManager(house[1], house);
		game.init();
		Player user = new Player(game.getStartingRoom());
		boolean gameOn = true;
		String userInput = "";
		Scanner userScan = new Scanner(System.in);
		
		System.out.println("Hello! Welcome to the Mendoza Manor!");
		user.help();
		while(gameOn) {
			userInput = userScan.nextLine();
			if(userInput.matches("[a-zA-Z]+\s+[a-zA-Z]+")) {
				switch(userInput) {
					// User Help
					case "h":
					case "help": {
						user.help();
					}
					
					// User Quit
					case "q":
					case "quit": {
						System.out.println("You have exited the manor. See you next time!");
						gameOn = false;
						break;
					}
					default: {
						System.out.println("I did not understand '" + userInput +
								"'. Please try again. \n"
								+ "(Type 'help' for a reminder of the commands)");
					}
				}
			}
			else {
				System.out.println("That was invalid input. Please try again. \n"
						+ "(Type 'help' for a reminder of the commands)");
			}
		}
		
//		user.scout();
//		user.observe();
//		user.options();
//		System.out.println(game.getStartingRoom().getShortDesc());
//		System.out.println(game.getStartingRoom().getLongDesc());
//		Room[] test = game.getRooms();
//		for(int i = 0; i < test.length; i++)
//		{
//			System.out.println(test[i].getName());
//		}
	}

}
