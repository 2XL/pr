package com.pcrigger.thelastemperior;

import android.R.string;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements OnClickListener {

	Button sqlUpdate, sqlView;
	EditText sqlName, sqlHotness;
	// vid 121 - setting up more sqlite methods
	Button sqlModify, sqlGetInfo, sqlDelete;
	EditText sqlRow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqliteexample);
		sqlUpdate = (Button) findViewById(R.id.bSQLUpdateDB);
		sqlName = (EditText) findViewById(R.id.etSQLName);
		sqlHotness = (EditText) findViewById(R.id.etSQLHotnessScale);
		sqlView = (Button) findViewById(R.id.bSQLOpenView);
		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);

		// vid 121 - setting up more sqlite methods
		sqlRow = (EditText) findViewById(R.id.etSQLEnterRowID);
		sqlModify = (Button) findViewById(R.id.bSQLEditEntry);
		sqlGetInfo = (Button) findViewById(R.id.bSQLGetInfo);
		sqlDelete = (Button) findViewById(R.id.bSQLDeleteEntry);

		sqlDelete.setOnClickListener(this);
		sqlModify.setOnClickListener(this);
		sqlGetInfo.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bSQLUpdateDB:

			boolean didItWork = true;
			try {
				String name = sqlName.getText().toString();
				String hotness = sqlHotness.getText().toString();
				HotOrNot entry = new HotOrNot(SQLiteExample.this);
				entry.open();

				entry.createEntry(name, hotness);

				entry.close();
			} catch (Exception e) {
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Omg, damn fail!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();

			} finally {
				if (didItWork) {
					Dialog d = new Dialog(this);
					d.setTitle("Heck Yea!");
					TextView tv = new TextView(this);
					tv.setText("Success");
					d.setContentView(tv);
					d.show();
				}
			}
			break;
		case R.id.bSQLOpenView:
			Intent i = new Intent("com.pcrigger.thelastemperior.SQLVIEW");
			startActivity(i);
			break;
		case R.id.bSQLGetInfo:
			try {
				String s = sqlRow.getText().toString();
				long l = Long.parseLong(s);
				HotOrNot hon = new HotOrNot(this);
				hon.open();
				String returnedName = hon.getName(l); // l is witch row this
														// person is set in the
														// database
				String returnedHotness = hon.getHotness(l);
				hon.close();
				sqlName.setText(returnedName);
				sqlHotness.setText(returnedHotness);
			} catch (Exception e) {
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Omg, damn fail!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();

			}
			break;
		case R.id.bSQLEditEntry:
			try {
				String mName = sqlName.getText().toString();
				String mHotness = sqlHotness.getText().toString();
				String sRow = sqlRow.getText().toString();
				long lRow = Long.parseLong(sRow);

				HotOrNot ex = new HotOrNot(this);
				ex.open();
				ex.updateEntry(lRow, mName, mHotness);
				ex.close();
			} catch (Exception e) {
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Omg, damn fail!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();

			}

			break;
		case R.id.bSQLDeleteEntry:
			try {
				String sRowDel = sqlRow.getText().toString();
				long lRowDel = Long.parseLong(sRowDel);
				HotOrNot exDel = new HotOrNot(this);
				exDel.open();
				exDel.deleteEntry(lRowDel);
				exDel.close();
			} catch (Exception e) {
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Omg, damn fail!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();

			}
			break;
		}
	}

}
