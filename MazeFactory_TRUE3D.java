package maze_generator;

public class MazeFactory_TRUE3D extends MazeFactory{

	@Override
	public Wall MakeWall(Room r1, Room.Direction direction) {
		
		// DEFAULT WALL TYPE FOR THIS FACTORY: 0
		Wall newWall = new Wall(0);
		return newWall;
		
	}

	@Override
	public Door MakeDoor(Room r1, Room r2) {
		
		// Determine from coordinates of room what neighbor they are using r1 as a center
		// Set the sides of those rooms to doors	

		// DEFAULT DOOR FOR THIS FACTORY: ONLY TYPE 0 & OPEN DOOR 
		Door newDoor = new Door(r1, r2, 0, true);	
		if (r1.GetRoomX() == r2.GetRoomX() && r1.GetRoomY() == r2.GetRoomY() && Math.abs(r1.GetRoomZ() - r2.GetRoomZ()) == 1){
			if (r1.GetRoomZ() - r2.GetRoomZ() < 0){
				// r2 is on top
				r1.SetSide(Room.Direction.UP, newDoor);
				r2.SetSide(Room.Direction.DOWN, newDoor);
			} else {
				// r2 is on bottom
				r1.SetSide(Room.Direction.DOWN, newDoor);
				r2.SetSide(Room.Direction.UP, newDoor);
			}
		} else if (r1.GetRoomY() == r2.GetRoomY() && r1.GetRoomZ() == r2.GetRoomZ() && Math.abs(r1.GetRoomX() - r2.GetRoomX()) == 1){
			if (r1.GetRoomX() - r2.GetRoomX() < 0){
				// r2 is to the right
				r1.SetSide(Room.Direction.EAST, newDoor);
				r2.SetSide(Room.Direction.WEST, newDoor);
			} else {
				// r2 is to the left
				r1.SetSide(Room.Direction.WEST, newDoor);
				r2.SetSide(Room.Direction.EAST, newDoor);
			}
		} else if (r1.GetRoomX() == r2.GetRoomX() && r1.GetRoomZ() == r2.GetRoomZ() && Math.abs(r1.GetRoomY() - r2.GetRoomY()) == 1){
			if (r1.GetRoomY() - r2.GetRoomY() < 0){
				// r2 is north
				r1.SetSide(Room.Direction.NORTH, newDoor);
				r2.SetSide(Room.Direction.SOUTH, newDoor);
			} else {
				// r2 is south
				r1.SetSide(Room.Direction.SOUTH, newDoor);
				r2.SetSide(Room.Direction.NORTH, newDoor);
			}
		} else {
			//NOT NEAR EACH OTHER
			throw new IllegalStateException("Coordinates not neighbors");
		}
		
		return newDoor;
	}

	@Override
	public Room MakeRoom(int XVal, int YVal, int ZVal) {
		
		// DEFAULT ROOM TYPE FOR FACTORY: 0
		Room newRoom = new Room(XVal,YVal,ZVal,0);
		return newRoom;
	}

	@Override
	public Maze MakeMaze(int XMax, int YMax, int ZMax) {
		
		Maze newMaze = new Maze();
		return newMaze;
		
	}

}
