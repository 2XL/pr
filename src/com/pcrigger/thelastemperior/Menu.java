package com.pcrigger.thelastemperior;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{

	// varible global 
	String classes[] = 
		{	"StartingPoint",
			"TextPlay",
			"Email",
			"Camera",
			"Data",
			"GFX",
			"GFXSurface",
			"SoundStuff",
			"Slider",
			"Tabs",
			"SimpleBrowser",
			"Flipper",
			"SharedPrefs",
			"InternalData",
			"ExternalData",
			"SQLiteExample",
			"SQLView",
			"Accelerate",
			"HttpExample",
			"WeatherXMLParsing",
			"GLExample"
		//	"SendMsg",
		};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// vid 61 --> make request full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// set a pipe full screen
		getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN,	// flag
				WindowManager.LayoutParams.FLAG_FULLSCREEN	// mask
				);
		
		
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes ));
		
		// vid 51
		
		
	}

	
	@Override	// esto un action listener en caso de recibir un click 
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		super.onListItemClick(l, v, position, id);
		String cheese = classes[position];
		Class ourClass;
		try {
			ourClass = Class.forName("com.pcrigger.thelastemperior."+cheese);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// string for the path starting point
		
		
		
		
		
	}

	// vid 51
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		
		// lol
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}


	// vid 52 --> working with items and menu
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		// return super.onOptionsItemSelected(item);
		switch(item.getItemId()){
		case R.id.aboutUs:// reference to the action name in the manifest
			Intent i = new Intent("com.pcrigger.thelastemperior.ABOUT");
			startActivity(i);
			break;
		case R.id.preferences:
			Intent p = new Intent("com.pcrigger.thelastemperior.PREFS");
			startActivity(p);
			break;
			
		case R.id.exit:
			finish();
			break;
			
		case R.id.addUser:
			break;
		//case R.i
		}
		
		return true;
	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
