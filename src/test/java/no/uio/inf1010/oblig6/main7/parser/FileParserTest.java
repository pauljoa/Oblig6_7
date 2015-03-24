package no.uio.inf1010.oblig6.main7.parser;

import no.uio.inf1010.oblig6.main7.Table;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class FileParserTest {

	private final InputStream stream = ClassLoader.getSystemResourceAsStream("data.txt");

	private Table table;
	private FileParser parser;

	@Before
	public void setUp() throws Exception {
		table = new Table();
		parser = new FileParser(stream, table);
	}

	@Test
	public void testParse() throws Exception {
		parser.parse();
	}
}
