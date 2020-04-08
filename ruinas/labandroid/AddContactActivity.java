package com.example.labandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import client.Client;
import client.Person;
import config.Config;
import config.IServer;
import db.clientDB;

public class AddContactActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		
		
	}

	public void addContactButton(View view) {
		EditText contactName = (EditText) findViewById(R.id.contactName);
		EditText contactPhone = (EditText) findViewById(R.id.contactPhone);

		String name = contactName.getText().toString();
		String phone = contactPhone.getText().toString();

		Client client = new Person(phone, name);
		
		Toast.makeText(this, name +" " + phone, Toast.LENGTH_LONG).show();

		clientDB cDB = new clientDB();
		
		cDB.addClientDB(client);
		
		

		try {
		Config config = Config.getConfig(view);
		System.out.println(config.toString());
			// initialitzation of proxy
		IServer proxiedServer; 
				
				proxiedServer = config.getServer();

	
		proxiedServer.addClient(client);

		} catch (Exception e) {
		System.out.println(e.getMessage());
		}

		Intent intent = new Intent();
		intent.setClass(this, ChooseAction.class);

		intent.putExtra("contactName", contactName.getText().toString());
		intent.putExtra("contactPhone", contactPhone.getText().toString());

		
		startActivity(intent);

	}

}
