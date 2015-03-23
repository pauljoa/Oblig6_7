package main7.parser;

import java.util.Iterator;

public enum Modes {
	PERSONER("Personer"),
	LEGEMIDLER("Legemidler"),
	LEGER("Leger"),
	RESEPTER("Resepter"),
	SLUTT("slutt");

	private String text;

	Modes(String text) {
		this.text = text;
	}

	public String get() {
		return text;
	}
}
