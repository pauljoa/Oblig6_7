package main7.parser;

import no.uio.inf1010.oblig6.collections.EldsteForstReseptListe;
import no.uio.inf1010.oblig6.collections.SortertEnkelListe;
import no.uio.inf1010.oblig6.collections.Tabell;
import no.uio.inf1010.oblig6.collections.YngsteForstReseptListe;
import no.uio.inf1010.oblig6.lege.Lege;
import no.uio.inf1010.oblig6.legemiddel.Legemiddel;
import no.uio.inf1010.oblig6.resept.Resept;
import no.uio.inf1010.oblig6.resept.ReseptBlaa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReseptParser {
	private static final String regexp = "^(?<cmd>nyresept)?\\s*(?<nr>\\d+)?,?\\s*(?<type>hvit|blå),\\s*(?<persNummer>\\d+),\\s*(?<legenavn>\\w[^,]*),\\s*(?<legemiddelNummer>\\d+),\\s*(?<reit>\\d+)";

	private final YngsteForstReseptListe yngsteForstReseptListe;
	private final EldsteForstReseptListe eldsteForstReseptListe;
	private final SortertEnkelListe<Lege> sortertLegeListe;
	private final Tabell<Legemiddel> legemiddelTabell;

	private Pattern pattern;

	public ReseptParser(YngsteForstReseptListe yngsteForstReseptListe, EldsteForstReseptListe eldsteForstReseptListe, SortertEnkelListe<Lege> sortertLegeListe, Tabell<Legemiddel> legemiddelTabell) {
		this.yngsteForstReseptListe = yngsteForstReseptListe;
		this.eldsteForstReseptListe = eldsteForstReseptListe;
		this.sortertLegeListe = sortertLegeListe;
		this.legemiddelTabell = legemiddelTabell;

		pattern = Pattern.compile(regexp);
	}

	public Resept parse(String line) {
		Matcher matcher = pattern.matcher(line);

		if (matcher.matches()) {
			int nr = -1;

			if (matcher.group("nr") != null) {
				nr = Integer.parseInt(matcher.group("nr"));
			}

			String type = matcher.group("type");
			int persNummer = Integer.parseInt(matcher.group("persNummer")); // unik id, ikke fødselsnummer
			String legenavn = matcher.group("legenavn");
			int legemiddelNummer = Integer.parseInt(matcher.group("legemiddelNummer"));
			int reit = Integer.parseInt(matcher.group("reit"));

			// match lege to actual object
			Lege lege = matchLege(legenavn);
			Legemiddel legemiddel = matchLegemiddel(legemiddelNummer);

			if (lege != null && legemiddel != null) {
				if (nr != -1) {
					if (type.equals("hvit")) {
						return new Resept(nr, persNummer, reit, lege, legemiddel);
					} else if (type.equals("blå")) {
						return new ReseptBlaa(nr, persNummer, reit, lege, legemiddel);
					}
				} else {
					if (type.equals("hvit")) {
						return new Resept(persNummer, reit, lege, legemiddel);
					} else if (type.equals("blå")) {
						return new ReseptBlaa(persNummer, reit, lege, legemiddel);
					}
				}
			}
		}

		return null;
	}

	private Lege matchLege(String legenavn) {
		for (Lege lege : sortertLegeListe) {
			if (lege.navn().equalsIgnoreCase(legenavn)) {
				return lege;
			}
		}

		return null;
	}

	private Legemiddel matchLegemiddel(int legemiddelNummer) {
		for (Legemiddel lm : legemiddelTabell) {
			if (lm.getNr() == legemiddelNummer) {
				return lm;
			}
		}

		return null;
	}
}
