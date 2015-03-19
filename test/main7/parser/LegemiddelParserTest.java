package main7.parser;

import no.uio.inf1010.oblig6.collections.Tabell;
import no.uio.inf1010.oblig6.legemiddel.Legemiddel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LegemiddelParserTest {

	private final String fileLine1 = "0, Predizol, mikstur, a, 450, 50, 75, 8";
	private final String fileLine2 = "1, Paralgin Forte, pille, b, 65, 10, 400, 5";

	private final String cmdLine1 = "0, Predizol, mikstur, a, 450, 50, 75, 8";
	private final String cmdLine2 = "1, Paralgin Forte, pille, b, 65, 10, 400, 5";

	private Tabell<Legemiddel> tabell;
	private LegemiddelParser parser;

	@Before
	public void setUp() throws Exception {
		tabell = new Tabell<>(10);
		parser = new LegemiddelParser(tabell);
	}

	@After
	public void tearDown() throws Exception {
		Legemiddel.resetTeller();
	}

	@Test
	public void testParseFile() throws Exception {

	}
}
