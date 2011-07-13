package edu.brandeis.aq;

public class Guess {
	
	private String q;
	private int yeschild;
	private int nochild;
	private boolean leaf;
	
	public Guess(String q, int yeschild, int nochild){
		this.q = q;
		this.leaf = false;
		this.yeschild = yeschild;
		this.nochild=nochild;
	}
	
	public Guess(String q){
		this.q = q;
		leaf = true;
	}
	
	public boolean isaleaf(){
		return leaf;
	}
	
	public int getyes(){
		return yeschild;
	}
	
	public int getno(){
		return nochild;
	}
	
	public String toString(){
		return q;
	}
	
	public String getQ(){
		return q;
	}
	
	
}
