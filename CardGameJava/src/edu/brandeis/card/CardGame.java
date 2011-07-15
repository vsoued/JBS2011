package edu.brandeis.card;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class CardGame {
	private static CardPlayer player1;
	private static CardPlayer player2;
	private static int games;
	private static String[][] topboard;
	private static String[][] bottomboard;
	private static HashMap<String,String> map;
	private static ArrayList<Pair> gamepairs;
	
	public static void main(String[] args){
		
		System.out.println("Choose category: adjectives, animals, body, colors, family, greetings, numbers or pets.");
		
		boolean started = false;
		
		while(!started){
			
			Scanner scan = new Scanner(System.in);
			String chosen = scan.next();
			
			try {
				started = setGame(chosen);
			
			} catch (FileNotFoundException e) {
				System.out.println("File not found! Please type file correctly");
			}
		}
	}
	
	private static int getRandom(Random rand, HashSet<Integer> set, ArrayList list){
		
		int c = rand.nextInt(list.size());
		
		if (!set.contains(c)){
			set.add(c);
			//System.out.println(c);
			return c;
		} else {
			return getRandom(rand,set,list);
		}
	}
	
	private static boolean setGame(String cat) throws FileNotFoundException{
		Scanner read = new Scanner(new File("/Users/violetasoued/Documents/workspace/CardGameJava/src/edu/brandeis/card/"+cat+".txt"));
		map = new HashMap<String,String>();
		
		
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		read.useDelimiter("	-	");
		while (read.hasNextLine()){
			String key = read.next();
			read.skip("	-	");
			String value = read.nextLine();
			pairs.add(new Pair(key,value));
		}	
		//System.out.println(pairs);
		gamepairs = new ArrayList<Pair>();
		//HashSet<Integer> set = new HashSet<Integer>();
		Random rand = new Random();

		for (int x = 0; x < 9; x++){
			int d = rand.nextInt(pairs.size());
			gamepairs.add(pairs.get(d));
			map.put(pairs.get(d).getKey(), pairs.get(d).getValue());
			pairs.remove(d);
			//gamepairs.add(pairs.get(getRandom(new Random(), new HashSet<Integer>(),pairs)));;
		}

		//System.out.println(gamepairs);
		topboard = setBoard(topboard, "top");
		
		
		bottomboard = setBoard(bottomboard,"bottom");
		
		start();
		
		
		
		
		
		
		
		return true;
	}
	
	private static String[][] setBoard(String[][] board, String i){
		
		ArrayList<Pair> setting = new ArrayList<Pair>(gamepairs);
		Random rand = new Random();
		
		board = new String[3][3];
		
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				
				int d = rand.nextInt(setting.size());
				
				if (i.equals("top")){
					board[x][y]= setting.get(d).getKey();
					//System.out.println(board[x][y]);
					
				} else if (i.equals("bottom")){
					board[x][y]= setting.get(d).getValue();
					//System.out.println(board[x][y]);
				}
				
				setting.remove(d);
			}
		}
		return board;
	}
	
	private static void printBoards(int tx, int ty, int bx, int by){
		System.out.println("\n");
		printOne(tx,ty,topboard);
		System.out.println("\n");
		printOne(bx,by,bottomboard);
		System.out.println("\n");
	}
	
	private static void printOne(int a, int b, String[][] board){
		System.out.printf("%21s%32s%32s\n\n","1","2","3");
		for (int x = 0; x < 3; x++){
			System.out.printf("  %S  ",(char)(x+97));
			
			for (int y = 0; y < 3; y++){
				if (x==a && y ==b || board[x][y].equals("----------------------")){
					int w = (30 - board[x][y].length())/2;
					String s="";
					for (int p = 0; p < w; p++){
						s = s+" ";
					}
					System.out.printf("[%30s]",board[x][y]+s);
				} else {
					System.out.printf("[%30s]","");
				}
			}
			System.out.println("");
		}
	}
	
	private static void start(){
		printBoards(3,3,3,3);
		games = 0;
		player1 = new CardPlayer("Player 1");
		player2 = new CardPlayer("Player 2");
		CardPlayer not;
		CardPlayer turn;
		int j = 3;
		HashSet<String> end = new HashSet<String>();
		for (int a = 0; a < 9; a++){
			end.add("----------------------");
		}
		
		while (!map.keySet().equals(end)){
			
			if (games%2 == 0){
				turn = player1;
				not = player2;
			} else {
				turn = player2;
				not = player1;
			}
			
			games ++;
			
			System.out.println("\nTurn - "+turn.getName());
			
			Scanner scan = new Scanner(System.in);
			System.out.println("\nEnter positions for top in 'A-1' format");
			
			//scan.useDelimiter("-");
			//System.out.println(scan.next().charAt(0));
			String st = scan.next();
			//used.add(st);
			int tx = st.charAt(0)-97;
			int ty = st.charAt(2)-49;
			//System.out.println(tx+""+ty);
			
			scan = new Scanner(System.in);
			System.out.println("Enter positions for bottom in 'A-1' format");
			
			st = scan.next();
			//used.add(st);
			int bx = st.charAt(0)-97;
			int by = st.charAt(2)-49;
			//System.out.println(tx+""+ty);
			
			printBoards(tx,ty,bx,by);
			
			if (map.keySet().equals(end)){
				
				if (player1.getScore()>player2.getScore()){
					System.out.print("\nPlayer 1");
				} else {
					System.out.println("\nPlayer 2");
				}
				System.out.println(" wins! :)\n");
				
			} else if (map.get(topboard[tx][ty]).equals(bottomboard[bx][by])){
				
				topboard[tx][ty] = "----------------------";
				bottomboard[bx][by] = "----------------------";
				map.put(topboard[tx][ty], bottomboard[bx][by]);
				turn.point(); 
				System.out.println("\nPoint! :D\n");	
				
			} else {
				
				System.out.println("\nMiss! :(\n");	
			}
			
			System.out.println("Game Status:\nPlayer 1 - "+player1.getScore()+"\nPlayer 2 - "+player2.getScore());
			
		}
		
	}
	
}
