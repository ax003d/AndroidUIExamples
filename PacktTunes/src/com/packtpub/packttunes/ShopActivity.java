package com.packtpub.packttunes;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ShopActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources resources = getResources();
        setAlbum(new Album(
        		resources.getDrawable(R.drawable.album_art), 
        		"The Android Quartet", 
        		new Artist(resources.getDrawable(R.drawable.sherlock), "Sherlock Peterson"), 
        		"Green Records", 
        		new Track("I was a robot", 208), 
        		new Track("Long is not enough time", 243), 
        		new Track("The rocket robot reel", 143)));
    }

	private void setAlbum(Album album) {
		ViewGroup tracks = (ViewGroup) findViewById(R.id.track_listing);
		for (Track t : album.getTracks() ) {
			addTrackView(tracks, t);
		}
		
		ImageView albumArt = (ImageView) findViewById(R.id.artwork);
		albumArt.setImageDrawable(album.getCover());
		
		ImageView artistLogo = (ImageView) findViewById(R.id.artist_logo);
		artistLogo.setImageDrawable(album.getArtist().getLogo());
		
		TextView albumLabel = (TextView) findViewById(R.id.album_label);
		albumLabel.setText(album.getName());
		
		TextView recordLabel = (TextView) findViewById(R.id.record_label);
		recordLabel.setText(album.getLabel());
		
		AmountBox amount = (AmountBox) findViewById(R.id.purchase_amount);
		amount.setFormat(new DecimalFormat("$ 0.##"));
	}

	private void addTrackView(ViewGroup tracks, Track t) {
		LayoutInflater inflater = getLayoutInflater();
		ViewGroup line = (ViewGroup) inflater.inflate(R.layout.track, tracks, false);
		
		TextView trackName = (TextView) line.findViewById(R.id.track_name);
		trackName.setText(t.getName());
		
		TextView trackTime = (TextView) line.findViewById(R.id.track_time);
		StringBuilder builder = new StringBuilder();
		builder.append(t.getMinutes()).append(":");
		if (t.getSeconds() < 10) {
			builder.append('0');
		}
		builder.append(t.getSeconds());
		trackTime.setText(builder.toString());
		tracks.addView(line);
	}
}
