package maze_generator;

public abstract class MazeFactory {

	/*
	 * This is the abstract factory class. It is made entirely virtual so it can set up custom
	 * parameters for each type of maze we'd like to return.
	 * 
	 */

	abstract public Wall MakeWall(Room r1, Room.Direction direction);
	abstract public Door MakeDoor(Room r1, Room r2);
	abstract public Room MakeRoom(int XVal, int YVal, int ZVal);
	abstract public Maze MakeMaze(int XMax, int YMax, int ZMax);
	
}
