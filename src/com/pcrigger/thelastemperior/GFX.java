package com.pcrigger.thelastemperior;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class GFX extends Activity {

	
	PcRigger ourView;
	WakeLock wL;	// wake lock
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// vid 78 --> WakeLook to keep your app from sleeping (save bat. power)
		
		PowerManager pM = (PowerManager)getSystemService(Context.POWER_SERVICE);	// omg what have i done
		wL = pM.newWakeLock(PowerManager.FULL_WAKE_LOCK, "batsaving");
		
		super.onCreate(savedInstanceState);
		//
		wL.acquire();
		ourView = new PcRigger(this);	// this is context of this class
		setContentView(ourView);
		
	}

 
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wL.release();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
