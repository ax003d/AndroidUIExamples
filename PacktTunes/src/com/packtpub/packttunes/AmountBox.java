package com.packtpub.packttunes;

import java.text.DecimalFormat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class AmountBox extends TextSwitcher implements ViewFactory {

	public AmountBox(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public AmountBox(Context context) {
		super(context);
		init();
	}

	private void init() {
		setOutAnimation(getContext(), android.R.anim.fade_out);
		setInAnimation(getContext(), android.R.anim.fade_in);
		setFactory(this);
		setAmount(10);
	}

	private DecimalFormat format = new DecimalFormat("0.##");
	private double amount;
	

	@Override
	public View makeView() {
		TextView view = new TextView(getContext());
		view.setTextSize(18);
		return view;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		int color;
		if ( amount < this.amount ) {
			color = 0xff00ff00;
		} else if ( amount > this.amount ) {
			color = 0xffff0000;
		} else {
			return;
		}
		
		TextView offscreen = (TextView) getNextView();
		offscreen.setTextColor(color);
		offscreen.setShadowLayer(3, 0, 0, color);
		offscreen.setText(format.format(amount));
		showNext();
		this.amount = amount;
	}

	public DecimalFormat getFormat() {
		return format;
	}

	public void setFormat(DecimalFormat format) {
		this.format = format;
	}

}
