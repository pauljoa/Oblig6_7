package no.uio.inf1010.oblig6.main7.parser;

import no.uio.inf1010.oblig6.Person;
import no.uio.inf1010.oblig6.collections.Tabell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonParserTest {

	private final String fileLine1 = "0, Jens Hans Olsen, 11111143521, Veigata 9, 4523";
	private final String fileLine2 = "1, Petrolina Swiq, 24120099343, Pillestedet 49, 0789";

	private final String cmdLine1 = "nyperson Jens Hans Olsen, 11111143521, Veigata 9, 4523";
	private final String cmdLine2 = "nyperson Petrolina Swiq, 24120099343, Pillestedet 49, 0789";

	private Tabell<Person> tabell;
	private PersonParser parser;

	@Before
	public void setUp() throws Exception {
		tabell = new Tabell<>(10);
		parser = new PersonParser(tabell);
	}

	@After
	public void tearDown() throws Exception {
		Person.resetTeller();
	}

	@Test
	public void testParseFromFile() throws Exception {
		Person person1 = parser.parse(fileLine1);
		Person person2 = parser.parse(fileLine2);

		assertEquals(person1.getUnik(), 0);
		assertEquals(person1.getNavn(), "Jens Hans Olsen");
		assertEquals(person1.getFodselsnr(), "11111143521");
		assertEquals(person1.getAdresse(), "Veigata 9");
		assertEquals(person1.getPostnr(), "4523");

		assertEquals(person2.getUnik(), 1);
		assertEquals(person2.getNavn(), "Petrolina Swiq");
		assertEquals(person2.getFodselsnr(), "24120099343");
		assertEquals(person2.getAdresse(), "Pillestedet 49");
		assertEquals(person2.getPostnr(), "0789");
	}

	@Test
	public void testParseFromCMD() throws Exception {
		Person person1 = parser.parse(cmdLine1);
		Person person2 = parser.parse(cmdLine2);

		assertEquals(person1.getUnik(), 0);
		assertEquals(person1.getNavn(), "Jens Hans Olsen");
		assertEquals(person1.getFodselsnr(), "11111143521");
		assertEquals(person1.getAdresse(), "Veigata 9");
		assertEquals(person1.getPostnr(), "4523");

		assertEquals(person2.getUnik(), 1);
		assertEquals(person2.getNavn(), "Petrolina Swiq");
		assertEquals(person2.getFodselsnr(), "24120099343");
		assertEquals(person2.getAdresse(), "Pillestedet 49");
		assertEquals(person2.getPostnr(), "0789");
	}

	@Test
	public void testParseFromFileEmptyLine() throws Exception {
		Person p = parser.parse("");

		assertNull(p);
	}

	@Test
	public void testUniqueNumbering() throws Exception {
		Person person1 = parser.parse("0, Jens Hans Olsen, 11111143521, Veigata 9, 4523");
		Person person2 = parser.parse("10, Petrolina Swiq, 24120099343, Pillestedet 49, 0789");
		Person person3 = parser.parse("nyperson  Sven Svendsen, 10111224244, Storgata 67, 5341");

		assertEquals(11, person3.getUnik());
	}
}
