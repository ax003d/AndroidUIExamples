package com.packtpub.packttunes;

import android.graphics.drawable.Drawable;

public class Album {

	private final Drawable cover;
	private final String name;
	private final Artist artist;
	private final String label;
	private final Track[] tracks;
	
	public Album(Drawable cover, String name, Artist artist, String label,
			Track...tracks) {	
		this.cover = cover;
		this.name = name;
		this.artist = artist;
		this.label = label;
		this.tracks = tracks;
	}
	
	public Drawable getCover() {
		return cover;
	}

	public String getName() {
		return name;
	}

	public Artist getArtist() {
		return artist;
	}

	public String getLabel() {
		return label;
	}

	public Track[] getTracks() {
		return tracks;
	}	
}
