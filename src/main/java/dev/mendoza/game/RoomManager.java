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
		String studioDesc = "Placeholder Studio Text";
		Room studio = new Room(studioTitle, studioDesc);
		
		String foyerTitle = "Foyer";
		String foyerDesc = "Placeholder Foyer Text";
		Room foyer = new Room(foyerTitle, foyerDesc);
		
		String libraryTitle = "Library";
		String libraryDesc = "Placeholder Library Text";
		Room library = new Room(libraryTitle, libraryDesc);
		
		String diningTitle = "Dining Room";
		String diningDesc = "Placeholder Dining Room Text";
		Room dining = new Room(diningTitle, diningDesc);
		
		String courtTitle = "Courtyard";
		String courtDesc = "Placeholder Courtyard Text";
		Room court = new Room(courtTitle, courtDesc);
		
		String kitchenTitle = "Kitchen";
		String kitchenDesc = "Placeholder Kitchen Text";
		Room kitchen = new Room(kitchenTitle, kitchenDesc);
		
		// Add Items
		String monocleTitle = "Monocle";
		String monocleDesc = "A monocle because the Mendozas are fancy like that.";
		Fixture monocle = new Fixture(monocleTitle, monocleDesc);
		library.setItem(monocle);
		
		String spoonTitle = "Spoon";
		String spoonDesc = "A spoon, the mighty utensil. Only the brave would use it as all three utensils.";
		Fixture spoon = new Fixture(spoonTitle, spoonDesc);
		dining.setItem(spoon);
		
		
		
		
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
