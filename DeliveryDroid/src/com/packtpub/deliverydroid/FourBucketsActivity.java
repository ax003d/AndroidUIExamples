package com.packtpub.deliverydroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.GridView;

public class FourBucketsActivity extends Activity {
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        LayoutInflater inflater = getLayoutInflater();
        GridView view = (GridView)inflater.inflate(R.layout.four_buckets, null);
        view.setAdapter(new FruitAdapter(
        		new FruitItem("Strawberry", R.drawable.strawberry),
        		new FruitItem("Strawberry", R.drawable.strawberry),
        		new FruitItem("Strawberry", R.drawable.strawberry),
        		new FruitItem("Strawberry", R.drawable.strawberry),
        		new FruitItem("Strawberry", R.drawable.strawberry),
        		new FruitItem("Strawberry", R.drawable.strawberry),
        		new FruitItem("Strawberry", R.drawable.strawberry),
        		new FruitItem("Strawberry", R.drawable.strawberry),
        		new FruitItem("Strawberry", R.drawable.strawberry)
        		));
        setContentView(view);
	}

}