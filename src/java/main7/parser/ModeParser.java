package main7.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModeParser implements Parser<Modes> {
	private final String regexp;

	private Pattern pattern;

	public ModeParser() {
		regexp = makeRegexp();
		pattern = Pattern.compile(regexp);
	}

	private String makeRegexp() {
		StringBuilder sb = new StringBuilder();
		sb.append("^#\\s(");

		for (Modes mode : Modes.values()) {
			sb.append("(?<");
			sb.append(mode.get());
			sb.append(">");
			sb.append(mode.get());
			sb.append(")|");
		}

		sb.append(")");

		return sb.toString();
	}

	@Override
	public Modes parse(String line) {
		Matcher matcher = pattern.matcher(line);
		matcher.find();

		for (Modes mode : Modes.values()) {
			if (matcher.group(mode.get()) != null) {
				return mode;
			}
		}

		return null;
	}
}
