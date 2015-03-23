package main7.parser;

import no.uio.inf1010.oblig6.collections.*;
import no.uio.inf1010.oblig6.lege.Fastlege;
import no.uio.inf1010.oblig6.lege.Lege;
import no.uio.inf1010.oblig6.legemiddel.AM;
import no.uio.inf1010.oblig6.legemiddel.BP;
import no.uio.inf1010.oblig6.legemiddel.Legemiddel;
import no.uio.inf1010.oblig6.resept.Resept;
import no.uio.inf1010.oblig6.resept.ReseptBlaa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReseptParserTest {
	private YngsteForstReseptListe yngsteForstReseptListe;
	private EldsteForstReseptListe eldsteForstReseptListe;
	private SortertEnkelListe<Lege> legeListe;
	private Tabell<Legemiddel> legemiddelTabell;

	private final String fileLine1 = "0, blå, 2, Dr. Oz, 0, 3";
	private final String fileLine2 = "1, hvit, 3, Dr. Hus, 2, 10000";

	private final String cmdLine1 = "nyresept blå, 2, Dr. Oz, 0, 3";
	private final String cmdLine2 = "nyresept hvit, 3, Dr. Hus, 2, 10000";

	private ReseptParser parser;

	private Lege lege;
	private Fastlege fastlege;

	private Legemiddel predizol;
	private Legemiddel ferdizol;

	@Before
	public void setUp() throws Exception {
		lege = new Lege("Dr. Oz");
		fastlege = new Fastlege("Dr. Hus", 43020);

		predizol = new AM(0, "Perdizol", 50, 12, 5, 19);
		ferdizol = new BP(2, "Ferdizol", 200, 18, 10, 15);

		yngsteForstReseptListe = new YngsteForstReseptListe();
		eldsteForstReseptListe = new EldsteForstReseptListe();
		legeListe = new SortertEnkelListe<>();
		legemiddelTabell = new Tabell<>(10);

		parser = new ReseptParser(yngsteForstReseptListe, eldsteForstReseptListe, legeListe, legemiddelTabell);

		legeListe.push(lege);
		legeListe.push(fastlege);

		legemiddelTabell.put(0, predizol);
		legemiddelTabell.put(2, ferdizol);
	}

	@After
	public void tearDown() throws Exception {
		yngsteForstReseptListe.clear();
		eldsteForstReseptListe.clear();
		legeListe.clear();
		legemiddelTabell.clear();
	}

	@Test
	public void testParseFromFile() throws Exception {
		Resept resept1 = parser.parse(fileLine1);
		Resept resept2 = parser.parse(fileLine2);

		assertEquals(0, resept1.getNr());
		assertTrue(resept1 instanceof ReseptBlaa);
		assertEquals(2, resept1.getPersonnr());
		assertEquals(lege, resept1.getLege());
		assertEquals(predizol, resept1.getLegemiddel());
		assertEquals(3, resept1.getReit());

		assertEquals(1, resept2.getNr());
		assertFalse(resept2 instanceof ReseptBlaa);
		assertEquals(3, resept2.getPersonnr());
		assertEquals(fastlege, resept2.getLege());
		assertEquals(ferdizol, resept2.getLegemiddel());
		assertEquals(10000, resept2.getReit());
	}
}
