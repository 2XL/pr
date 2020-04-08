package com.pcrigger.thelastemperior;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class Tabs extends Activity implements OnClickListener{
	TabHost th;
	// vid 87
	TextView showResults;
	long start, stop;	// para trabajar cn miliseconds
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		// vid 85 - setting up the tabhost in java
		th = (TabHost) findViewById(R.id.tabhost);
		// vid 86 - creating tabs in java
		Button newTab = (Button)findViewById(R.id.bAddTab);
		Button bStart = (Button)findViewById(R.id.bStartWatch);
		Button bStop = (Button)findViewById(R.id.bStopWatch);
		showResults = (TextView) findViewById(R.id.tvShowResults);
		
		bStart.setOnClickListener(this);
		start = 0;
		bStop.setOnClickListener(this);
		
		
		newTab.setOnClickListener(this);
		
		
		
		// vid 85
		th.setup();
		//tab1	
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("StopWatch");
		th.addTab(specs);
		//tab2	
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Tab 2");
		th.addTab(specs);
		//tab3	
		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("Add a Tab");
		th.addTab(specs);
		
	}
// vid 86
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bAddTab:
			TabSpec ourSpec = th.newTabSpec("tag1");
			ourSpec.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String tag) {
					// TODO Auto-generated method stub
					TextView text = new TextView(Tabs.this);
					text.setText("You've created a new Tab!");
					return text;
				}
			});
			ourSpec.setIndicator("New");
			th.addTab(ourSpec);
			break;
		case R.id.bStartWatch:
			// get current time from the sistem
			start = System.currentTimeMillis();
			
			
			break;
		case R.id.bStopWatch:
			stop = System.currentTimeMillis();
			// change the text view
			if(start!=0)
			{
				long result = stop - start;
				int millis = (int)result;
				int secound =(int)result/1000;
				int minutes =secound/60;
				millis = millis % 100;
				secound = secound %60;
				
				start = 0;
				showResults.setText(String.format("Time: %d:%02d:%02d", minutes, secound, millis));
			}
			
			break;
		}
	}

}
