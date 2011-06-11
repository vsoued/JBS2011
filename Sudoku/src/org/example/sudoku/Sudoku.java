package org.example.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

//sudoku activity
public class Sudoku extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //set up listeners for buttons
        View continueButton = findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);
        View newButton = findViewById(R.id.new_button);
        newButton.setOnClickListener(this);
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);    
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
    	return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch (item.getItemId()){
    	case R.id.settings:
    		startActivity(new Intent(this, Prefs.class));
    		return true;
 
    	}
    	return false;
    }
   
    private static final String TAG = "Sudoku";
    
    private void openNewGameDialog(){
    	new AlertDialog.Builder(this)
    	.setTitle(R.string.new_game_title)
    	.setItems(R.array.difficulty,
    	new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialoginterface, int i) {
				// TODO Auto-generated method stub
				startGame(i);	
			}    		
    	})
    	.show();
    }
    private void startGame(int i){
    	Log.d(TAG, "clicked on"+i);
    	Intent intent = new Intent(this,Game.class);
    	intent.putExtra(Game.KEY_DIFFICULTY,i);
    	startActivity(intent);
    	
    	
    }
    
    public void onClick(View v){
    	switch (v.getId()) {
    	case R.id.about_button:
    		Intent i = new Intent(this, About.class);
    		startActivity(i);
    		break;
    	case R.id.new_button:
    		openNewGameDialog();
    		break;
    	case R.id.exit_button:
    		finish();
    		break;
    	}
    }
    
    
}