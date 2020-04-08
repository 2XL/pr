package com.pcrigger.thelastemperior;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.renderscript.Font;
import android.view.View;

public class PcRigger extends View {

	// vid 63
	Bitmap gBall;

	// vid 65
	float changingY;

	// vid 66
	Typeface font;

	public PcRigger(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		// give specific info for start it up
		gBall = BitmapFactory.decodeResource(getResources(),
				R.drawable.greenball);
		changingY = 0;
		font = Typeface.createFromAsset(context.getAssets(), "G-Unit.ttf");
	}

	// vid 64

	// we will have a canvas

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);

		// get more costumizations 66
		Paint textPaint = new Paint();
		textPaint.setARGB(50, 254, 100, 50);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(50);
		// textPaint.setTypeface(Font.Style.);
		// add new font to our canvas or background
		canvas.drawText("pcrigger", canvas.getWidth() / 2, 200, textPaint);
		// alpha transparency

		// our activity will have a white background
		canvas.drawBitmap(gBall, (canvas.getWidth() / 2), changingY, null);
		if (changingY < canvas.getHeight())
			changingY += 10;
		else
			changingY = 0;

		// vid 65
		Rect middleRect = new Rect();
		middleRect.set(0, 400, canvas.getWidth(), 550);
		Paint ourBlue = new Paint();
		ourBlue.setColor(Color.BLUE);

		canvas.drawRect(middleRect, ourBlue);

		invalidate(); // restart it agian hey man do it again xD
	}

}
