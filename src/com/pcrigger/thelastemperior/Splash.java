package com.pcrigger.thelastemperior;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.content.*;
 
public class Splash extends Activity {
	
	
	MediaPlayer ourSong;
	
	
	// vid 17 soundpool(1/2 secound plays) and mediaplayer (we are gone use this)/larger


	protected void onCreate(Bundle ILoveU) {
		// TODO Auto-generated method stub
		super.onCreate(ILoveU);
		setContentView(R.layout.splash);
		
			ourSong = MediaPlayer.create(Splash.this, R.raw.the_hall_of_fame);
			
			
			// vid 57 -> acces to our preferences
				// get info from our preferences
			SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
			boolean music = getPrefs.getBoolean("checkbox", true );	// en cas de que no retorna res set default es el segon parametre
			
			if(music == true){
			ourSong.start();
			}

		Thread timer = new Thread()
		{
			public void run()
			{
				try{
					sleep(1000); // 5000ms == 5s
				}catch( InterruptedException e)
				{
					// usefull for debuging
					e.printStackTrace();
				}finally
				{
					// after trying we can do something finally
					// chunky code
					Intent openStartingPoint = new Intent("com.pcrigger.thelastemperior.MENU");
					startActivity(openStartingPoint);
				}
			}
		
		};
		timer.start();
		
		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();// finish the splash activity it got ripped
	}

}
// source... override/implement mehtod















