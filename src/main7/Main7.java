package main7;

import main7.parser.FileParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main7 {
	private Table table = new Table();

	public Main7(File file) {
		if (file.exists()) {
			FileParser parser = new FileParser(file, table);
			parser.parse();
		} else {
			meny();
		}
	}

	private void meny() {
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		new Main7(file);
	}

	private static void parseFile(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);

		while (scanner.hasNext()) {
			String line = scanner.nextLine();


		}
	}

	private static void usage() {
		System.out.println("Main7 <filnavn>");
	}
}
