package no.uio.inf1010.oblig6.main7;

import no.uio.inf1010.oblig6.Person;
import no.uio.inf1010.oblig6.collections.*;
import no.uio.inf1010.oblig6.lege.Lege;
import no.uio.inf1010.oblig6.legemiddel.Legemiddel;

public class Table {
	public EldsteForstReseptListe eldsteForstReseptListe;
	public YngsteForstReseptListe yngsteForstReseptListe;
	public SortertEnkelListe<Lege> sortertLegeListe;
	public Tabell<Person> personTabell;
	public Tabell<Legemiddel> legemiddelTabell;

	public Table() {
		eldsteForstReseptListe = new EldsteForstReseptListe();
		yngsteForstReseptListe = new YngsteForstReseptListe();
		sortertLegeListe = new SortertEnkelListe<>();
		personTabell = new Tabell<>(10);
		legemiddelTabell = new Tabell<>(10);
	}
}
