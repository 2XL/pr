package com.pcrigger.thelastemperior;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener{

	// declarar las variables que usaremos (DECLARAR)
	Button start, startFor;
	EditText sendET;
	TextView gotAnswer;
	
	@Override	// rutina para incializar las referencias
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		initialize();
		
		
		
		
	}

	private void initialize() {
		// TODO Auto-generated method stub
		start = (Button) findViewById(R.id.bSA);
		startFor = (Button) findViewById(R.id.bSAFR);
		sendET = (EditText) findViewById(R.id.etSend);
		gotAnswer = (TextView) findViewById(R.id.tvGot);
		start.setOnClickListener(this);
		startFor.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {

		switch(v.getId()){
		case R.id.bSA:
			String bread = sendET.getText().toString();
			Bundle basket = new Bundle();
			basket.putString("key", bread);	// key file name it will be refered to
			// hold the data of this class and 
			Intent a = new Intent(Data.this, OpenedClass.class);	// reference classname and it will path it
			a.putExtras(basket);	// facilitar datos
			startActivity(a);	// inicializar el intento
			break;
		case R.id.bSAFR:
			Intent i = new Intent (Data.this, OpenedClass.class);
			startActivityForResult(i,0);	// 0 is some default
			
			break;
			
		
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			Bundle basket = data.getExtras();
			String s = basket.getString("answer");
			gotAnswer.setText(s);
			
		}
	}
	
	
	
	
	

}
