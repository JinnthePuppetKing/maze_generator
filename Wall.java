package maze_generator;

public class Wall extends MapSite{
	private int _wallType = 0;

	public int get_wallType() {
		return _wallType;
	}

	public void set_wallType(int _wallType) {
		this._wallType = _wallType;
	}

	public Wall(int Type){
		this._wallType = Type;
	}
	
	public void Enter(){
		
	}
	
}
