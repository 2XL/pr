package com.pcrigger.thelastemperior;

import android.app.Activity;
import android.content.DialogInterface;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class SoundStuff extends Activity implements OnClickListener, OnLongClickListener  {

	SoundPool sp;
	MediaPlayer mp;
	int explosion = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		View v = new View(this);
		v.setOnClickListener(this);
		v.setOnLongClickListener(this);
		setContentView(v);
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0); // loaded into memory
		// handle how many// stream at// time
		// returns: non-zero streamID if successful, zero if failed
		explosion = sp.load(this, R.raw.intro, 1);	// short clips quickly
		mp = MediaPlayer.create(this, R.raw.lp_intro); // huge mdia player stream
		// click and hold a sec then it will call hold long 

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (explosion != 0) //
			sp.play(explosion, 1, 1, 0, 0, 1);
		
	}
// vid 80 -> using the onlongClick method
	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		mp.start();
		return false;
	}
}
