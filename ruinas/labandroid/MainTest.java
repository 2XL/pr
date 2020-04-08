package com.example.labandroid;

import java.io.InputStream;
import java.util.List;

import client.Client;
import client.Message;
import client.Person;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import config.Config;
import config.IServer;

public class MainTest extends Activity {
	Button b1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_test);

		//b1 = (Button) findViewById(R.id.main);
		//b1.setOnClickListener(myhandler);
	}

	/*View.OnClickListener myhandler = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try {
				InputStream inputStream = v.getResources().openRawResource(
						R.raw.appproperties);

				// Joc de proves crear 2 clients:
				// Goku Krilin
				Client goku = new Person("1234", "Goku");
				Client krilin = new Person("2345", "Krilin");
				Config config = Config.getConfig();

				// initialitzation of proxy
				IServer proxiedServer = config.getServer();

				// Add Goku and Krilin to the server
				proxiedServer.addClient(goku);
				proxiedServer.addClient(krilin);

				// use proxy as if the real server was local
				Message m = new Message();
				m.setSource(krilin);
				m.setDest(goku);
				m.setMessage("Ieeeep!!! Ha arribat el SonGokuu!!!!");

				proxiedServer.setMessage(m);

				// receive the message
				List<Message> messages = proxiedServer
						.getLastMessages((Person) goku);
				for (Message m1 : messages) {
					System.out.println("Send by: " + m1.getSource().getName());
					System.out
							.println("Received by: " + m1.getDest().getName());
					System.out.println(m1.getMessage());
					System.out.println("\n\n");
				}

				m.setMessage("Ieeeeep!!!! SonGoku que vas a buscar mongetes magiques?");
				proxiedServer.setMessage(m);

				// receive the message
				messages = proxiedServer.getLastMessages((Person) goku);
				for (Message m1 : messages) {
					System.out.println("Send by: " + m1.getSource().getName());
					System.out
							.println("Received by: " + m1.getDest().getName());
					System.out.println(m1.getMessage());
				}

			} catch (Exception e) {
				System.out.println("Error in proxy:" + e.getMessage());
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.layout.activity_main_test, menu);
		return true;
	} */
}
