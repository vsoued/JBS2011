package edu.brandeis.androidcg;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose extends Activity{
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.choose);
	        
	        setVolumeControlStream(AudioManager.STREAM_MUSIC);
	        Music.create(this, R.raw.buhonero);
	        Music.start(this);
	        
	        ArrayList<Button> buttons = new ArrayList<Button>();
	        
	        buttons.add((Button) findViewById(R.id.animals));
	        buttons.add((Button) findViewById(R.id.colors));
	        buttons.add((Button) findViewById(R.id.numbers));

	        for (int i = 0; i < 3; i++){
	        	
	        	buttons.get(i).setOnClickListener(OnClickDoSomething(buttons.get(i),i));
	        }
	    }
	   
	    private View.OnClickListener OnClickDoSomething(final Button button, final int i)  {
		    return new View.OnClickListener() {
		        public void onClick(View v) {
		        	
		        	Intent intent = new Intent(Choose.this,CardGame.class);
		        	intent.putExtra("category",i);
		        	startActivity(intent);   
		        }
		    };
		}
}
