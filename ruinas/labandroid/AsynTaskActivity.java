package com.example.labandroid;

import android.os.AsyncTask;

public class AsynTaskActivity {
	public class UpdateProgress extends AsyncTask<Void, Integer, Void>{
		int progress;
		
		protected void onPostExecute (Void result){
			
		}
		
		protected void onPreExecute(){
			progress = 0;
		}
		
		protected void onProgressUpdate (Integer...values){
			
		}
		
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
