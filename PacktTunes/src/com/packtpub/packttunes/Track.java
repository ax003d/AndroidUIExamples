package com.packtpub.packttunes;

public class Track {
	private final String name;
	private final int length;
	
	public Track(String name, int length) {
		this.name = name;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public int getLength() {
		return length;
	}
	
	public int getMinutes() {
		return length / 60;
	}
	
	public int getSeconds() {
		return length % 60;
	}
	
}
