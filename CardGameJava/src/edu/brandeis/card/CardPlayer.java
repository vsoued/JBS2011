package edu.brandeis.card;

public class CardPlayer {
	private String name;
	private int score;
	
	public CardPlayer(String name){
		this.name = name;
		score = 0;
	}
	
	public int getScore(){return score;}
	public String getName(){return name;}
	public void point(){score++;}
}
