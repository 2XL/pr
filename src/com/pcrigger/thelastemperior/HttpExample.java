package com.pcrigger.thelastemperior;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HttpExample extends Activity {
	TextView httpStuff;
	HttpClient client;
	JSONObject json;
	final static String URL = "http://api.twitter.com/1/statuses/user_timeline.json?screen_name=";

	// JSON java scrit object location
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpex);
		httpStuff = (TextView) findViewById(R.id.tvHttp);
		/*
		 * GetMethodEx test = new GetMethodEx(); String returned; try { returned
		 * = test.getInternetData(); httpStuff.setText(returned); } catch
		 * (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		// vid 150
		client = new DefaultHttpClient();
		new Read().execute("text");
	}

	public JSONObject lastTweet(String username)
			throws ClientProtocolException, IOException, JSONException {
		StringBuilder url = new StringBuilder(URL);
		url.append(username);
		// build a string from of our json code
		HttpGet get = new HttpGet(url.toString());
		HttpResponse r = client.execute(get);
		int status = r.getStatusLine().getStatusCode();
		if (status == 200) {
			HttpEntity e = r.getEntity();
			String data = EntityUtils.toString(e);
			JSONArray timeline = new JSONArray(data);
			JSONObject last = timeline.getJSONObject(0); // return a json object
															// from the array we
															// set up before...

			return last;
		} else {
			Toast.makeText(HttpExample.this, "error", Toast.LENGTH_LONG);
			return null;
		}

	}

	public class Read extends AsyncTask<String, Integer, String> {
		public Read() {
			// TODO Auto-generated constructor stub
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			try {
				json = lastTweet("mybringback");
				return json.getString(params[0]);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
		//	super.onPostExecute(result);
			httpStuff.setText(result);
		}

	}
}
