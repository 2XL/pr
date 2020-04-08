package com.pcrigger.thelastemperior;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// vid 95 - saving data with sharedPreferences
public class SharedPrefs extends Activity implements OnClickListener {

	EditText sharedData;
	TextView dataResults;
	public static String fileName = "MySharedString";
	SharedPreferences someData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setupVariables();
		someData = getSharedPreferences(fileName, 0);

	}

	private void setupVariables() {
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		sharedData = (EditText) findViewById(R.id.etSharedPrefs);
		dataResults = (TextView) findViewById(R.id.tvLoadSharedPrefs);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSave:
			String stringData = sharedData.getText().toString();
			// vid 96 acces to te editor
			SharedPreferences.Editor editor = someData.edit();
			editor.putString("sharedString", stringData);
			editor.commit();

			break;
			// vid 97 - load sharedpreferences
		case R.id.bLoad:
			someData = getSharedPreferences(fileName, 0);
			String dataReturn = someData.getString("sharedString", "Couldn't Load Data");
			// 2nd arg is default return fail reseaching
			dataResults.setText(dataReturn);
			
			
			
			
			break;

		}

	}

}
