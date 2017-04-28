package maze_generator;

public abstract class MazeFactory {

	/*
	 * This is the abstract factory class. It is made entirely virtual so it can set up custom
	 * parameters for each type of maze we'd like to return.
	 */
	
	abstract public Maze MakeGrid();
	abstract public Wall MakeWall();
	abstract public Door MakeDoor();
	abstract public Room MakeRoom();
	abstract public Maze PopulateGrid();
	
	
}
