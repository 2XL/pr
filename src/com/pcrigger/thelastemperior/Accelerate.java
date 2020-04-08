package com.pcrigger.thelastemperior;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Accelerate extends Activity implements SensorEventListener {
	SensorManager sm;
	float x, y, sensorX, sensorY;
	Bitmap ball;
	PcRiggerSurface ourSurfaceView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(new PcRiggerSurface(this));
		// set up sensor manager --> vid 126
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		// we jave a manager set up
		if (sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) // if its 0
																		// means
																		// not
																		// avaleble
		{
			Sensor s = sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);

		}
		ball = BitmapFactory.decodeResource(getResources(),
				R.drawable.greenball);
		x = y = sensorY = sensorX = 0;
		
		ourSurfaceView = new PcRiggerSurface(this);
		ourSurfaceView.resume();
		setContentView(ourSurfaceView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
	//	sm.unregisterListener(this); // reducir carga
		super.onPause();

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(16);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sensorX = event.values[0];
		sensorY = event.values[1];

	}

	public class PcRiggerSurface extends SurfaceView implements Runnable {

		SurfaceHolder ourHolder;
		// we need to create a thread before start it
		Thread ourThread = null;
		boolean isRunning = false;

		// surface view if litle bit different and complex
		public PcRiggerSurface(Context context) {
			// we wana pass a context
			// TODO Auto-generated constructor stub
			super(context); // set te context
			// service holder manage the service
			ourHolder = getHolder(); // tell us if the surface is valid
			// allow us to lock the canvas and other cant touch it lock/unlock

			// called
		}

		// vid 70 - establishing a better animation thread
		public void pause() {
			isRunning = false;
			while (true) {
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			ourThread = null;
		}

		public void resume() {
			isRunning = true;
			// everu time it reruns...
			ourThread = new Thread(this);
			ourThread.start(); // this thread will start when the constructor is
		}

		// threads op
		@Override
		public void run() {
			// TODO Auto-generated method stub
			// what the thread is gona do here
			// vid 69 what the thread will do
			while (isRunning) {

				// check if the surface is valid
				if (!ourHolder.getSurface().isValid()) // if it's not valid we
														// will
				{
					continue; // it's like a break but allow us to continue the
								// loop
				}

				// here is the MAGIC --> next line draw the bg color
				Canvas canvas = ourHolder.lockCanvas(); // lock the door // con
														// esto se borra todo i
														// se refreshea el fondo
				/*
				 * Random crazy = new Random();
				 * 
				 * canvas.drawRGB((crazy.nextInt(255)), crazy.nextInt(255),
				 * crazy.nextInt(255));
				 */
				canvas.drawRGB(25, 25, 50);
				 
				float centerX = canvas.getWidth() / 2;
				float centerY = canvas.getHeight() / 2;
				canvas.drawBitmap(ball, centerX + sensorX * 20, centerY
						+ sensorY * 20, null);
				ourHolder.unlockCanvasAndPost(canvas);
			}
		}

	}
}
