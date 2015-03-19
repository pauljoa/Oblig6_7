package main7;

import no.uio.inf1010.oblig6.Person;
import no.uio.inf1010.oblig6.collections.*;
import no.uio.inf1010.oblig6.legemiddel.Legemiddel;

public class Table {
	public EldsteForstReseptListe eldsteForstReseptListe;
	public YngsteForstReseptListe yngsteForstReseptListe;
	public EnkelReseptListe enkelReseptListe;
	public SortertEnkelListe sortertEnkelListe;
	public Tabell<Person> personTabell;
	public Tabell<Legemiddel> legemiddelTabell;

	public Table() {
		eldsteForstReseptListe = new EldsteForstReseptListe();
		yngsteForstReseptListe = new YngsteForstReseptListe();
		enkelReseptListe = new EldsteForstReseptListe();
		sortertEnkelListe = new SortertEnkelListe();
		personTabell = new Tabell<>(10);
		legemiddelTabell = new Tabell<>(10);
	}
}
