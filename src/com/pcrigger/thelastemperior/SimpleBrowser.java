package com.pcrigger.thelastemperior;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener {

	// vid 90
	EditText url;
	WebView ourBrow;

	// vid 89
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);

		ourBrow = (WebView) findViewById(R.id.wvBrowser);
		// vid 91 - set webview client for a browser app

		// vid 92 - webviewSetting
		ourBrow.getSettings().setJavaScriptEnabled(true);
		ourBrow.getSettings().setLoadWithOverviewMode(true);
		ourBrow.getSettings().setUseWideViewPort(true);

		ourBrow.setWebViewClient(new ourViewClient());

		try {
			ourBrow.loadUrl("http://www.google.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Button go = (Button) findViewById(R.id.bGo);
		Button back = (Button) findViewById(R.id.bBack);
		Button forward = (Button) findViewById(R.id.bForward);
		Button refresh = (Button) findViewById(R.id.bRefresh);
		Button clearHistory = (Button) findViewById(R.id.bHistory);

		url = (EditText) findViewById(R.id.etURL);
		go.setOnClickListener(this);
		back.setOnClickListener(this);
		refresh.setOnClickListener(this);
		forward.setOnClickListener(this);
		clearHistory.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bGo:
			String theWebsite = url.getText().toString();
			ourBrow.loadUrl(theWebsite);
			// vid 93 hidding keyboard
			// hidding keyboard after using edit text
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			break;
		case R.id.bBack:
			if (ourBrow.canGoBack())
				ourBrow.goBack();
			break;
		case R.id.bForward:
			if (ourBrow.canGoForward())
				ourBrow.goForward();
			break;
		case R.id.bRefresh:
			ourBrow.reload();
			break;
		case R.id.bHistory:
			ourBrow.clearHistory();
			break;

		}

	}

}
