package main7.parser;

import no.uio.inf1010.oblig6.Person;
import no.uio.inf1010.oblig6.collections.Tabell;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonParser {
	private final String regexp = "((?<UNIKID>\\d+),\\s*)?(?<Navn>[^,]+),\\s*(?<Fodselsnummer>\\d{11}),\\s*(?<Adresse>[^,]+),\\s*(?<Postnummer>\\d{4})";

	private Pattern pattern;

	public PersonParser() {
		pattern = Pattern.compile(regexp);
	}


	public void parse(String line, Tabell<Person> tabell) {
		Matcher matcher = pattern.matcher(line);

		if (matcher.matches()) {
			int unikid = -1;

			if (!matcher.group("UNIKID").isEmpty()) {
				unikid = Integer.parseInt(matcher.group("UNIKID"));
			}

			String navn = matcher.group("Navn");
			int fodselsnummer = Integer.parseInt(matcher.group("Fodselsnummer"));
			String adresse = matcher.group("Adresse");
			int postnummer = Integer.parseInt(matcher.group("Postnummer"));

			if (unikid < 0) {
				Person p = new Person(navn, fodselsnummer, adresse, postnummer);
			} else {
				Person p = new Person(unikid, navn, fodselsnummer, adresse, postnummer);
			}
		}
	}
}
