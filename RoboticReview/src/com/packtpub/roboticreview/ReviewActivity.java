package com.packtpub.roboticreview;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.TabActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TabHost;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class ReviewActivity extends TabActivity implements
		ViewSwitcher.ViewFactory, Runnable, AdapterView.OnItemSelectedListener,
		SeekBar.OnSeekBarChangeListener {

	public class ImageSwitcherFactory implements ViewSwitcher.ViewFactory {

		@Override
		public View makeView() {
			return new ImageView(ReviewActivity.this);
		}

	}

	private final Handler switchCommentHandler = new Handler();
	private TextSwitcher switcher;
	private String[] comments;
	private int commentIndex = 0;

	private ImageSwitcher photo;
	private Gallery photos;

	private String peopleLableFormat;
	private TextView peopleLable;
	private SimpleDateFormat dateFormat;
	private Button date;
	private SimpleDateFormat timeFormat;
	private Button time;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TabHost tabs = getTabHost();
		getLayoutInflater().inflate(R.layout.main, tabs.getTabContentView(),
				true);
		Resources resources = getResources();
		TabHost.TabSpec details = tabs
				.newTabSpec("review")
				.setContent(R.id.review)
				.setIndicator(getString(R.string.review),
						resources.getDrawable(R.drawable.review));

		TabHost.TabSpec gallery = tabs
				.newTabSpec("photos")
				.setContent(R.id.photos)
				.setIndicator(getString(R.string.gallery),
						resources.getDrawable(R.drawable.photos));

		TabHost.TabSpec reservation = tabs
				.newTabSpec("review")
				.setContent(R.id.reservation)
				.setIndicator(getString(R.string.reservation),
						resources.getDrawable(R.drawable.reservation));

		tabs.addTab(details);
		tabs.addTab(gallery);
		tabs.addTab(reservation);

		comments = resources.getStringArray(R.array.comments);
		switcher = (TextSwitcher) findViewById(R.id.reviews);
		switcher.setFactory(this);

		photo = (ImageSwitcher) findViewById(R.id.photo);
		photo.setFactory(new ImageSwitcherFactory());

		photos = ((Gallery) findViewById(R.id.gallery));
		photos.setAdapter(new GalleryAdapter());
		photos.setOnItemSelectedListener(this);

		peopleLable = (TextView) findViewById(R.id.people_label);
		peopleLableFormat = peopleLable.getText().toString();
		date = (Button) findViewById(R.id.date);
		dateFormat = new SimpleDateFormat(date.getText().toString());
		time = (Button) findViewById(R.id.time);
		timeFormat = new SimpleDateFormat(time.getText().toString());
		Calendar calendar = Calendar.getInstance();
		if (calendar.get(Calendar.HOUR_OF_DAY) >= 16) {
			calendar.add(Calendar.DATE, 1);
		}
		calendar.set(Calendar.HOUR_OF_DAY, 18);
		calendar.clear(Calendar.MINUTE);
		calendar.clear(Calendar.SECOND);
		calendar.clear(Calendar.MILLISECOND);
		Date reservationDate = calendar.getTime();
		date.setText(dateFormat.format(reservationDate));
		time.setText(timeFormat.format(reservationDate));
		SeekBar people = (SeekBar) findViewById(R.id.people);
		people.setOnSeekBarChangeListener(this);
		peopleLable.setText(String.format(peopleLableFormat,
				people.getProgress() + 1));
	}

	public View makeView() {
		return getLayoutInflater().inflate(R.layout.review_comment, null);
	}

	protected void onStart() {
		super.onStart();
		switchCommentHandler.postDelayed(this, 5 * 1000l);
	}

	protected void onStop() {
		super.onStop();
		switchCommentHandler.removeCallbacks(this);
	}

	public void run() {
		try {
			switcher.setText(comments[commentIndex++]);
			if (commentIndex >= comments.length) {
				commentIndex = 0;
			}
		} finally {
			switchCommentHandler.postDelayed(this, 5 * 1000l);
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		photo.setImageDrawable(Utils.LoadImageFromWebOperations((String) photos
				.getAdapter().getItem(position)));
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		peopleLable.setText(String.format(peopleLableFormat, progress + 1));

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

}
