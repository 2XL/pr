package com.pcrigger.thelastemperior;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener{

	
	
 
	ImageButton ib;
	Button b;
	ImageView iv;
	final static int cameraData = 0;
	Bitmap bmp;
	
	Intent i;
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initialize();
		// vid 42 
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		// decode input stream 
		bmp = BitmapFactory.decodeStream(is);	// factori patron xD
		
		

	}


	private void initialize() {
		// TODO Auto-generated method stub
		iv = (ImageView) findViewById(R.id.ivReturnPic);
		ib = (ImageButton) findViewById (R.id.ibTakePic);
		b = ( Button) findViewById(R.id.bSetWP);
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bSetWP:
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// settng it as a wall paper it needs a permission
			}
			break;
		case R.id.ibTakePic:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);	// try a pic and get the data back
			startActivityForResult(i, cameraData); // camara data is data returned
			// vid 40 getting the results
			
			break;
		}
		
		
		
	}


	@Override	// 
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		// passing data between two activities
		if(resultCode == RESULT_OK )	// if we got any info after we start it, check if op succeded
		{
			// get information 
			Bundle extras =  data.getExtras();	// localizar los datos de la actividad anterior(captura imagen)
			bmp = (Bitmap) extras.get("data");	// data es un hashing dentro del objeto que nos retorna datos
			// after setting a bitmap
			// set it on imageview
			iv.setImageBitmap(bmp);
			
		
		
		}
			
			
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}