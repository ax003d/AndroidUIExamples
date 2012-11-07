package com.packtpub.animations;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class VanishingButtonActivity extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vanish);
        
        Button button = (Button) findViewById(R.id.vanish);
        button.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		Animation vanish = AnimationUtils.loadAnimation(this, R.anim.vanish);
		findViewById(R.id.vanish).startAnimation(vanish);
	}

    
}
