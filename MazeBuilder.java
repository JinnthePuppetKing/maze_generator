package maze_generator;

public class MazeBuilder extends Maze {

	private MazeFactory _factory;
	
	public MazeBuilder(MazeFactory factory){
		
	}
	
	public Maze CreateGrid(){
		_factory.MakeGrid();
		
	}
}
