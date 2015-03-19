package main7.parser;

import no.uio.inf1010.oblig6.Person;
import no.uio.inf1010.oblig6.collections.Tabell;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonParser {
	private final String regexp = "((?<UNIKID>\\d+)|(?<cmd>nyperson))(?:,\\s*|\\s*)(?<Navn>[^,]+),\\s*(?<Fodselsnummer>\\d{11}),\\s*(?<Adresse>[^,]+),\\s*(?<Postnummer>\\d{4})";

	private Pattern pattern;
	private Tabell<Person> tabell;

	public PersonParser(Tabell<Person> tabell) {
		pattern = Pattern.compile(regexp);
		this.tabell = tabell;
	}


	public Person parse(String line) {
		Matcher matcher = pattern.matcher(line);

		if (matcher.matches()) {
			Person p;
			int unikid = -1;

			if (matcher.group("UNIKID") != null) {
				unikid = Integer.parseInt(matcher.group("UNIKID"));
			}

			String navn = matcher.group("Navn");
			String fodselsnummer = matcher.group("Fodselsnummer");
			String adresse = matcher.group("Adresse");
			String postnummer = matcher.group("Postnummer");

			if (unikid < 0) {
				p = new Person(navn, fodselsnummer, adresse, postnummer);
			} else {
				p = new Person(unikid, navn, fodselsnummer, adresse, postnummer);
			}

			tabell.put(p.getUnik(), p);
			return p;
		}

		return null;
	}
}
