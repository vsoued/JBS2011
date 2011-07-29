package edu.brandeis.androidcg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CardGame extends Activity{
    /** Called when the activity is first created. */
	
	static ArrayList<String> topstrings;
	static ArrayList<String> botstrings;
	static HashMap<String,String> map;
	static ArrayList<Button> topbuttons;
	static ArrayList<Button> botbuttons; 
	static String top;
	static String bot;
	static int turn;
	static int score1;
	static int score2;
	static Button currentop;
	static Button currentbot;
	static TextView label;
	static TextView spanishlabel;
	static TextView englishlabel;
	
	
	String[] cats = {"animals","colors","numbers"};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        int c = getIntent().getIntExtra("category", 0);
        Log.d("tag",cats[c]);
        
		setGame(cats[c]);
		bot = " ";
		top = " ";
		turn = 0;
		score1 = 0;
		score2 = 0;
		
		label = (TextView) findViewById(R.id.status);
		spanishlabel = (TextView) findViewById(R.id.textView2);
		englishlabel = (TextView) findViewById(R.id.textView3);
		
		Button gobutton = (Button) findViewById(R.id.gobutton); 
		gobutton.setOnClickListener(OnClickGo(gobutton));
 		
		topbuttons = new ArrayList<Button>();
        
		topbuttons.add((Button) findViewById(R.id.button0));
		topbuttons.add((Button) findViewById(R.id.button1));
		topbuttons.add((Button) findViewById(R.id.button2));
		topbuttons.add((Button) findViewById(R.id.button3));
		topbuttons.add((Button) findViewById(R.id.button4));
		topbuttons.add((Button) findViewById(R.id.button5));
		topbuttons.add((Button) findViewById(R.id.button6));
		topbuttons.add((Button) findViewById(R.id.button7));
		topbuttons.add((Button) findViewById(R.id.button8));
        
		botbuttons = new ArrayList<Button>();
		
        botbuttons.add((Button) findViewById(R.id.button9));
        botbuttons.add((Button) findViewById(R.id.button10));
        botbuttons.add((Button) findViewById(R.id.button11));
        botbuttons.add((Button) findViewById(R.id.button12));
        botbuttons.add((Button) findViewById(R.id.button13));
        botbuttons.add((Button) findViewById(R.id.button14));
        botbuttons.add((Button) findViewById(R.id.button15));
        botbuttons.add((Button) findViewById(R.id.button16));
        botbuttons.add((Button) findViewById(R.id.button17));

	    for (int i = 0; i < 9; i++){
	    	
	    	topbuttons.get(i).setOnClickListener(OnClickTop(topbuttons.get(i),i));
	    	botbuttons.get(i).setOnClickListener(OnClickBot(botbuttons.get(i),i));
	    }
	    
    }
    
    private View.OnClickListener OnClickGo(final Button button)  {
	    return new View.OnClickListener() {
	        public void onClick(View v) {
	        	
	        	if (turn == 3){
        	     	
	        		onDestroy();
            		startActivity(new Intent(CardGame.this,Choose.class));
            		
            	} else if(!allDown(topbuttons) && !allDown(botbuttons)){
		        	if (bot.equals(map.get(top))){
	        			
		        		Music.create(CardGame.this, R.raw.clap);
		        		
	        			currentop.setVisibility(View.INVISIBLE);
	        			currentbot.setVisibility(View.INVISIBLE);
	        			botstrings.set(botstrings.indexOf(bot)," ");
	        			topstrings.set(topstrings.indexOf(top)," ");
	        			
	        			if (turn == 0){
	        				score1++;
	        			}else if (turn ==1){
	        				score2++;
	        			}
	        			
	        		} else {

		        		Music.create(CardGame.this, R.raw.boo2);
		     	        
	        		}
		        	
		        	Music.start(CardGame.this);
		        	
		        	bot = " ";
	        		top = " ";
	        		
	        		turnAllDown();
	        		
	        		if(checkGameOver()){
	        			
	        			Music.create(CardGame.this, R.raw.cheer);
		     	        Music.start(CardGame.this);
	            		turn = 3;
	            		button.setText("New Game");
	            		
	            		if(score1>score2){
	            			
	            			label.setText("Player 1 wins!");
	            		} else if(score2>score1){
	            			
	            			label.setText("Player 2 wins!");
	            		} else {
	            			
	            			label.setText("It's a tie!");
	            		}
	            		
	            		label.setTextSize(50f);
	            		spanishlabel.setVisibility(View.INVISIBLE);
	            		englishlabel.setVisibility(View.INVISIBLE);
	            		
	            	} else if (turn == 0){
	            		
	            		label.setText("Player 2's Turn\nScore: Player 1 - "+score1+" | Player 2 - "+score2);
	            		turn = 1;
	            	} else if (turn == 1){
	            		
	            		label.setText("Player 1's Turn\nScore: Player 1 - "+score1+" | Player 2 - "+score2);
	            		turn = 0;
	            	}
	        	}
	        }
	    };
	}
    
	private View.OnClickListener OnClickTop(final Button button,final int i)  {
	    return new View.OnClickListener() {
	        public void onClick(View v) {
	        	
	        	if (allDown(topbuttons)){
	        		
	        		button.setText(topstrings.get(i));
	        		top = topstrings.get(i);
	        		currentop = topbuttons.get(i);
	        	}
	        }
	    };
	}
	
	private View.OnClickListener OnClickBot(final Button button,final int i)  {
	    return new View.OnClickListener() {
	        public void onClick(View v) {
	        	
	        	if (allDown(botbuttons)){
	        		
	        		button.setText(botstrings.get(i));
	        		bot = botstrings.get(i);
	        		currentbot = botbuttons.get(i);
	        	}
	        }
	    };
	}
	
	 protected void onDestroy()
     {
     	super.onDestroy();
     	Music.stop(this);
     }
	
	private static void setGame(String cat){
		
		String[] data;
		
		if (cat.equals("colors")){
			data = Data.colors;	
		} else if (cat.equals("animals")){
			data = Data.animals;
		} else if (cat.equals("numbers")){
			data = Data.numbers;
		} else {
			data = Data.colors;	
		}
		
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		
		for (int i = 0; i< data.length; i+=2){
			
			String key = data[i];
			String value = data[i+1];
			pairs.add(new Pair(key,value));
		}	

		Random rand = new Random();
		map = new HashMap<String,String>();
		topstrings = new ArrayList<String>();
		botstrings = new ArrayList<String>(); 
		
		for (int x = 0; x < 9; x++){ 
			
			int d = rand.nextInt(pairs.size());
			topstrings.add(pairs.get(d).getKey());
			botstrings.add(pairs.get(d).getValue());
			map.put(pairs.get(d).getKey(), pairs.get(d).getValue());
			pairs.remove(d);
		}
		
		Collections.shuffle(topstrings);
		Collections.shuffle(botstrings);

	}
	
	private boolean checkGameOver(){
		
		for (String b : topstrings){
			
			if (!b.equals(" ")){
				return false;
			}
		}
		for (String b : botstrings){
			
			if (!b.equals(" ")){
				return false;
			}
		}
		return true;
	}
	
	private boolean allDown(ArrayList<Button> buttons){
		
		for (Button b : buttons){
			
			if (!b.getText().toString().equals(" ")){
				return false;
			}
		}
		return true;
	}
	
	private void turnAllDown(){
		
		for (Button b : topbuttons){
			
			if (!b.getText().toString().equals(" ")){
				b.setText(" ");
			}
		}
		
		for (Button b : botbuttons){
			
			if (!b.getText().toString().equals(" ")){
				b.setText(" ");
			}
		}
	}
}