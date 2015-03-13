package main7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import no.uio.inf1010.oblig6.Person;
import no.uio.inf1010.oblig6.collections.*;
import no.uio.inf1010.oblig6.lege.Lege;
import no.uio.inf1010.oblig6.legemiddel.*;
import no.uio.inf1010.oblig6.resept.*;

public class Main7 {
	public static void main (String [] args) {		
		//String fil = args[0];
		
		Scanner in = new Scanner(System.in);
		String input = "start";
		while (!input.equalsIgnoreCase("exit")) {
			meny();
			input=in.nextLine();
		}
		
		
		
		
		
	}
	
	private static void meny() {
		System.out.println("[S]kriv til fil");
		System.out.println("[U]tskrift av alle");
		System.out.println("[N]ytt Legemiddel");
		System.out.println("[L]egg til lege");
		System.out.println("[O]pprett resept");
		System.out.println("[H]ent legemiddel fra resept");
		System.out.println("[D]iverse Statistikk");
		System.out.println("[E]xit");
	}

	public void read(String fil) throws FileNotFoundException {
		File file = new File(fil); 
		Scanner scanner = new Scanner(file);
		
		Tabell<Person> persTabell = new Tabell<Person>(10);
		Tabell<Legemiddel> middelTabell = new Tabell<Legemiddel>(10);
		EldsteForstReseptListe reseptListe = new EldsteForstReseptListe();
		SortertEnkelListe<Lege> legeListe = new SortertEnkelListe<Lege>();
		EldsteForstReseptListe legeResept =new EldsteForstReseptListe();
		YngsteForstReseptListe persResept = new YngsteForstReseptListe();
		
		while (scanner.hasNextLine())  {
			String input = scanner.nextLine();
			if(input.equalsIgnoreCase("# Personer")) {
				int i = 0;
				input= scanner.nextLine();
				while(!input.startsWith("#") && input.replaceAll("\\s+","").length()>0) {
					String[] temp = input.split(",");
					persTabell.put(i, new Person(temp[1], Integer.parseInt(temp[2]),temp[3], Integer.parseInt(temp[4])));
					i++;
				}
				
			}
			if(input.equalsIgnoreCase("# Legemidler")) {
				int i = 0;
				input = scanner.nextLine();
				while(!input.startsWith("#") && input.replaceAll("\\s+","").length()>0) {
					String[] temp = input.split(",");
					if(temp[2].equalsIgnoreCase("mikstur")) {
						if(temp[3].equalsIgnoreCase("a")) {
							middelTabell.put(i, new AM(temp[1], i, i, i, i));
							i++;
						}
						if(temp[3].equalsIgnoreCase("b")) {
							
						}
						if(temp[3].equalsIgnoreCase("c")) {
	
						}
			
					}
					if(temp[2].equalsIgnoreCase("pille")) {
						
					}
				}
				
				
				
				
			}
			if(input.equalsIgnoreCase("# Leger")) {
				
				
				
				
				
			}
			if(input.equalsIgnoreCase("# Resepter")) {
				
				
				
				
				
			}
			
			if(input.equalsIgnoreCase("# Slutt")) {
				scanner.close();
			}
			
			
	
		}	
	}

}
