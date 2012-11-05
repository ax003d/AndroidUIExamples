package com.packtpub.contactviewer;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.provider.Contacts.People;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ViewContactActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView name = (TextView) findViewById(R.id.display_name);
		Button number = (Button) findViewById(R.id.phone_number);
				
		Cursor c = managedQuery(getIntent().getData(), new String[] { People.NAME,
			People.NUMBER}, null, null, null);

		try {
			if (c.moveToNext()) {
				name.setText(c.getString(0));
				number.setText(c.getString(1));
			}
		} finally {
			c.close();
		}
		
		number.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Button btn = (Button)v;
		Intent intent = new Intent(Intent.ACTION_DIAL, 
				Uri.parse("tel://" + btn.getText()));
		startActivity(intent);
	}
}
