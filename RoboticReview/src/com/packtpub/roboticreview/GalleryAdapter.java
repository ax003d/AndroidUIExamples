package com.packtpub.roboticreview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

class GalleryAdapter extends BaseAdapter {

	private final String[] images = new String[] {
			"http://fs.memori.cn/tushuo/photo/1347885049683.jpg",
			"http://fs.memori.cn/tushuo/photo/1347885263240.jpg",
			"http://fs.memori.cn/tushuo/photo/1347885636990.jpg" };

	@Override
	public int getCount() {
		return images.length;
	}

	@Override
	public Object getItem(int position) {
		return images[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.d("getView", String.valueOf(position));
		ImageView view = convertView instanceof ImageView ? (ImageView) convertView
				: (ImageView) LayoutInflater.from(parent.getContext()).inflate(
						R.layout.gallery_thn, null);
		view.setImageDrawable(Utils.LoadImageFromWebOperations(images[position]));
		return view;
	}

}