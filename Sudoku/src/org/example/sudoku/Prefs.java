package org.example.sudoku;

import android.os.Bundle;
import android.preference.PreferenceActivity;

//prefs activity
public class Prefs extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
	}
	
}
