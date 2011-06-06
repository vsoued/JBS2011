package jbs2011.vsoued.maze;

import java.util.ArrayList;

import jbs2011.tjhickey.maze.MazePlayer;
import jbs2011.tjhickey.maze.RandomPlayer;

public class Game {
	public static void main(String[] arrrrrgs){
		  ArrayList<MazePlayer> players = new ArrayList<MazePlayer>();
		  players.add(new jbs2011.vsoued.maze.Bobo("Bobo"));
		  //players.add(new jbs2011.vsoued.maze.Quieto("Quieto"));
		  players.add(new jbs2011.vsoued.maze.Astuto("Astuto"));
		  //players.add(new RandomPlayer("Randi"));
		  jbs2011.tjhickey.maze.MazeGame.playTournament( players);
	}
}
