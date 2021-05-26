package dev.mendoza.game;

import java.util.Scanner;

import dev.mendoza.fixtures.Room;

public class Main {
	// Print error for bad user input
	public static void userInputError(String userInput) {
		System.out.println("I did not understand '" + userInput +
				"'. Please try again. \n"
				+ "(Type 'help' for a reminder of the commands)");
	}
	
	public static void main(String[] args) {
		// Initial Startup
		Room[] house = new Room[6];
		RoomManager game = new RoomManager(house[1], house);
		game.init();
		Player user = new Player(game.getStartingRoom());
		boolean gameOn = true;
		String userInput = "";
		
		String delimiter = "\s+"; // Delimiter for the split() function (splits 
		Scanner userScan = new Scanner(System.in);
		
		System.out.println("Hello! Welcome to the Mendoza Manor!");
		user.help();
		user.scout();
		while(gameOn) {
			userInput = userScan.nextLine();
			if(userInput.matches("[a-zA-Z]+\s*[a-zA-Z]*")) {
				String[] splitUserInput = userInput.split(delimiter);
				if(splitUserInput.length == 1) { // User 1-Part Command Inputed
					switch(userInput) {
						// User Observes
						case "observe": case "Observe": {
							user.observe();
							break;
						}
						
						// User Inventory
						case "inventory": case "Inventory": {
							if(user.getInventory().isEmpty()) {
								System.out.println("You currently do not have any items in your inventory.");
							}
							else {
								user.bag();
							}
							break;
						}
						
						// User Help
						case "h": case "H":
						case "help": case "Help": {
							user.help();
							break;
						}
					
						// User Quit
						case "q": case "Q":
						case "quit": case "Quit": {
							System.out.println("You have exited the manor. See you next time!");
							gameOn = false;
							userScan.close();
							break;
						}
						default: {
							userInputError(userInput);
						}
					}
				}
				else { // User 2-Part Command Inputed ('head' [direction])
					switch(splitUserInput[0]) { // Check first part of command
						// User Attempts Movement
						case "head": case "Head": {
							switch(splitUserInput[1]) { // Check second part of command
								// User attempts North
								case "n": case "N":
								case "north": case "North": {
									if(user.getCurrentRoom().getNorthExit() != null) {
										System.out.println("You head north...");
										user.setCurrentRoom(user.getCurrentRoom().getNorthExit());
										user.scout();
									}
									else {
										System.out.println("There is nothing to your north.");
									}
									break;
								}
								
								// User attempts South
								case "s": case "S":
								case "south": case "South": {
									if(user.getCurrentRoom().getSouthExit() != null) {
										System.out.println("You head south...");
										user.setCurrentRoom(user.getCurrentRoom().getSouthExit());
										user.scout();
									}
									else {
										System.out.println("There is nothing to your south.");
									}
									break;
								}
								
								// User attempts East
								case "e": case "E":
								case "east": case "East": {
									if(user.getCurrentRoom().getEastExit() != null) {
										System.out.println("You head east...");
										user.setCurrentRoom(user.getCurrentRoom().getEastExit());
										user.scout();
									}
									else {
										System.out.println("There is nothing to your east.");
									}
									break;
								}
								
								// User attempts West
								case "w": case "W":
								case "west": case "West": {
									if(user.getCurrentRoom().getWestExit() != null) {
										System.out.println("You head west...");
										user.setCurrentRoom(user.getCurrentRoom().getWestExit());
										user.scout();
									}
									else {
										System.out.println("There is nothing to your west.");
									}
									break;
								}
								
								// User Input Error (direction typed wrong)
								default: {
									userInputError(userInput);
								}
							}
							break;
						}
						
						// User Attempt to Get Item
						case "get": case "Get": {
							if(user.getCurrentRoom().getItem() != null) {
								if(splitUserInput[1].equalsIgnoreCase(user.getCurrentRoom().getItem().getName())) {
									System.out.println("You have acquired a " + user.getCurrentRoom().getItem().getName() + 
											". Congratulations!");
									user.take(user.getCurrentRoom().getItem());
									user.getCurrentRoom().setItem(null);
								}
							}
							else {
								System.out.println("There is no '" + splitUserInput[1] + "' in this room.");
							}
							break;
						}
						
						// User Input Error (wrong 1st part of command)
						default: {
							userInputError(userInput);
						}
					}
				}
			}
			else {
				System.out.println("That was invalid input. Please try again. \n"
						+ "(Type 'help' for a reminder of the commands)");
			}
		}
	}
}
