package com.packtpub.animations;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ColorAdapter extends BaseAdapter {

	private final int rows;
	private final int cols;
	
	public ColorAdapter ( int rows, int cols ) {
		this.rows = rows;
		this.cols = cols;
	}
	
	private int getColor(int pos) {
		float h = (float)pos / (float)getCount();
		return Color.HSVToColor(new float[] { h * 360f, 1f, 1f });
	}
	
	@Override
	public int getCount() {
		return rows * cols;
	}

	@Override
	public Object getItem(int position) {
		return getColor(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView view = convertView instanceof ImageView 
				? (ImageView)convertView
				: new ImageView(parent.getContext());
		view.setImageDrawable(new ColorDrawable(getColor(position)));
		view.setLayoutParams(new GridView.LayoutParams(16, 16));
		return view;
	}

}
