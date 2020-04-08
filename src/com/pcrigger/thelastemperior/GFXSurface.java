package com.pcrigger.thelastemperior;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GFXSurface extends Activity implements OnTouchListener {

	// vid 67
	// no hacer cargar demasiado un proceso i separarlo endistintos threads

	PcRiggerSurface ourSurfaceView;
	float x, y;
	float sX, sY;
	float fX, fY;
	float dX, dY;
	float aniX, aniY;
	float finX, finY;
	float scaledX, scaledY;
	Random crazy;
	Bitmap ball;
	Bitmap plus;
	static int FrameRateToAchieve = 60;

	// extend the serface view as view

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ourSurfaceView = new PcRiggerSurface(this);
		// vid 71
		ourSurfaceView.setOnTouchListener(this);
		x = 0;
		y = 0;
		sX = 0;
		sY = 0;
		fX = 0;
		fY = 0;
		dX = dY = aniX = aniY = scaledX = scaledY = 0;
		ball = BitmapFactory.decodeResource(getResources(),
				R.drawable.greenball);
		plus = BitmapFactory.decodeResource(getResources(), R.drawable.plus);

		// set the content view
		setContentView(ourSurfaceView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSurfaceView.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ourSurfaceView.resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub

	try {
			Thread.sleep(FrameRateToAchieve);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		x = event.getX();
		y = event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN: // cuando presionamos
			sX = event.getX();
			sY = event.getY();
			dX = dY = aniX = aniY = scaledX = scaledY = fX = fY = 0;
			break;
		case MotionEvent.ACTION_UP: // cuando lo soltamos
			fX = event.getX();
			fY = event.getY();
			dX = fX - sX;
			dY = fY - sY;
			scaledX = dX / 30;
			scaledY = dY / 30;
			x = y = 0;
			break;
		}

		return true; // true... sigue i sigue / false ... no sigue ni i se queda
	}

	// OTHER CLASS PASTED BECAUSE WE WANA ACCESS X & Y
	// vid 72
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
				crazy = new Random();

				canvas.drawRGB((crazy.nextInt(255)), crazy.nextInt(255),
						crazy.nextInt(255));

				// start painting it
				// vid 72
				if (x != 0 && y != 0) // posicion pelota
				{
					canvas.drawBitmap(ball, x - (ball.getWidth() / 2), y
							- (ball.getHeight() - 2), null);

				}
				if (sX != 0 && sY != 0) // posicion del primero
				{
					canvas.drawBitmap(plus, sX - (plus.getWidth() / 2), sY
							- (plus.getHeight() - 2), null);

				}
				if (fX != 0 && fY != 0) // posicion donde pelota ahora
				{
					// shotting ball here
					// 1st line vid 75

					canvas.drawBitmap(ball, fX - (ball.getWidth() / 2) - aniX,
							fY - (ball.getHeight() - 2) - aniY, null);
					canvas.drawBitmap(plus, fX - (plus.getWidth() / 2), fY
							- (plus.getHeight() - 2), null);
				}
				// vid 75 -- lol game programming lol xD concept
				aniX += scaledX;
				aniY += scaledY;

				// vid 77 -> Sleeping to archive desired FPS
				ourHolder.unlockCanvasAndPost(canvas);

			}
		}

	}
}
