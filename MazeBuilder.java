package maze_generator;

public class MazeBuilder {

	private MazeFactory _factory;
	
	public MazeBuilder(MazeFactory factory){
		_factory = factory;
	}
	
	public Grid CreateGrid(int Xmax, int Ymax, int Zmax){
		return _factory.MakeGrid();
		
	}
	
}
