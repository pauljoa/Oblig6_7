package no.uio.inf1010.oblig6;

import no.uio.inf1010.oblig6.main7.Table;
import no.uio.inf1010.oblig6.main7.parser.*;
import no.uio.inf1010.oblig6.lege.Fastlege;
import no.uio.inf1010.oblig6.lege.Lege;
import no.uio.inf1010.oblig6.legemiddel.*;
import no.uio.inf1010.oblig6.resept.Resept;
import no.uio.inf1010.oblig6.resept.ReseptBlaa;

import java.io.*;
import java.util.*;

public class Oblig {
	private Table table = new Table();

	public Oblig(File file) throws FileNotFoundException {
		if (file != null && file.exists()) {
			parseFile(file);
			System.out.println("Data lastet fra: " + file.getName());
		}

		meny();
	}

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length > 0) {
			File file = new File(args[0]);
			new Oblig(file);
		} else {
			new Oblig(null);
		}
	}

	private static void usage() {
		System.out.println("Main7 <filnavn>");
	}

	private void meny() throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);

		printMenyUsage();

		boolean loop = true;
		while (loop) {
			String line = getInput(scanner);

			if (line.startsWith("lade")) {
				parseLade(line);
			} else if (line.startsWith("skrive")) {
				parseSkrive(line);
			} else if (line.startsWith("dump")) {
				parseDump(line);
			} else if (line.startsWith("legemiddel")) {
				parseLegemiddel(line);
			} else if (line.startsWith("nylege")) {
				parseNyLege(line);
			} else if (line.startsWith("nyperson")) {
				parseNyPerson(line);
			} else if (line.startsWith("nyresept")) {
				parseNyResept(line);
			} else if (line.startsWith("hent")) {
				parseHentResept(line);
			} else if (line.startsWith("stats")) {
				parseStats(line);
			} else if (line.startsWith("avslutt")) {
				loop = false;
			} else if (line.startsWith("hjelp")) {
				printMenyUsage();
			} else {
				System.out.println("Command not found");
				printMenyUsage();
			}
		}
	}

	private void parseStats(String line) {
		String[] splits = line.split(" ");

		int mode = 0;
		try {
			mode = Integer.parseInt(splits[1]);

			if (mode == 1) {
				printStatVanedannende();
			} else if (mode == 2) {
				int personNr = Integer.parseInt(splits[2]);
				printBlaaResepter(personNr);
			} else if (mode == 3) {
				String navn = line.substring(splits[0].length() + 1 + splits[1].length() + 1, line.length());
				printLegeResepter(navn);
			} else if (mode == 4) {
				printNarkotiskPreparaterPerLege();
			} else if (mode == 5) {
				printNarkotiskPreparaterPerPerson();
			} else {
				System.out.println("Feil stat metode");
				printMenyUsage();
			}
		} catch (IndexOutOfBoundsException e) {
			printMenyUsage();
		}
	}

	/**
	 * List opp navnene på alle personer som har minst en gyldig resept på narkotiske
	 * legemidler, og for disse, skriv ut antallet per person
	 */
	private void printNarkotiskPreparaterPerPerson() {
		Map<Person, Integer> narkotiskeMidler = new LinkedHashMap<>();

		for (Resept resept : table.yngsteForstReseptListe) {
			Legemiddel legemiddel = resept.getLegemiddel();

			if (legemiddel instanceof AM || legemiddel instanceof AP) {
				int personnr = resept.getPersonnr();
				Person person = table.personTabell.get(personnr);

				int teller = 0;
				if (narkotiskeMidler.containsKey(person)) {
					teller = narkotiskeMidler.get(person);
				}

				teller++;
				narkotiskeMidler.put(person, teller);
			}
		}

		for (Person person : narkotiskeMidler.keySet()) {
			int teller = narkotiskeMidler.get(person);
			System.out.printf("%s har fått skrevet ut %d narkotiske resepter\n", person.getNavn(), teller);
		}
	}

	/**
	 * List opp navnene på alle leger (i alfabetisk rekkefølge) som har skrevet ut minst en
	 * (gyldig eller ikke) resept på narkotiske legemidler, og antallet slike resepter per lege.
	 */
	private void printNarkotiskPreparaterPerLege() {
		Map<Lege, Integer> narkotiskeMidler = new LinkedHashMap<>();

		for (Resept resept : table.yngsteForstReseptListe) {
			Legemiddel legemiddel = resept.getLegemiddel();

			if (legemiddel instanceof AM || legemiddel instanceof AP) {
				Lege lege = resept.getLege();

				int teller = 0;
				if (narkotiskeMidler.containsKey(lege)) {
					teller = narkotiskeMidler.get(lege);
				}

				teller++;
				narkotiskeMidler.put(lege, teller);
			}
		}

		for (Lege lege : narkotiskeMidler.keySet()) {
			int teller = narkotiskeMidler.get(lege);
			System.out.printf("%s har skrevet ut %d narkotiske resepter\n", lege.navn(), teller);
		}
	}

	/**
	 * For en lege med et gitt navn, skriv ut alle legens resepter på mikstur-preparater,
	 * eldste resept først. Skriv også ut den samlede mengde virkestoff for alle resepter
	 * legen har skrevet ut, og hvor mye av dette som er i pilleform og hvor mye er mikstur.
	 *
	 * @param navn navn på lege
	 */
	private void printLegeResepter(String navn) {
		Lege lege = table.sortertLegeListe.get(navn);
		double miksturVirkestoff = 0;
		double pilleVirkestoff = 0;

		System.out.printf("Mikstur resepter skrevet ut av: [%s]\n", navn);
		for (Resept resept : table.eldsteForstReseptListe) {
			Legemiddel legemiddel = resept.getLegemiddel();

			if (legemiddel instanceof Mikstur) {
				miksturVirkestoff += resept.getLegemiddel().getVirkestoff();

				if (resept.getLege().equals(lege)) {
					System.out.println(resept);
				}
			} else if (legemiddel instanceof Piller) {
				pilleVirkestoff += resept.getLegemiddel().getVirkestoff();
			}
		}

		System.out.println();
		System.out.printf("Virkestoff mikstur: %f.2f\n", miksturVirkestoff);
		System.out.printf("Virkestoff piller: %f.2f\n", pilleVirkestoff);
	}

	/**dump
	 * For en gitt person, skriv ut alle dens blå resepter, yngste resept først.
	 * Personen identifiseres enten ved sitt fødselsnummer eller ved dets unike nummer i programmet
	 *
	 * @param personNr Nøkkel i personlista, ikke faktisk personnr so av en eller annen grunn ikke er det
	 */
	private void printBlaaResepter(int personNr) {
		System.out.printf("Blå resepter for: %s\n", table.personTabell.get(personNr));

		for (Resept resept : table.yngsteForstReseptListe) {
			if (resept.getPersonnr() == personNr) {
				System.out.println(resept);
			}
		}
	}

	/**
	 * Skriv ut hvor mange vanedannende resepter det finnes totalt og hvor mange som er skrevet ut til personer bosatt i Oslo.
	 */
	private void printStatVanedannende() {
		int countTotal = 0;
		int countOslo = 0;

		for (Resept resept : table.yngsteForstReseptListe) {
			Legemiddel legemiddel = resept.getLegemiddel();

			if (legemiddel instanceof BM || legemiddel instanceof BP) {
				countTotal++;

				int personnr = resept.getPersonnr();
				Person person = table.personTabell.get(personnr);
				int postnr = Integer.parseInt(person.getPostnr());

				if (postnr < 1300) {
					countOslo++;
				}
			}
		}

		System.out.printf("Totalt %d vanedannende midler på resept, %d skrevet ut til personer bosatt i Oslo\n", countTotal, countOslo);
	}

	private void parseHentResept(String line) {
		String[] splits = line.split(" ");
		int reseptNr = Integer.parseInt(splits[1]);
		Resept resept = table.yngsteForstReseptListe.get(reseptNr);
		Legemiddel legemiddel = resept.getLegemiddel();
		int pris = resept.getPris();

		if (resept instanceof ReseptBlaa) {
			System.out.printf("Hentet blå resept: %d\n", reseptNr);
		} else {
			System.out.printf("Hentet resept: %d\n", reseptNr);
		}

		System.out.println("nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke]");
		System.out.println(legemiddel);
		System.out.printf("Pris: %d\n", pris);
	}

	private void parseNyResept(String line) {
		ReseptParser parser = new ReseptParser(table.yngsteForstReseptListe, table.eldsteForstReseptListe, table.sortertLegeListe, table.legemiddelTabell);
		Resept resept = parser.parse(line);

		if (resept != null) {
			System.out.println("Resept lagt til");
			System.out.println(resept);
		} else {
			System.out.println("Feil under evaluering av nyresept");
		}
	}

	private void parseNyPerson(String line) {
		PersonParser parser = new PersonParser(table.personTabell);
		Person person = parser.parse(line);

		if (person != null) {
			System.out.println("Person lagt til");
			System.out.println(person);
		} else {
			System.out.println("Feil under evaluering av nyperson");
		}
	}

	private void parseNyLege(String line) {
		LegeParser parser = new LegeParser(table.sortertLegeListe);
		Lege lege = parser.parse(line);

		if (lege != null) {
			if (lege instanceof Fastlege) {
				System.out.println("Fastlege lagt til");
			} else {
				System.out.println("Lege lagt til");
			}
			System.out.println(lege);
		} else {
			System.out.println("Feil under evaluering av nylege");
		}
	}

	private void parseLegemiddel(String line) {
		LegemiddelParser parser = new LegemiddelParser(table.legemiddelTabell);
		Legemiddel legemiddel = parser.parse(line);

		if (legemiddel != null) {
			System.out.println("Legemiddel lagt til");
			System.out.println(legemiddel);
		} else {
			System.out.println("Feil under evaluering av legemiddel");
		}
	}

	private void parseDump(String line) {
		dumpData(System.out);
	}

	private void dumpData(PrintStream out) {
		out.println("# Personer (nr, navn, fnr, adresse, postnr)");

		for (Person person : table.personTabell) {
			out.println(person);
		}

		out.println();
		out.println("# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])");

		for (Legemiddel legemiddel : table.legemiddelTabell) {
			out.println(legemiddel);
		}

		out.println();
		out.println("# Leger (navn, avtalenr / 0 hvis ingen avtale)");

		for (Lege lege : table.sortertLegeListe) {
			out.println(lege);
		}

		out.println();
		out.println("# Resepter (nr, hvit/blå, persNummer, legeNavn, legemiddelNummer, reit)");

		for (Resept resept : table.yngsteForstReseptListe) {
			out.println(resept);
		}

		out.println();
		out.println("# Slutt");
	}

	private void parseSkrive(String line) throws FileNotFoundException {
		String[] splits = line.split("\\s");
		File file = new File(splits[1]);
		FileOutputStream stream = new FileOutputStream(file);
		dumpData(new PrintStream(stream));
		System.out.println("Data dumpet til: " + file.getName());
	}

	private void parseLade(String line) throws FileNotFoundException {
		String[] splits = line.split("\\s");
		File file = new File(splits[1]);
		parseFile(file);
		System.out.println("Data lastet fra: " + file.getName());
	}

	private String getInput(Scanner scanner) {
		System.out.print("> ");
		String s = scanner.nextLine();
		System.out.println();
		return s;
	}

	private void printMenyUsage() {
		System.out.println("lade - lade fra fil");
		System.out.println("skrive - skrive til fil");
		System.out.println("dump - dumpe data til skjerm");
		System.out.println("legemiddel - legemiddel param param");
		System.out.println("ny lege - nylege <navn>, <avtalenr / 0 hvis ingen avtale>");
		System.out.println("ny person - nyperson <nr>, <navn>, <fnr>, <adresse>, <postnr>");
		System.out.println("ny resept - nyresept <nr>, <hvit/blå>, <persNummer>, <legeNavn>, <legemiddelNummer>, <reit>");
		System.out.println("hent resept - hent <reseptnr>");
		System.out.println("stats - stats <{1, 5}>");
		System.out.println();
		System.out.println("hjelp");
		System.out.println("avslutt");
	}

	private void parseFile(File file) throws FileNotFoundException {
		FileParser parser = new FileParser(file, table);
		parser.parse();
	}
}
