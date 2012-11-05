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
				
		Cursor c = managedQuery(getIntent().getData(), null, null, null, null);
		for ( String col: c.getColumnNames() ) {
			Log.d("onCreate", col);
		}		
		
		try {
			if (c.moveToNext()) {
				String id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
				String display_name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				String has_phone = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
				String phone_number = null;
				
				if ( has_phone.equals("1") ) {
					Cursor nc = getContentResolver().query(
							ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
		                    null,
		                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + id, 
		                    null, 
		                    null);
					try {
						if ( nc.moveToNext() ) {
							phone_number = nc.getString(nc.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
						}
					} finally {
						nc.close();
					}
				}
				
				name.setText(display_name);
				if ( phone_number != null )
					number.setText("tel://" + phone_number);
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
