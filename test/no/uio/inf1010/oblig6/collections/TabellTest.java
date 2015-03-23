package no.uio.inf1010.oblig6.collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TabellTest {

	private Tabell<String> tabell;

	@Before
	public void setUp() throws Exception {
		tabell = new Tabell<>(10);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testIterator() throws Exception {
		tabell.put(0, "hei");
		tabell.put(1, "nei");

		assertEquals(2, tabell.size());

		int counter = 0;
		for (String s : tabell) {
			counter++;
		}

		assertEquals(2, counter);
	}

	@Test
	public void testPut() throws Exception {

	}

	@Test
	public void testGet() throws Exception {

	}

	@Test
	public void testClear() throws Exception {

	}
}
