package com.pcrigger.thelastemperior;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener{

	
	Button chkCmd;
	ToggleButton passTog;
	EditText input;
	TextView display;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text );
		
		// vid 33
		baconInTheFridge();
		

		// vid 26
		
		// vid 34 implementing methods LOL
		passTog.setOnClickListener(TextPlay.this);
		
		chkCmd.setOnClickListener(TextPlay.this);
		
		
		
		
		
		
		
		
		
	}




	private void baconInTheFridge() {
		// TODO Auto-generated method stub
		// vid 25
		// set up some references - each time make activity
		chkCmd = (Button)findViewById(R.id.bResults);
		passTog = (ToggleButton)findViewById(R.id.tbPassword);
		input = (EditText) findViewById(R.id.etCommand);
		display = (TextView) findViewById(R.id.tvResult);
	}




	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		// vid 34 --> switch for knowing the implementation which botton is pressed
		switch(view.getId()){
		case R.id.bResults:
			// TODO Auto-generated method stub
			String check = input.getText().toString();


				if(check.contentEquals("left"))
						display.setGravity(Gravity.LEFT);
				else 
					if(check.contentEquals("right"))
						display.setGravity(Gravity.RIGHT);
				else 
					if(check.contentEquals("center"))
						display.setGravity(Gravity.CENTER);
				else
		//vid 30		-->	seting color		
					if(check.contentEquals("blue"))
						display.setTextColor(Color.BLUE);
				else 
		//vid 31	--> where is the fridge 
					if(check.contentEquals("WTF"))
						{
						Random crazy = new Random();
						display.setText("WTF!!");
						display.setTextSize(crazy.nextInt(75));
						display.setTextColor(Color.rgb(crazy.nextInt(255), crazy.nextInt(255), crazy.nextInt(255)));
						switch(crazy.nextInt(3)){
						case 0:
							
							
							display.setGravity(Gravity.RIGHT);
							break;
						case 1:
							
							
							
							break;
						case 2:
							display.setGravity(Gravity.CENTER);
							
							
							break;
						default:
							
							display.setGravity(Gravity.LEFT);
							
							break;
						}
						}
						
				else {
						display.setText("invalid");
						display.setGravity(Gravity.CENTER);
						display.setTextColor(Color.WHITE);
				}
		
			break;
		case R.id.tbPassword:
			// TODO Auto-generated method stub,
			// final it never gona change
			if(passTog.isChecked()){
				input.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}else{
				input.setInputType(InputType.TYPE_CLASS_TEXT);
				
			}
				
			break;
		}
		// no transfer the methods
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
