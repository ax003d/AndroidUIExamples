package com.packtpub.deliverydroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class FruitAdapter extends BaseAdapter {
    private final FruitItem[] fruits;

    FruitAdapter(FruitItem... fruits) {
        this.fruits = fruits;
    }

	@Override
	public int getCount() {
		return fruits.length;
	}

	@Override
	public Object getItem(int position) {
		return fruits[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewGroup view;
		if (convertView instanceof ViewGroup ) {
			view = (ViewGroup)convertView;
		} else {
			Context context = parent.getContext();
			LayoutInflater inflater = LayoutInflater.from(context);
			view = (ViewGroup)inflater.inflate(R.layout.fruit_item, null);
		}
		FruitItem fruit = fruits[position];
		TextView text = (TextView)view.findViewById(R.id.text);
		ImageView image = (ImageView)view.findViewById(R.id.icon);
		text.setText(fruit.name);
		image.setImageResource(fruit.image);
		return view;
	}

}