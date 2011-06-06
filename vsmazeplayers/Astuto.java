package jbs2011.vsoued.maze;
import java.util.ArrayList;
import java.util.HashMap;
import jbs2011.tjhickey.maze.Direction;
import jbs2011.tjhickey.maze.MazePlayer;
import jbs2011.tjhickey.maze.MazePosition;
import jbs2011.tjhickey.maze.MazeView;

public class Astuto extends MazePlayer{
	
	public Astuto(String n) {
		super(n);
	}
	
	public Direction nextMove(HashMap<String,MazePosition> players,ArrayList<MazePosition> jewels,MazeView maze) {
		//get our players position
		MazePosition pointer = players.get(name);
		
		//int northcount = 0;
		//int southcount = 0;
		//int eastcount = 0;
		//int westcount = 0;
		//int topcount=0;
		
		//Direction bestdirection = Direction.CENTER;
		
		
		//checks for jewel at north
		if(pointer.col-1>=0 && !players.containsValue(pointer)){
			//if (maze.canMove(pointer, Direction.NORTH)){
				MazePosition tempointer = pointer;
				tempointer.col--;
				if (jewels.contains(tempointer)){
					return Direction.NORTH;
				}
			//}
		}
		//checks for jewel at south
		if(pointer.col+1<maze.getDepth() && !players.containsValue(pointer)){
			//if (maze.canMove(pointer, Direction.SOUTH)){
				MazePosition tempointer = pointer;
				tempointer.col++;
				if (jewels.contains(tempointer)){
					return Direction.SOUTH;
				}
			//}
		}
		//checks for jewel at east
		if(pointer.row+1<maze.getWidth() && !players.containsValue(pointer)){
			//if (maze.canMove(pointer, Direction.EAST)){
				MazePosition tempointer = pointer;
				tempointer.row++;
				if (jewels.contains(tempointer)){
					return Direction.EAST;
				}
			//}
		}
		//checks for jewel at west
		if(pointer.row-1>=0 && !players.containsValue(pointer)){
			//if (maze.canMove(pointer, Direction.WEST)){
				MazePosition tempointer = pointer;
				tempointer.row--;
				if (jewels.contains(tempointer)){
					return Direction.WEST;
				} 
			//}
		}
		//in preference order
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
		/*
		MazePosition pointer = players.get(name);
		System.out.println(pointer);
		//int northcount = 0;
		//int southcount = 0;
		//int eastcount = 0;
		//int westcount = 0;
		//int topcount=0;
		
		Direction bestdirection = Direction.CENTER;
		
		int northcount = checkAdvance(players,jewels,maze,pointer);
		System.out.println(northcount+"to north");
		int southcount = checkAdvance(players,jewels,maze,pointer);
		System.out.println(southcount+"to south");
		int eastcount = checkAdvance(players,jewels,maze,pointer);
		System.out.println(eastcount+"to east");
		int westcount = checkAdvance(players,jewels,maze,pointer);
		System.out.println(westcount+"to west");
		
		
		if (northcount>topcount){
			topcount=northcount;
			bestdirection=Direction.NORTH;
		}
		if (southcount>topcount){
			topcount=southcount;
			bestdirection=Direction.SOUTH;
		}
		if (eastcount>topcount){
			topcount=eastcount;
			bestdirection=Direction.EAST;
		}
		if (westcount>topcount){
			topcount=westcount;
			bestdirection=Direction.WEST;
		}
		
		System.out.println("topcount"+topcount);
		return bestdirection;
		
	}
	
	private int checkAdvance(HashMap<String,MazePosition> players,ArrayList<MazePosition> jewels,MazeView maze, MazePosition pointer){
		int count = 0;
		//times++;
		//System.out.println(times);
		//MazePosition test = new MazePosition(0,0);
	
		//if (times > 3){
			//System.out.println(count);
			//return count;
		//} else{
			//int topcount = 0;
		
		if(pointer.col-1>=0 && !players.containsValue(pointer)){
			if (maze.canMove(pointer, Direction.NORTH)){
				MazePosition tempointer = pointer;
				tempointer.col--;
				if (jewels.contains(tempointer)){
					count++;
						//System.out.println("found jewel");
				}
						//int temptimes = 0;
						//count += checkAdvance(players,jewels,maze,tempointer,count,times);
					
						//if (northcount>topcount){
						//	topcount = northcount;
						//}
			}
		}
		if(pointer.col+1<maze.getDepth() && !players.containsValue(pointer)){
			if (maze.canMove(pointer, Direction.SOUTH)){
				MazePosition tempointer = pointer;
				tempointer.col++;
				if (jewels.contains(tempointer)){
					count++;
				}
					
						//int temptimes = 0;
						//count += checkAdvance(players,jewels,maze,tempointer,count,times);
					
						//if (southcount>topcount){
						//	topcount = southcount;
						//}
			}
		}
		if(pointer.row+1<maze.getWidth() && !players.containsValue(pointer)){
			if (maze.canMove(pointer, Direction.EAST)){
				MazePosition tempointer = pointer;
				tempointer.row++;
				if (jewels.contains(tempointer)){
					count++;
				}
						//int temptimes = 0;
						//count += checkAdvance(players,jewels,maze,tempointer,count,times);
					
						//if (eastcount>topcount){
						//	topcount = eastcount;
						//}
					
			}
		}
		if(pointer.row-1>=0 && !players.containsValue(pointer)){
			if (maze.canMove(pointer, Direction.WEST)){
				MazePosition tempointer = pointer;
				tempointer.row--;
				if (jewels.contains(tempointer)){
					count++;
				} 
						//int temptimes = 0;
						//count += checkAdvance(players,jewels,maze,tempointer,count,times);
					
						//if (westcount>topcount){
						//	topcount = westcount;
						//}
				
			}
		}
			
	return count;
	}
	
}
*/