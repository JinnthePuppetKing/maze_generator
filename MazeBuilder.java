package maze_generator;

public class MazeBuilder extends Builder {

	private MazeFactory _factory;
	
	public MazeBuilder(MazeFactory factory){
		_factory = factory;
	}
	public Maze CreateMaze (int XMax, int YMax, int ZMax){
		//SAMPLE
		Maze aMaze = _factory.MakeMaze(XMax, YMax, ZMax);
		for (int i = 0 ; i < XMax ; i++){
			
			for (int j = 0 ; j < YMax ; j++){
				
				for (int k = 0 ; k < ZMax ; k++){
					Room aRoom = _factory.MakeRoom(i, j, k);
					aMaze.AddRoom(aRoom);
					System.out.print("{" + i + ", " + j + ", " + k + "} ");
				}
			}
		}
		
		return aMaze;
	}
}
