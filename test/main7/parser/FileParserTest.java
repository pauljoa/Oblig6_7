package main7.parser;

import main7.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

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
