package com.example.labandroid;

import config.Config;
import config.IServer;
import client.Client;
import client.Message;
import client.Person;
import beans.InfoBean;
import events.ButtonListener;
import events.MessageReader;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MessagingActivity extends Activity {

	Client goku = new Person("1234", "Goku");
	Client krilin = new Person("1235", "Krilin");
	private static final int UPDATEPERIOD = 2000; 
	private final String LOGCODE = "OneAndroidProject"; 
	private Handler updateMessagesHandler;
	private Runnable updateMessageTask;
	private InfoBean info;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);
        
    }
    
    public void MessagingActivityButton (View view){
        //forceError();
        //Do some logging to logCat
        Log.i(LOGCODE, "we are onCreate method!!" + this.getResources().getString(R.string.welcomeMessage));  
        
      //get information from calling activity
        Intent i = this.getIntent();
        info = (InfoBean)i.getSerializableExtra("myObjectInformation");     
        
        try {
    		Config config = Config.getConfig((View) view);
    		System.out.println(config.toString());
    			// initialitzation of proxy
    		IServer proxiedServer; 
    		
    		proxiedServer = config.getServer();
    				 
    		Message m = new Message();
    		m.setSource(goku);
    		String i1 = info.getPrefix();
    		m.setDest(krilin);
    		String ms=((TextView)this.findViewById(R.id.enterMessage)).getText().toString();
    		m.setMessage(ms);
    		
    		proxiedServer.setMessage(m);

    		} catch (Exception e) {
    		System.out.println(e.getMessage());
    		}
    		
        
        
        //Set up the button
        Button b = (Button)this.findViewById(R.id.sendMessage);
        OnClickListener clickListener = new ButtonListener(info.getPrefix(),
        		(TextView)this.findViewById(R.id.showMessages),
        		(TextView)this.findViewById(R.id.enterMessage),
        		(ScrollView) this.findViewById(R.id.SCROLLER_ID));        
        b.setOnClickListener(clickListener);     
        
        //Initialize a periodic task to updateMessages        
        updateMessagesHandler = new Handler();
        updateMessageTask = new MessageReader((TextView)this.findViewById(R.id.queryMsgInfo),updateMessagesHandler,UPDATEPERIOD);
        updateMessagesHandler.removeCallbacks(updateMessageTask);
        updateMessagesHandler.postDelayed(updateMessageTask, UPDATEPERIOD);         
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_messaging, menu);
        return true;
    }
}
