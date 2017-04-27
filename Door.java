package maze_generator;

public class Door extends MapSite{

	private Room _originRoom;
	private Room _destinationRoom;
	private Boolean _isOpen;
	
	public Door(Room originRoom, Room destinationRoom){
		
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
	
}
