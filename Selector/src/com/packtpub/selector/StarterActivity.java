package com.packtpub.selector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Contacts.People;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

public class StarterActivity extends Activity implements OnClickListener {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starter);
		
		Button btn_obj = (Button)findViewById(R.id.btn_obj);
		Button btn_db  = (Button)findViewById(R.id.btn_db);
		btn_obj.setOnClickListener(this);
		btn_db.setOnClickListener(this);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if ( (requestCode == 101 || requestCode == 202) && resultCode == RESULT_OK ) {
			Object obj = data.getSerializableExtra("selection");
			Toast.makeText(this, String.valueOf(obj), Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, ListItemSelectionActivity.class);
		
		if ( v.getId() == R.id.btn_obj ) {
			intent.putExtra("data", new String[] {
					"Blue", "Green", "Red"
			});
			startActivityForResult(intent, 101);
		} else if ( v.getId() == R.id.btn_db ) {
			intent.setData(ContactsContract.Contacts.CONTENT_URI);
			intent.putExtra("line1", ContactsContract.Contacts.DISPLAY_NAME);
			intent.putExtra("line2", ContactsContract.Contacts.HAS_PHONE_NUMBER);
			startActivityForResult(intent, 202);
		}
	}
}
