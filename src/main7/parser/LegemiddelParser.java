package main7.parser;

import no.uio.inf1010.oblig6.Person;
import no.uio.inf1010.oblig6.collections.Tabell;
import no.uio.inf1010.oblig6.legemiddel.Legemiddel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegemiddelParser {
	private final String regexp = "((?<nr>\\d+),\\s*)?(?<navn>[^,]+),\\s*(?<form>(mikstur|pille)),\\s*(?<type>(a|b|c)),\\s*(?<pris>\\d+),\\s*(?<antall>\\d+),\\s*(?<virkestoff>\\d+)(,\\s*(?<styrke>\\d+))?";

	private Pattern pattern;

	public LegemiddelParser() {
		pattern = Pattern.compile(regexp);
	}


	public void parse(String line, Tabell<Legemiddel> tabell) {
		Matcher matcher = pattern.matcher(line);

		if (matcher.matches()) {
			int nr = -1;

			if (!matcher.group("nr").isEmpty()) {
				nr = Integer.parseInt(matcher.group("nr"));
			}

			String navn = matcher.group("navn");
			String form = matcher.group("form");
			String type = matcher.group("type");
			int pris = Integer.parseInt(matcher.group("pris"));
			int antall = Integer.parseInt(matcher.group("antall"));
			int virkestoff = Integer.parseInt(matcher.group("virkestoff"));

			int styrke = -1;

			if (!matcher.group("styrke").isEmpty()) {
				styrke = Integer.parseInt(matcher.group("styrke"));
			}

			if (nr < 0) {
				
			} else {
			}
		}
	}
}
