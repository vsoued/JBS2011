package edu.brandeis.animal;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public static void main(String[] args){
		
		//array list of nodes
		ArrayList<Guess> nodes = new ArrayList<Guess>();
		
		//add first zebra leaf
		nodes.add(new Guess("Is it a zebra?"));
		
		//set up scanner
		Scanner scan = new Scanner(System.in);
	
		boolean loop = true;
		
		//index
		int x = 0;
		
		while (loop){
			
			//System.out.println(nodes);
			
			scan = new Scanner(System.in);
			//print question at nodes[x]
			System.out.println(nodes.get(x).getQ());
			String reply = scan.next();
			
			//if yes
			if (reply.equals("yes")){
				
				//if leaf
				if(nodes.get(x).isaleaf()){
					
					System.out.println("I win! Play again?");
					scan = new Scanner(System.in);
					reply = scan.next();
					
					if (reply.equals("no")){
						//stop game
						loop = false;
					}else{
						//start at x = 0;
						x=0;
					}
				
				//if not a leaf
				} else {
					//get yes
					x= nodes.get(x).getyes();
				}
			
			//if no
			} else if (reply.equals("no")){
				
				//if leaf
				if(nodes.get(x).isaleaf()){
					
					scan = new Scanner(System.in);
					System.out.println("You win! What animal was it?");
					//new animal guess
					reply = "Is it a "+scan.nextLine()+"?";
					//add new leaf
					nodes.add(x+1,new Guess(reply));
					//System.out.println("adding "+reply+" at ["+(x+1)+"]");
					
					//move old leaf
					nodes.add(x+2, new Guess(nodes.get(x).getQ()));
					//System.out.println("adding "+nodes.get(x).getQ()+" at ["+(x+2)+"]");
					
					scan = new Scanner(System.in);
					System.out.println("Type question");
					//new question
					reply = scan.nextLine();
					//add question
					nodes.set(x, new Guess(reply,x+1,x+2));
					//System.out.println("setting "+reply+" at ["+x+"] yes:"+(x+1)+" no:"+(x+2));
					
					//play again?
					scan = new Scanner(System.in);
					System.out.println("Thanks! Play again?");
					reply = scan.next();
					
					if (reply.equals("no")){
						loop = false;
					} else {
						x = 0;
					}
				
				} else {
					//get no
					x= nodes.get(x).getno();
				}
			}
		}	
	}
}
