package com.pcrigger.thelastemperior;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener {
	TextView sharedData;
	SharedPreferences someData;
	TextView dataResults;
	String fileName;
	FileOutputStream fos;
	String FILENAME = "InternalString";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setupVariables();
	}

	private void setupVariables() {
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		sharedData = (EditText) findViewById(R.id.etSharedPrefs);
		dataResults = (TextView) findViewById(R.id.tvLoadSharedPrefs);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);// open a file
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.bSave:
			String data = sharedData.getText().toString();

			// Saving data via file
			/*
			 * File f = new File(FILENAME);
			 * 
			 * try { fos = new FileOutputStream(f); // write some data
			 * fos.close(); } catch (FileNotFoundException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
			try {
				// output stream for save data
				fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
				fos.write(data.getBytes());
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// open a file
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.bLoad:
			/*
			 * // input stream for String collected = null; FileInputStream fis
			 * = null; try { fis = openFileInput(FILENAME); byte[] dataArray =
			 * new byte[fis.available()]; while (fis.read(dataArray)!= -1){
			 * collected = new String(dataArray); } } catch
			 * (FileNotFoundException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } catch (IOException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }finally{ try {
			 * fis.close(); } catch (IOException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); } }
			 */
			// realizar-lo en un thread - porque en serie puede tardar mucho
			new loadSomeStuff().execute(FILENAME);
			break;
		}
	}

	// 1st what is past in (tipo de input)
	// 2nd what we are operating with
	// 3rd what we are returning
	public class loadSomeStuff extends AsyncTask<String, Integer, String> {

		ProgressDialog dialog;
		
		
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
		//	super.onPreExecute();
			dialog = new ProgressDialog(InternalData.this);
			dialog.setProgress(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setMax(100);
			dialog.show();
		}
		
		// load data in a separate thread
		
		@Override
		protected String doInBackground(String... params) {

			// TODO Auto-generated method stub
			String collected = null;
			FileInputStream fis = null;
			
			for (int i = 0; i<20; i++){
				publishProgress(5);
				try {
					Thread.sleep(88);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			dialog.dismiss();
			
			try {
				fis = openFileInput(FILENAME);
				byte[] dataArray = new byte[fis.available()];
				while (fis.read(dataArray) != -1) {
					collected = new String(dataArray);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					return collected; // return the collected string
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return null;
		}



		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
		//	super.onProgressUpdate(values);
			dialog.incrementProgressBy(values[0]);
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
		//	super.onPostExecute(result);
			dataResults.setText(result);
		}
		

	}

}
