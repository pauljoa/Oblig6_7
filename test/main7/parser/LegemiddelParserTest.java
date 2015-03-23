package main7.parser;

import no.uio.inf1010.oblig6.Person;
import no.uio.inf1010.oblig6.collections.Tabell;
import no.uio.inf1010.oblig6.legemiddel.AM;
import no.uio.inf1010.oblig6.legemiddel.BP;
import no.uio.inf1010.oblig6.legemiddel.CP;
import no.uio.inf1010.oblig6.legemiddel.Legemiddel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LegemiddelParserTest {

	private final String fileLineAM = "0, Predizol, mikstur, a, 450, 50, 75, 8";
	private final String fileLineBP = "1, Paralgin Forte, pille, b, 65, 10, 400, 5";
	private final String fileLineCP = "2, Placebo Pianissimo, pille, c, 10, 1000, 0";

	private final String cmdLineAM = "legemiddel Predizol, mikstur, a, 450, 50, 75, 8";
	private final String cmdLineBP = "legemiddel Paralgin Forte, pille, b, 65, 10, 400, 5";
	private final String cmdLineCP = "legemiddel Placebo Pianissimo, pille, c, 10, 1000, 0";

	private Tabell<Legemiddel> tabell;
	private LegemiddelParser parser;

	@Before
	public void setUp() throws Exception {
		tabell = new Tabell<>(10);
		parser = new LegemiddelParser(tabell);
	}

	@Test
	public void testParseFile() throws Exception {
		AM am = (AM) parser.parse(fileLineAM);
		BP bp = (BP) parser.parse(fileLineBP);
		CP cp = (CP) parser.parse(fileLineCP);

		assertNotNull(am);
		assertNotNull(bp);
		assertNotNull(cp);

		assertEquals(0, am.getNr());
		assertEquals("Predizol", am.getNavn());
		assertEquals(450, am.getPris());
		assertEquals(50, am.volum(), 0.001);
		assertEquals(75, am.getVirkestoff(), 0.001);
		assertEquals(8, am.nark());
	}

	@Test
	public void testParseCmd() throws Exception {
		AM am = (AM) parser.parse(cmdLineAM);
		BP bp = (BP) parser.parse(cmdLineBP);
		CP cp = (CP) parser.parse(cmdLineCP);

		assertNotNull(am);
		assertNotNull(bp);
		assertNotNull(cp);

		assertEquals(0, am.getNr());
		assertEquals("Predizol", am.getNavn());
		assertEquals(450, am.getPris());
		assertEquals(50, am.volum(), 0.001);
		assertEquals(75, am.getVirkestoff(), 0.001);
		assertEquals(8, am.nark());
	}
}
