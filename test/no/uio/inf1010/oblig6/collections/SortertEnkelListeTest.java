package no.uio.inf1010.oblig6.collections;

import no.uio.inf1010.oblig6.lege.Lege;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SortertEnkelListeTest {

    private SortertEnkelListe<Lege> liste;

    private Lege paul = new Lege("Paul");
    private Lege steffen = new Lege("Steffen");
    private Lege mikael = new Lege("mikael");
    private Lege nikolai = new Lege("nikolai");
    private Lege anette = new Lege("anette");
    private Lege henrik = new Lege("henrik");

    @Before
    public void setUp() throws Exception {
        liste = new SortertEnkelListe<>();
        liste.push(paul);
        liste.push(steffen);
        liste.push(mikael);
        liste.push(nikolai);
        liste.push(anette);
    }

    @Test
    public void testIterator() throws Exception {
        Iterator<Lege> iterator = liste.iterator();

        assertSame(anette, iterator.next());
        assertSame(mikael, iterator.next());
        assertSame(nikolai, iterator.next());
        assertSame(paul, iterator.next());
        assertSame(steffen, iterator.next());
    }

    @Test
    public void testPush() throws Exception {
        assertEquals(5, liste.size());
        liste.push(henrik);
        assertEquals(6, liste.size());
    }

    @Test
    public void testGet() throws Exception {

    }
}