package com.pcrigger.thelastemperior;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener{
	
	TextView question, test;
	Button returnData;
	RadioGroup selectionList;
	String gotBread;
	String setData;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initialize();
		// vid 48 
		// receive bread string from an activity and thread it
		// reference to last class intent
		
		
		// vid 58
		SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String et = getData.getString("name", "Xiang is...");
		String values = getData.getString("list", "4" );
		
		if(values.contentEquals("1"))
		{
			question.setText(et);
		}
		if(values.contentEquals("2"))
		{
			
		}
		
	//	Bundle gotBasket = getIntent().getExtras();
		// decrypt te bundle
	//	gotBread = gotBasket.getString("key"); // facilitar la clave de acceso
	//	question.setText(gotBread);	// set a text view content
		
		// vid 50 comenta las tres lineas anteriores porque hay dos bundles puede provocar dependencia
		
		
		
	}


	private void initialize() {
		// TODO Auto-generated method stub
		question = (TextView)findViewById(R.id.tvQuestion);
		test = (TextView)findViewById(R.id.tvTest);
		returnData = (Button) findViewById(R.id.bReturn);
		returnData.setOnClickListener(this);
		// falta incializar la bateria de selcción
		selectionList = (RadioGroup) findViewById(R.id.rdAnswers);
		selectionList.setOnCheckedChangeListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// vid 50 - person can carry 2 activities xD
		Intent person = new Intent();
		Bundle backpack = new Bundle();
		backpack.putString("answer", setData);
		person.putExtras(backpack);
		// started for the result we need to get the result back
		setResult(RESULT_OK); // tell the program that everything is ok
		finish();	// finish the activity...
		
	}


	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		// 2n arg retorna l'id
		switch(checkedId){
		case R.id.rCrazy:
			setData = "Probably right!";
			break;
		case R.id.rSexy:
			setData = "Definitly right!";
			break;
		case R.id.rBoth:
			setData = "Spot on!";
			break;
		default:
			
			break;
		}
		test.setText(setData);
	}
	
	

}
