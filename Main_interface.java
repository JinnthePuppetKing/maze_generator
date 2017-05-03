package maze_generator;

public class Main_interface {

	public static void main(String[] args) {
		
		MazeFactory_TRUE3D factory = new MazeFactory_TRUE3D();
		MazeBuilder Builder = new MazeBuilder(factory);
		Builder.CreateMaze(4, 4, 4);
		
	}

}
