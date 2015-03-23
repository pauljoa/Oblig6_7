package main7.parser;

import no.uio.inf1010.oblig6.collections.SortertEnkelListe;
import no.uio.inf1010.oblig6.lege.Fastlege;
import no.uio.inf1010.oblig6.lege.Lege;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegeParser {
	//TODO make eregexp conditional in constructor depending on file or cmd mode
	private static final String regexp = "^(?<cmd>nylege)?\\s*(?<navn>[^,]+),\\s*(?<avtalenr>\\d+)";

	private Pattern pattern;
	private SortertEnkelListe<Lege> liste;

	public LegeParser(SortertEnkelListe<Lege> liste) {
		pattern = Pattern.compile(regexp);
		this.liste = liste;
	}

	public Lege parse(String line) {
		Matcher matcher = pattern.matcher(line);

		if (matcher.matches()) {
			Lege lege;

			String navn = matcher.group("navn");
			int avtalenr = Integer.parseInt(matcher.group("avtalenr"));

			if (avtalenr == 0) {
				lege = new Lege(navn);
			} else {
				lege = new Fastlege(navn, avtalenr);
			}

			liste.push(lege);
			return lege;
		}

		return null;
	}
}
