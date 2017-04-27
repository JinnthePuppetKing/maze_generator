/**
 * 
 */
package maze_generator;

/**
 * @author nicholasgervais
 *
 */
public class Room extends MapSite{

	private MapSite _sides[] = new MapSite[6];
	private int _roomX, _roomY, _roomZ;
	
	public enum Direction{
		NORTH, EAST, SOUTH, WEST, UP, DOWN
	}
	
	public Room(int roomX, int roomY, int roomZ){
		_roomX = roomX;
		_roomY = roomY;
		_roomZ = roomZ;
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
	
	public void SetSide(Direction direction, MapSite Source){
		
	}
	
	public void Enter(){
		
	}
}
