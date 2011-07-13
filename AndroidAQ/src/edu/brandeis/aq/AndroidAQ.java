package edu.brandeis.aq;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AndroidAQ extends Activity implements  android.view.View.OnClickListener{
    /** Called when the activity is first created. */
	 
	 private EditText textbox;
	 private TextView text;
	 private ArrayList<Guess> nodes;
	 //will be the index of the current question in the game
	 private int x=0;
	 private String reply;
	 private Editable edit;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //get views
        textbox = (EditText) findViewById(R.id.editText1);
        text = (TextView) findViewById(R.id.text1);
        
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(this);
        
        //initialize list and add first default node
        nodes = new ArrayList<Guess>();
        nodes.add(new Guess("Is it a zebra?"));
        
        //set starting question
        setQ();
    }
    
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
	     
	      case R.id.button1 :
	    	  next();
	    	  break;
		}	
	}
	
	//gets the users reply and then decides the next step
	public void next(){
		
		getReply();
		clear();
		
		if (yes()){		
			if (playAgain()){			
				play();
			}else if(isLeaf()){				
				yesLeaf();			
			}else{				
				yesParent();
			}		
		}else if (no()){			
			if (playAgain()){				
				stop();			
			}else if(isLeaf()){					
				noLeaf();			
			}else{				
				noParent();
			}		
		}else{			
			if (replyIsAnimal()){				
				learnAnimal();
			}else if (replyIsQuestion()){
				learnQuestion();
			}
		}
	}
	
	
	//sets the question of the current x
	private void setQ(){
		text.setText(nodes.get(x).getQ());
	}
	
	private void getReply(){
		edit = textbox.getText();
		reply = edit.toString();
	}
	
	private void clear(){
		textbox.setText("");
	}
	
	private boolean yes() {
		return (reply.equals("yes"));
	}
	
	private boolean no() {
		return (reply.equals("no"));
	}	

	private boolean isLeaf(){
		return nodes.get(x).isaleaf();
	}
	
	private void yesLeaf(){	
		text.setText("I win! Play again?");
	}
	
	private void noLeaf(){
		text.setText("You win! What animal was it?");
	}
	
	//sets x to be the index of the yeschild of x
	private void yesParent(){
		x= nodes.get(x).getyes();
		setQ();
	}
	
	//sets x to be the index of the nochild of x, and sets it
	private void noParent(){
		x= nodes.get(x).getno();
		setQ();
	}

	private boolean playAgain() {
		return (text.getText().equals("I win! Play again?")||text.getText().equals("Thanks! Play again?"));
	}
	
	//sets x to 0 (restart) and sets first question
	private void play() {
		x = 0;
		setQ();
	}
	
	private void stop(){
		text.setText("Goodbye");
		textbox.setText("Goodbye");
	}
	
	private boolean replyIsAnimal() {
		return (text.getText().equals("You win! What animal was it?"));
	}
	
	private void learnAnimal(){
		reply = "Is it a "+reply+"?";
		
		//adds the new animal guess
		nodes.add(x+1,new Guess(reply));
		
		//move old question to be after new guess
		nodes.add(x+2, new Guess(nodes.get(x).getQ()));
		
		text.setText("Please type a question that is yes for that animal");
	}
	
	private boolean replyIsQuestion() {
		return (text.getText().equals("Please type a question that is yes for that animal"));
	}

	private void learnQuestion(){
		//sets the new question where the old question was
		nodes.set(x, new Guess(reply,x+1,x+2));
		
		text.setText("Thanks! Play again?");
	}
	
}