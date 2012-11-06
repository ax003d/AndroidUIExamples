package com.packtpub.layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;


public class CircleLayout extends ViewGroup {

	public CircleLayout(Context context) {
		super(context);
	}
	
    public CircleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleLayout(Context context, AttributeSet attrs, int defStyle) {
    	super(context, attrs, defStyle);
    }
	

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		int w = r - l;
		int h = b - t;
		int count = getChildCount();
		int[] max = measureChildrenSizes(w, h);
		w -= max[0];
		h -= max[1];
		int cx = w / 2;
		int cy = h / 2;
		for ( int i = 0; i < count; i++ ) {
			View child = getChildAt(i);
			double v = 2 * Math.PI * i / count;
			int x = l + (cx + (int)(Math.cos(v) * cx));
			int y = t + (cy + (int)(Math.sin(v) * cy));
			child.layout(x, y, x + child.getMeasuredWidth(), y + child.getMeasuredHeight());
		}
	}

	private int[] measureChildrenSizes(int sw, int sh) {
		int maxWidth = 0;
		int maxHeight = 0;
		for ( int i = 0; i < getChildCount(); i++ ) {
			View child = getChildAt(i);
			measureChild(child, sw, sh);
			maxWidth = Math.max(maxWidth, child.getMeasuredWidth());
			maxHeight = Math.max(maxHeight, child.getMeasuredHeight());
		}
		return new int[] {maxWidth, maxHeight};
	}
}
