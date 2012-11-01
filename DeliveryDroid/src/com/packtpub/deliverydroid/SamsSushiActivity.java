package com.packtpub.deliverydroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

public class SamsSushiActivity extends Activity implements
		OnItemSelectedListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sams_sushi);

		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		TextView text = (TextView) view;
		Log.d(SamsSushiActivity.class.getName(), (String) text.getText());

		GridView grid = (GridView) findViewById(R.id.grid);
		if (text.getText().equals("Sashimi")) {
			grid.setAdapter(new FruitAdapter(new FruitItem("findingnemo",
					R.drawable.findingnemo), new FruitItem("findingnemo",
					R.drawable.findingnemo), new FruitItem("findingnemo",
					R.drawable.findingnemo), new FruitItem("findingnemo",
					R.drawable.findingnemo), new FruitItem("findingnemo",
					R.drawable.findingnemo), new FruitItem("findingnemo",
					R.drawable.findingnemo), new FruitItem("findingnemo",
					R.drawable.findingnemo), new FruitItem("findingnemo",
					R.drawable.findingnemo), new FruitItem("findingnemo",
					R.drawable.findingnemo)));
		} else {
			grid.setAdapter(new FruitAdapter(new FruitItem("wireshark",
					R.drawable.wireshark), new FruitItem("wireshark",
					R.drawable.wireshark), new FruitItem("wireshark",
					R.drawable.wireshark), new FruitItem("wireshark",
					R.drawable.wireshark), new FruitItem("wireshark",
					R.drawable.wireshark), new FruitItem("wireshark",
					R.drawable.wireshark), new FruitItem("wireshark",
					R.drawable.wireshark), new FruitItem("wireshark",
					R.drawable.wireshark), new FruitItem("wireshark",
					R.drawable.wireshark)));			
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
	}
}