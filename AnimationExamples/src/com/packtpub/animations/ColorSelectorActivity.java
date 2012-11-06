package com.packtpub.animations;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.GridView;

public class ColorSelectorActivity extends Activity {
	private GridView view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colors);

		Animation animation = AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in);
		GridLayoutAnimationController animationController = new GridLayoutAnimationController(
				animation, 0.2f, 0.2f);
		view = (GridView) findViewById(R.id.colors);
		view.setNumColumns(10);
		view.setAdapter(new ColorAdapter(10, 10));
		view.setLayoutAnimation(animationController);
	}

	@Override
	protected void onStart() {	
		super.onStart();
		view.getLayoutAnimation().start();
	}
}
