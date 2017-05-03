/**
 * 
 */
package maze_generator;

/**
 * @author Nicholas Scott
 *
 */

public class Room extends MapSite{

	//DECLARATIONS
	private MapSite _sides[] = new MapSite[6];
	private int _roomX, _roomY, _roomZ, _roomType;
	private boolean _Entrance = false;
	private boolean _Entity = false;
	private boolean _Checked = false;
	
	public enum Direction{
		NORTH, EAST, SOUTH, WEST, UP, DOWN
	}
	
	//INITIALIZE
	public Room(int roomX, int roomY, int roomZ, int roomType){
		_roomX = roomX;
		_roomY = roomY;
		_roomZ = roomZ;
		_roomType = roomType;
	}
	


	// GETS
	public int get_roomType() {
		return _roomType;
	}
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
		
		MapSite _sideBody;
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
	public boolean is_Entrance() {
		return _Entrance;
	}
	public boolean is_Entity() {
		return _Entity;
	}
	public boolean is_Checked() {
		return _Checked;
	}
	
	//SETS
	public void SetSide(Direction direction, MapSite Source){
		
		switch (direction) {
		case NORTH:
			_sides[0] = Source;
			break;
		case EAST:
			_sides[1] = Source;
			break;
		case SOUTH:
			_sides[2] = Source;
			break;
		case WEST:
			_sides[3] = Source;
			break;
		case UP:
			_sides[4] = Source;
			break;
		case DOWN:
			_sides[5]  = Source;
			break;
		default:
			throw new IllegalStateException("Unknown Directional");
		}
	}
	public void set_roomType(int _roomType) {
		this._roomType = _roomType;
	}
	public void set_Entrance(boolean _Entrance) {
		this._Entrance = _Entrance;
	}
	public void set_Entity(boolean _Entity) {
		this._Entity = _Entity;
	}	
	public void set_Checked(boolean _Checked) {
		this._Checked = _Checked;
	}	
	
	//ACTIONS
	public void Enter(){
		
	}



}
