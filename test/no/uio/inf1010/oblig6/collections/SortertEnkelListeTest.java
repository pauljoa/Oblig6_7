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

    @Before
    public void setUp() throws Exception {
        liste = new SortertEnkelListe<>();
        liste.push(paul);
        liste.push(steffen);
//        liste.push(mikael);
//        liste.push(nikolai);
    }

    @Test
    public void testIterator() throws Exception {
        for (Lege lege : liste) {
            System.out.println(".......");
            System.out.println(lege);
        }

        Iterator<Lege> iterator = liste.iterator();

        assertSame(paul, iterator.next());
        assertSame(steffen, iterator.next());

    }

    @Test
    public void testPush() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testSort() throws Exception {

    }
}