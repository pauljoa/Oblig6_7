package main7.parser;

import no.uio.inf1010.oblig6.collections.Tabell;
import no.uio.inf1010.oblig6.legemiddel.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegemiddelParser {
	private final String regexp = "((?<UNIKID>\\d+)|(?<cmd>legemiddel))(?:,\\s*|\\s*)(?<navn>[^,]+),\\s*(?<form>(mikstur|pille)),\\s*(?<type>(a|b|c)),\\s*(?<pris>\\d+),\\s*(?<antall>\\d+),\\s*(?<virkestoff>\\d+)(,\\s*(?<styrke>\\d+))?";

	private Pattern pattern;
	private Tabell<Legemiddel> tabell;

	public LegemiddelParser(Tabell<Legemiddel> tabell) {
		pattern = Pattern.compile(regexp);
		this.tabell = tabell;
	}


	public void parse(String line) {
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
				if (form.equals("mikstur")) {
					if (type.equals("a")) {
						Legemiddel legemiddel = new AM(navn, virkestoff, pris, antall, styrke);
						tabell.put(legemiddel.getNr(), legemiddel);
					} else if (type.equals("b")) {
						Legemiddel legemiddel = new BM(navn, virkestoff, pris, antall, styrke);
						tabell.put(legemiddel.getNr(), legemiddel);
					} else if (type.equals("c")) {
						Legemiddel legemiddel = new CM(navn, virkestoff, pris, antall);
						tabell.put(legemiddel.getNr(), legemiddel);
					}
				} else if (form.equals("pille")) {
					if (type.equals("a")) {
						Legemiddel legemiddel = new AP(navn, virkestoff, pris, antall, styrke);
						tabell.put(legemiddel.getNr(), legemiddel);
					} else if (type.equals("b")) {
						Legemiddel legemiddel = new BP(navn, virkestoff, pris, antall, styrke);
						tabell.put(legemiddel.getNr(), legemiddel);
					} else if (type.equals("c")) {
						Legemiddel legemiddel = new CP(navn, virkestoff, pris, antall);
						tabell.put(legemiddel.getNr(), legemiddel);
					}
				}
			} else {
				if (form.equals("mikstur")) {
					if (type.equals("a")) {
						Legemiddel legemiddel = new AM(navn, virkestoff, pris, antall, styrke);
						tabell.put(legemiddel.getNr(), legemiddel);
					} else if (type.equals("b")) {
						Legemiddel legemiddel = new BM(navn, virkestoff, pris, antall, styrke);
						tabell.put(legemiddel.getNr(), legemiddel);
					} else if (type.equals("c")) {
						Legemiddel legemiddel = new CM(navn, virkestoff, pris, antall);
						tabell.put(legemiddel.getNr(), legemiddel);
					}
				} else if (form.equals("pille")) {
					if (type.equals("a")) {
						Legemiddel legemiddel = new AP(navn, virkestoff, pris, antall, styrke);
						tabell.put(legemiddel.getNr(), legemiddel);
					} else if (type.equals("b")) {
						Legemiddel legemiddel = new BP(navn, virkestoff, pris, antall, styrke);
						tabell.put(legemiddel.getNr(), legemiddel);
					} else if (type.equals("c")) {
						Legemiddel legemiddel = new CP(navn, virkestoff, pris, antall);
						tabell.put(legemiddel.getNr(), legemiddel);
					}
				}
			}
		} else {
			throw new IllegalStateException("feil med inlest linje:\n" + line);
		}
	}
}
