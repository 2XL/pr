package com.example.labandroid;
import db.clientDB;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import events.ListViewEvent;

public class ChooseAction extends Activity {

	String[] listItems = {"Albert", "Jordi","tapGroup", "all"};	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_action);
        
        clientDB cDB = new clientDB();
        
        //Initialize the text view with its adapter
        ListView lv = (ListView)this.findViewById(R.id.listView1);        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_expandable_list_item_1, android.R.id.text1,cDB.getList()); /*listItems);*/        
        lv.setAdapter(adapter);               
        lv.setOnItemClickListener(new ListViewEvent());          
        
        Log.i("ChooseAction", "Activity initialized correctly!!");
        
        //Agafem la informació del afegir contacte
        /*Bundle bundle = getIntent().getExtras();
        String contactName = bundle.getString("contactName");
        String contactPhone = bundle.getString("contactPhone");*/
        
        //Afegir a la llista d'Strings listItems
    
        
    }
    
    public void onAddClick(View view){
    	Intent intent = new Intent();
		intent.setClass(this, AddContactActivity.class);
				
		startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_choose_action, menu);
        return true;
    }
    
}
