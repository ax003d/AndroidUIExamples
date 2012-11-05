package com.packtpub.layouts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FrameLayoutActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame_layout);
		
		Button overlay = (Button)findViewById(R.id.overlay_button);
		overlay.setOnClickListener(this);
		Button quit = (Button)findViewById(R.id.quit);
		quit.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) { 
		switch ( v.getId() ) {
		case R.id.overlay_button:
			View display = findViewById(R.id.overlay);
			display.setVisibility(display.getVisibility() != View.VISIBLE 
					? View.VISIBLE : View.GONE);
			break;
		case R.id.quit:
			finish();
			break;
		default:
			break;
		}
	}
}