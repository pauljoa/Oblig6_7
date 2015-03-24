package main7;

import main7.parser.*;
import no.uio.inf1010.oblig6.Person;
import no.uio.inf1010.oblig6.lege.Fastlege;
import no.uio.inf1010.oblig6.lege.Lege;
import no.uio.inf1010.oblig6.legemiddel.Legemiddel;
import no.uio.inf1010.oblig6.resept.Resept;

import java.io.*;
import java.util.Scanner;

public class Main7 {
	private Table table = new Table();

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		new Main7(file);
	}

	public Main7(File file) throws FileNotFoundException {
		if (file.exists()) {
			parseFile(file);
			System.out.println("Data lastet fra: " + file.getName());
		}

		meny();
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
			} else if (line.startsWith("hentresept")) {
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

	}

	private void parseHentResept(String line) {

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
		System.out.println("nylege - nylege <navn>, <avtalenr / 0 hvis ingen avtale>");
		System.out.println("nyperson - nyperson <nr>, <navn>, <fnr>, <adresse>, <postnr>");
		System.out.println("nyresept - nyresept param param");
		System.out.println("hentresept - hentresept param param");
		System.out.println("stats - stats param param");
		System.out.println();
		System.out.println("hjelp");
		System.out.println("avslutt");
	}

	private void parseFile(File file) throws FileNotFoundException {
		FileParser parser = new FileParser(file, table);
		parser.parse();
	}

	private static void usage() {
		System.out.println("Main7 <filnavn>");
	}
}
