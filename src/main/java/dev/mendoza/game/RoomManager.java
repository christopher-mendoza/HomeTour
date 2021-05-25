package dev.mendoza.game;

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
		
		String studioTitle = "Studio";
		String studioSDesc = "Placeholder Studio Text";
		String studioLDesc = "Placehold Long Studio Text";
		Room studio = new Room(studioTitle, studioSDesc, studioLDesc);
		
		String foyerTitle = "Foyer";
		String foyerSDesc = "Placeholder Foyer Text";
		String foyerLDesc = "Placeholder Long Foyer Text";
		Room foyer = new Room(foyerTitle, foyerSDesc, foyerLDesc);
		
		String libraryTitle = "Library";
		String librarySDesc = "Placeholder Library Text";
		String libraryLDesc = "Placeholder Long Library Text";
		Room library = new Room(libraryTitle, librarySDesc, libraryLDesc);
		
		String diningTitle = "Dining Room";
		String diningSDesc = "Placeholder Dining Room Text";
		String diningLDesc = "Placeholder Long Dining Room Text";
		Room dining = new Room(diningTitle, diningSDesc, diningLDesc);
		
		String courtTitle = "Courtyard";
		String courtSDesc = "Placeholder Courtyard Text";
		String courtLDesc = "Placeholder Long Courtyard Text";
		Room court = new Room(courtTitle, courtSDesc, courtLDesc);
		
		String kitchenTitle = "Kitchen";
		String kitchenSDesc = "Placeholder Kitchen Text";
		String kitchenLDesc = "Placeholder Long Kitchen Text";
		Room kitchen = new Room(kitchenTitle, kitchenSDesc, kitchenLDesc);
		
		Room[] manor = {studio, foyer, library, dining, court, kitchen};
		
		this.rooms = manor;
		this.startingRoom = manor[1];
	}
}
