package dev.mendoza.game;

import dev.mendoza.fixtures.Fixture;
import dev.mendoza.fixtures.Room;

public class RoomManager {
	private Room startingRoom;
	private Room[] rooms;
	
	public RoomManager(Room startingRoom, Room[] rooms) {
		super();
		this.startingRoom = startingRoom;
		this.rooms = rooms;
	}
	
	public Room getStartingRoom() {
		return startingRoom;
	}
	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}
	public Room[] getRooms() {
		return rooms;
	}
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	
	public void init() {
		// Creating Rooms
		String studioTitle = "Studio";
		String studioDesc = "The studio where nothing gets done and no one is happy about it.";
		Room studio = new Room(studioTitle, studioDesc);
		
		String foyerTitle = "Foyer";
		String foyerDesc = "A unique entranceway laden with badly drawn self-portraits of the Sir Mendoza himself.";
		Room foyer = new Room(foyerTitle, foyerDesc);
		
		String libraryTitle = "Library";
		String libraryDesc = "A library with many books that no one reads.";
		Room library = new Room(libraryTitle, libraryDesc);
		
		String diningTitle = "Dining Room";
		String diningDesc = "A comically small room, with a comically large table taking up a majority of the space.";
		Room dining = new Room(diningTitle, diningDesc);
		
		String courtTitle = "Courtyard";
		String courtDesc = "A place for relaxation? Perhaps, it could be used for more...";
		Room court = new Room(courtTitle, courtDesc);
		
		String kitchenTitle = "Kitchen";
		String kitchenDesc = "With the advent of same-second-delivery-meals-ready-to-eat, this kitchen has seldom been used.";
		Room kitchen = new Room(kitchenTitle, kitchenDesc);
		
		// Add Items
		String monocleTitle = "monocle";
		String monocleDesc = "A monocle because the Mendozas are fancy like that.";
		Fixture monocle = new Fixture(monocleTitle, monocleDesc);
		library.setItem(monocle);
		
		String spoonTitle = "spoon";
		String spoonDesc = "A spoon, the mighty utensil. Only the brave would use it as all three utensils.";
		Fixture spoon = new Fixture(spoonTitle, spoonDesc);
		dining.setItem(spoon);
		
		String stoneTitle = "stone";
		String stoneDesc = "A loose stone, perhaps it is special in some way. But it definately isn't.";
		Fixture stone = new Fixture(stoneTitle, stoneDesc);
		court.setItem(stone);
		
		
		// Attaching Rooms
		/*
		 * Dining <-> Court <-> Kitchen
		 *   ^          ^         ^
		 *   v          v         v
		 * Studio <-> Foyer <-> Library
		 * 
		 */
		studio.setNorthExit(dining);
		studio.setEastExit(foyer);
		
		foyer.setNorthExit(court);
		foyer.setEastExit(library);
		
		library.setNorthExit(kitchen);
		
		court.setWestExit(dining);
		court.setEastExit(kitchen);
		
		// Creating Room Array
		Room[] manor = {studio, foyer, library, dining, court, kitchen};
		
		this.rooms = manor;
		this.startingRoom = manor[1];
	}
}
