package maze_generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Maze {

	private int uncheckedRooms = 0;
	private int entranceRooms = 0;
	private ArrayList<Room> Rooms = new ArrayList<Room>();
	
	//INSTNATIATE
	public Maze(){
		
	}
	
	//ROOMS
	public void AddRoom(Room _room){
	
		//Check to make sure duplicate room doesn't exist
		//NOT DONE
		if (!_room.is_Entrance()){
			
			entranceRooms++;
		}
		if (!_room.is_Entity()){
			
			uncheckedRooms++;
		}
		Rooms.add(_room);
		this.checkedReset();
		
	}
	public void RemoveRoom(int XVal, int YVal, int ZVal){
		
		//Use an iterator to find proper room coordinate and remove
		for (int i = 0 ; i < Rooms.size() ; i++){
			if (Rooms.get(i).GetRoomX() == XVal && Rooms.get(i).GetRoomY() == YVal && Rooms.get(i).GetRoomZ() == ZVal){
				Rooms.remove(i);
			}
		}
	}
	public Room RoomLookup(int X, int Y, int Z){
		
		for (int i = 0 ; i < Rooms.size() ; i++){
			if (Rooms.get(i).GetRoomX() == X && Rooms.get(i).GetRoomY() == Y && Rooms.get(i).GetRoomZ() == Z) return Rooms.get(i);
		}
		// Search through room for desired result
		return null;
	}
	public boolean ValidateRoomArray(){
		
		//DECLARATIONS
		boolean allRoomsUsed;
		ArrayList<Room> workingRooms = new ArrayList<Room>();
		
		//Make sure minimum two unchecked rooms in array
		if (uncheckedRooms <= 2) return false;
		
		//Check for duplicates
		Set<Room> set = new HashSet<Room>(Rooms);
		if(set.size() < Rooms.size()){
			return false;
		}
		
		//Find first room
		Iterator<Room> itr = Rooms.iterator();
		while (itr.hasNext()){
			Room i = itr.next();
			if (!i.is_Entity()){
				workingRooms.add(i);
				break;
			}
		}
		
		//Set all Rooms to unchecked
				this.checkedReset();
				
		//Cycle
		int len = Rooms.size();
		boolean _noNeighbor = false;
		Room j = null;
		Room currentRoom = workingRooms.get(0);
		currentRoom.set_Checked(true);
		
		while (allRoomsUsed = false){
			
			_noNeighbor = false;
			//check all six directions
			for (int i = 0 ; i < len ; i++){
				
				//Make sure it isn't the same room
				if (!Rooms.get(i).equals(currentRoom)){
					j = Rooms.get(i);
					//CHECK ALL SIX NEIGHBORS
					if ((j.GetRoomX() == (currentRoom.GetRoomX() - 1) && j.GetRoomY() == currentRoom.GetRoomY() && j.GetRoomZ() == currentRoom.GetRoomZ()) ||
							(j.GetRoomX() == (currentRoom.GetRoomX() + 1) && j.GetRoomY() == currentRoom.GetRoomY() && j.GetRoomZ() == currentRoom.GetRoomZ()) || 
							(j.GetRoomX() == currentRoom.GetRoomX() && j.GetRoomY() == (currentRoom.GetRoomY() - 1) && j.GetRoomZ() == currentRoom.GetRoomZ()) ||
							(j.GetRoomX() == currentRoom.GetRoomX() && j.GetRoomY() == (currentRoom.GetRoomY() + 1) && j.GetRoomZ() == currentRoom.GetRoomZ()) ||
							(j.GetRoomX() == currentRoom.GetRoomX() && j.GetRoomY() == currentRoom.GetRoomY() && j.GetRoomZ() == (currentRoom.GetRoomZ() - 1)) ||
							(j.GetRoomX() == currentRoom.GetRoomX() && j.GetRoomY() == currentRoom.GetRoomY() && j.GetRoomZ() == (currentRoom.GetRoomZ() + 1)))
					{// FOUND A NEIHGBOR

						//Has the room been checked before or is it an entity?
						if (!j.is_Checked() && !j.is_Entity()){
							j.set_Checked(true);
							workingRooms.add(j);
							currentRoom = workingRooms.get(workingRooms.size() - 1);
							break;
						}	
					}
				}
				
				//Checked all rooms and didn't find a neighbor, time to back up
				if (i == (len - 1)) {
					_noNeighbor = true;
				}
			}
			
			if (_noNeighbor == true & workingRooms.size() > 1){
			
				// more than one room left and no available neighbors, set the working room to previous room
				currentRoom = workingRooms.get(workingRooms.size() - 2);
				// lop off the end room and work from previous
				workingRooms.remove(workingRooms.size() - 1);
				
			} else if (workingRooms.size() <= 1 && _noNeighbor == true){
				
				allRoomsUsed = true;
				//only one room left and no available neighbors
				//TEST HERE FOR REMAINING UNCHECKED ROOMS
				for (int i = 0 ; i < len ; i++){
					if (!Rooms.get(i).is_Checked() && !Rooms.get(i).is_Entity()) {
						this.checkedReset();
						return false;
					}
					//I found a room after iteration still remaining, validation fail
				}
			}
		}
		return true;
	}

	private void checkedReset() {
		for (int i = 0 ; i < Rooms.size() ; i++){
			Rooms.get(i).set_Checked(false);
		}
	}
}
