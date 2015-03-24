package main7.parser;

public enum Modes {
	PERSONER("Personer"),
	LEGEMIDLER("Legemidler"),
	LEGER("Leger"),
	RESEPTER("Resepter"),
	SLUTT("Slutt");

	private String text;

	Modes(String text) {
		this.text = text;
	}

	public String get() {
		return text;
	}
}
