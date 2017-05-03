package maze_generator;

public class Door extends MapSite{

	private Room _originRoom;
	private Room _destinationRoom;
	private Boolean _isOpen;
	private int _doorType;
	
	public Door(Room originRoom, Room destinationRoom, int Type, boolean isOpen){
		
		_isOpen = isOpen;
		_doorType = Type;
		_originRoom = originRoom;
		_destinationRoom = destinationRoom;
		
	}
	
	public Room OtherSideFrom(Room sourceRoom){
		
		final Room _result;
		if (sourceRoom == _originRoom){
			_result = _destinationRoom;
		}else if (sourceRoom == _destinationRoom){
			_result =  _originRoom;
		}else{
			_result = null;
		}
		return _result;
		
	}
	
	public void Enter(){
		
	}

	public int get_doorType() {
		return _doorType;
	}

	public void set_doorType(int _doorType) {
		this._doorType = _doorType;
	}

	public Boolean get_isOpen() {
		return _isOpen;
	}

	public void set_isOpen(Boolean _isOpen) {
		this._isOpen = _isOpen;
	}
	
}
