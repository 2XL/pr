package com.pcrigger.thelastemperior;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WeatherXMLParsing extends Activity implements OnClickListener{

	TextView tv;
	EditText city, state;
	static final String baseURL = "http://www.google.com/ig/api?weather=";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xmlparsing);
		
		Button b = (Button) findViewById(R.id.bParsing);
		tv = (TextView) findViewById(R.id.tvParsingCurrentWeather);
		city = (EditText) findViewById(R.id.etParsingCity);
		state = (EditText)findViewById(R.id.etParsingState);
		b.setOnClickListener(this);
	
	
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String c = city.getText().toString();
		String s = state.getText().toString();
		StringBuilder url = new StringBuilder(baseURL);
		url.append(c+","+s);
		String fullUrl = url.toString();
		
		// vid 157 - SAXParserFactory and XMLReader
		try{
			URL website = new URL(fullUrl);
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();
			HandlingXMLStuff doingWork = new HandlingXMLStuff();
			xr.setContentHandler(doingWork);
			xr.parse(new InputSource(website.openStream()));
			String information = doingWork.getInformation();
			tv.setText(information);
			// simple api parser
		}catch(Exception e){
			tv.setText("error");
		}
		
	}
 
// http://www.google.com/ig/api?weather=
	
	
	
	
	
}
