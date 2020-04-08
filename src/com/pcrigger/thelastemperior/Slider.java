package com.pcrigger.thelastemperior;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SlidingDrawer;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.SlidingDrawer.OnDrawerOpenListener;


public class Slider extends Activity implements OnClickListener, OnCheckedChangeListener, OnDrawerOpenListener {

	
	
	SlidingDrawer sd;
	
	
	
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		Button but1 = (Button) findViewById(R.id.handle1);
		Button but2 = (Button) findViewById(R.id.handle2);
		Button but3 = (Button) findViewById(R.id.handle3);
		Button but4 = (Button) findViewById(R.id.handle4);
		CheckBox checkbox = (CheckBox)findViewById(R.id.cbSlidable);
		checkbox.setOnCheckedChangeListener(this);
		sd =(SlidingDrawer)findViewById(R.id.slidingD);
		sd.setOnDrawerOpenListener(this);
		but1.setOnClickListener(this);
		but2.setOnClickListener(this);
		but3.setOnClickListener(this);
		but4.setOnClickListener(this);
	
	
	
	}
	
// vid 83
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.handle1:
			sd.open();
			break;
		case R.id.handle2:
			
			break;
		case R.id.handle3:
			sd.toggle();
			break;
		case R.id.handle4:
			sd.close();
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if(buttonView.isChecked()){
			sd.lock();
		}else{
			sd.unlock();
		}
	}
// vid 3

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		MediaPlayer mp = MediaPlayer.create(this, R.raw.intro);
		mp.start();
	}

}
