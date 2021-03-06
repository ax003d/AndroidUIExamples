package com.packtpub.packttunes;

import android.graphics.drawable.Drawable;

public class Artist {

	private final Drawable logo;
	private final String description;
	
	public Artist(Drawable logo, String description) {
		super();
		this.logo = logo;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public Drawable getLogo() {
		return logo;
	}
	
	
}
