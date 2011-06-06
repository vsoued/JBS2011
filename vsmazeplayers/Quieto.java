package jbs2011.vsoued.maze;
import java.util.ArrayList;
import java.util.HashMap;
import jbs2011.tjhickey.maze.Direction;
import jbs2011.tjhickey.maze.MazePlayer;
import jbs2011.tjhickey.maze.MazePosition;
import jbs2011.tjhickey.maze.MazeView;

public class Quieto extends MazePlayer {
	
	public Quieto (String n) {
		super(n);
	}
	
	public Direction nextMove(HashMap<String,MazePosition> players,ArrayList<MazePosition> jewels,MazeView maze) {
		
			return Direction.CENTER;
	
	}
}
