/**
 * 
 */
package maze_generator;

/**
 * @author nicholasgervais
 *
 */
public class Room extends MapSite{

	//DECLARATIONS
	private MapSite _sides[] = new MapSite[6];
	private int _roomX, _roomY, _roomZ, _roomType;
	private boolean _isEntrance = false;
	public enum Direction{
		NORTH, EAST, SOUTH, WEST, UP, DOWN
	}
	
	//INITIALIZE
	public Room(int roomX, int roomY, int roomZ){
		_roomX = roomX;
		_roomY = roomY;
		_roomZ = roomZ;
	}
	
	// GETS
	public int GetRoomX(){
		return _roomX;
	};
	public int GetRoomY(){
		return _roomY;
	}
	public int GetRoomZ(){
		return _roomZ;
	}
	public MapSite GetSide(Direction direction){
		
		final MapSite _sideBody;
		switch (direction) {
			case NORTH:
				_sideBody = _sides[0];
				break;
			case EAST:
				_sideBody = _sides[1];
				break;
			case SOUTH:
				_sideBody = _sides[2];
				break;
			case WEST:
				_sideBody = _sides[3];
				break;
			case UP:
				_sideBody = _sides[4];
				break;
			case DOWN:
				_sideBody = _sides[5];
				break;
			default:
				_sideBody = null;
		}
		
		return _sideBody;
	}
	
	//SETS
	public void SetSide(Direction direction, MapSite Source){
		
	}
	
	//ACTIONS
	public void Enter(){
		
	}
}
