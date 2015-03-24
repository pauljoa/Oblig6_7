package no.uio.inf1010.oblig6.main7.parser;

import no.uio.inf1010.oblig6.collections.Tabell;
import no.uio.inf1010.oblig6.legemiddel.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegemiddelParser implements Parser<Legemiddel> {
	private static final String regexp = "((?<UNIKID>\\d+)|(?<cmd>legemiddel))(?:,\\s*|\\s*)(?<navn>[^,]+),\\s*(?<form>(mikstur|pille)),\\s*(?<type>(a|b|c)),\\s*(?<pris>\\d+),\\s*(?<antall>\\d+),\\s*(?<virkestoff>\\d+)(,\\s*(?<styrke>\\d+))?";

	private Pattern pattern;
	private Tabell<Legemiddel> tabell;

	public LegemiddelParser(Tabell<Legemiddel> tabell) {
		pattern = Pattern.compile(regexp);
		this.tabell = tabell;
	}

	@Override
	public Legemiddel parse(String line) {
		Matcher matcher = pattern.matcher(line);

		if (matcher.matches()) {
			int nr = -1;

			if (matcher.group("UNIKID") != null) {
				nr = Integer.parseInt(matcher.group("UNIKID"));
			}

			String navn = matcher.group("navn");
			String form = matcher.group("form");
			String type = matcher.group("type");
			int pris = Integer.parseInt(matcher.group("pris"));

			//TODO antall er også double, håndtere dette!
			int antall = Integer.parseInt(matcher.group("antall"));

			int virkestoff = Integer.parseInt(matcher.group("virkestoff"));

			int styrke = -1;

			if (matcher.group("styrke") != null) {
				styrke = Integer.parseInt(matcher.group("styrke"));
			}

			if (nr < 0) {
				int index = tabell.size() + 1;

				if (form.equals("mikstur")) {
					if (type.equals("a")) {
						Legemiddel legemiddel = new AM(index, navn, pris, antall, virkestoff, styrke);
						tabell.add(legemiddel.getNr(), legemiddel);
						return legemiddel;
					} else if (type.equals("b")) {
						Legemiddel legemiddel = new BM(index, navn, pris, antall, virkestoff, styrke);
						tabell.add(legemiddel.getNr(), legemiddel);
						return legemiddel;
					} else if (type.equals("c")) {
						Legemiddel legemiddel = new CM(index, navn, pris, antall, virkestoff);
						tabell.add(legemiddel.getNr(), legemiddel);
						return legemiddel;
					}
				} else if (form.equals("pille")) {
					if (type.equals("a")) {
						Legemiddel legemiddel = new AP(index, navn, pris, antall, virkestoff, styrke);
						tabell.add(legemiddel.getNr(), legemiddel);
						return legemiddel;
					} else if (type.equals("b")) {
						Legemiddel legemiddel = new BP(index, navn, pris, antall, virkestoff, styrke);
						tabell.add(legemiddel.getNr(), legemiddel);
						return legemiddel;
					} else if (type.equals("c")) {
						Legemiddel legemiddel = new CP(index, navn, pris, antall, virkestoff);
						tabell.add(legemiddel.getNr(), legemiddel);
						return legemiddel;
					}
				}
			} else {
				if (form.equalsIgnoreCase("mikstur")) {
					if (type.equals("a")) {
						Legemiddel legemiddel = new AM(nr, navn, pris, antall, virkestoff, styrke);
						tabell.add(legemiddel.getNr(), legemiddel);
						return legemiddel;
					} else if (type.equals("b")) {
						Legemiddel legemiddel = new BM(nr, navn, pris, antall, virkestoff, styrke);
						tabell.add(legemiddel.getNr(), legemiddel);
						return legemiddel;
					} else if (type.equals("c")) {
						Legemiddel legemiddel = new CM(nr, navn, pris, antall, virkestoff);
						tabell.add(legemiddel.getNr(), legemiddel);
						return legemiddel;
					}
				} else if (form.equalsIgnoreCase("pille")) {
					if (type.equals("a")) {
						Legemiddel legemiddel = new AP(nr, navn, pris, antall, virkestoff, styrke);
						tabell.add(legemiddel.getNr(), legemiddel);
						return legemiddel;
					} else if (type.equals("b")) {
						Legemiddel legemiddel = new BP(nr, navn, pris, antall, virkestoff, styrke);
						tabell.add(legemiddel.getNr(), legemiddel);
						return legemiddel;
					} else if (type.equals("c")) {
						Legemiddel legemiddel = new CP(nr, navn, pris, antall, virkestoff);
						tabell.add(legemiddel.getNr(), legemiddel);
						return legemiddel;
					}
				}
			}
		}

		return null;
	}
}
