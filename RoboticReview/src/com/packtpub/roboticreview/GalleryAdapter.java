package com.packtpub.roboticreview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

class GalleryAdapter extends BaseAdapter {

	private final int[] images = new int[] { R.drawable.curry_view,
			R.drawable.jai,
	};

	@Override
	public int getCount() {
		return images.length;
	}

	@Override
	public Object getItem(int position) {
		return Integer.valueOf(images[position]);
	}

	@Override
	public long getItemId(int position) {
		return images[position];
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView view = convertView instanceof ImageView ? (ImageView)convertView :
			(ImageView)LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_thn, null);
		view.setImageResource(images[position]);
		return view;
	}

}