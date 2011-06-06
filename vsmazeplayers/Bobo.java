package jbs2011.vsoued.maze;
import java.util.ArrayList;
import java.util.HashMap;
import jbs2011.tjhickey.maze.Direction;
import jbs2011.tjhickey.maze.MazePlayer;
import jbs2011.tjhickey.maze.MazePosition;
import jbs2011.tjhickey.maze.MazeView;

public class Bobo extends MazePlayer {
	
	public Bobo(String n) {
		super(n);
	}
	
	public Direction nextMove(HashMap<String,MazePosition> players,ArrayList<MazePosition> jewels,MazeView maze) {
		MazePosition pointer = players.get(name);
		//moves the place in order of preference if possible, north,west,south,east
		if (maze.canMove(pointer, Direction.NORTH)){
			return Direction.NORTH;
		}else if(maze.canMove(pointer, Direction.WEST)){
			return Direction.WEST;
		}else if(maze.canMove(pointer, Direction.SOUTH)){
			return Direction.SOUTH;
		}else if(maze.canMove(pointer, Direction.EAST)){
			return Direction.EAST;
		}else{
			return Direction.CENTER;
		}
	}
}
