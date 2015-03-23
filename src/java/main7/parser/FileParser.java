package main7.parser;

import main7.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {

	private final File file;
	private final Table table;

	private ModeParser modeParser;
	private PersonParser personParser;
	private LegemiddelParser legemiddelParser;
	private LegeParser legeParser;
	private ReseptParser reseptParser;

	private Modes mode;

	public FileParser(File file, Table table) {
		this.file = file;
		this.table = table;

		modeParser = new ModeParser();
		personParser = new PersonParser(table.personTabell);
		legemiddelParser = new LegemiddelParser(table.legemiddelTabell);
		legeParser = new LegeParser(table.sortertLegeListe);
		reseptParser = new ReseptParser(table.yngsteForstReseptListe, table.eldsteForstReseptListe, table.sortertLegeListe, table.legemiddelTabell);
		mode = null;
	}


	public void parse() throws FileNotFoundException {
		Scanner scanner = new Scanner(file);

		while (scanner.hasNext()) {
			String line = scanner.nextLine();

			if (line.startsWith("#")) {
				Modes mode = modeParser.parse(line);

				if (mode != null) {
					this.mode = mode;
				}
			} else {
				if (mode == null) {
					throw new IllegalStateException("Feil under parsing av fil, ingen 'mode' satt");
				} else if (mode == Modes.PERSONER) {
					personParser.parse(line);
				} else if (mode == Modes.LEGEMIDLER) {
					legemiddelParser.parse(line);
				} else if (mode == Modes.LEGER) {
					legeParser.parse(line);
				} else if (mode == Modes.RESEPTER) {
					reseptParser.parse(line);
				}
			}
		}
	}
}
