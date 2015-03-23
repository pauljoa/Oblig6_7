package main7.parser;

import no.uio.inf1010.oblig6.Person;
import no.uio.inf1010.oblig6.collections.SortertEnkelListe;
import no.uio.inf1010.oblig6.collections.Tabell;
import no.uio.inf1010.oblig6.lege.Fastlege;
import no.uio.inf1010.oblig6.lege.Lege;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LegeParserTest {

	private final String fileLine1 = "Dr. Dre, 0";
	private final String fileLine2 = "Dr. Hus, 63634";

	private final String cmdLine1 = "nylege Dr. Dre, 0";
	private final String cmdLine2 = "nylege Dr. Hus, 63634";

	private SortertEnkelListe<Lege> liste;
	private LegeParser parser;

	@Before
	public void setUp() throws Exception {
		liste = new SortertEnkelListe<>();
		parser = new LegeParser(liste);
	}

	@After
	public void tearDown() throws Exception {
		liste.clear();
	}

	@Test
	public void testParseFromFile() throws Exception {
		Lege lege1 = parser.parse(fileLine1);
		Lege lege2 = parser.parse(fileLine2);

		assertEquals(lege1.navn(), "Dr. Dre");

		assertEquals(lege2.navn(), "Dr. Hus");
		assertTrue(lege2 instanceof Fastlege);
		assertEquals(((Fastlege)lege2).avnr(), 63634);
	}

	@Test
	public void testParseFromCMD() throws Exception {
		Lege lege1 = parser.parse(cmdLine1);
		Lege lege2 = parser.parse(cmdLine2);

		assertEquals(lege1.navn(), "Dr. Dre");

		assertEquals(lege2.navn(), "Dr. Hus");
		assertTrue(lege2 instanceof Fastlege);
		assertEquals(((Fastlege)lege2).avnr(), 63634);
	}
}
