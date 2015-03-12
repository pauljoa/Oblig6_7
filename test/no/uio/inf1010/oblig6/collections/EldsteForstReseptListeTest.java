package no.uio.inf1010.oblig6.collections;

import no.uio.inf1010.oblig6.lege.Lege;
import no.uio.inf1010.oblig6.legemiddel.AM;
import no.uio.inf1010.oblig6.legemiddel.Legemiddel;
import no.uio.inf1010.oblig6.resept.Resept;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class EldsteForstReseptListeTest {

    private Lege lege;
    private Legemiddel legemiddel1;
    private Legemiddel legemiddel2;
    private Resept resept1;
    private Resept resept2;
    private int resptnr1;
    private int resptnr2;

    private EldsteForstReseptListe liste;

    @Before
    public void setUp() throws Exception {
        lege = new Lege("bert");
        legemiddel1 = new AM("dispril", 2, 2, 2, 2);
        legemiddel2 = new AM("parasett", 3, 3, 3, 3);
        resept1 = new Resept(1, 2, lege, legemiddel1);
        resept2 = new Resept(3, 4, lege, legemiddel2);
        resptnr1 = resept1.getNr();
        resptnr2 = resept2.getNr();

        liste = new EldsteForstReseptListe();
        liste.push(resept1);
        liste.push(resept2);
    }

    @Test
    public void testPush() throws Exception {
        assertEquals(2, liste.size());
        liste.push(new Resept(1, 2, lege, legemiddel1));
        assertEquals(3, liste.size());
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(resept1, liste.get(resptnr1));
        assertEquals(resept2, liste.get(resptnr2));
    }

    @Test
    public void testIterator() throws Exception {
        Iterator<Resept> iterator = liste.iterator();

        assertEquals(resept1, iterator.next());
        assertEquals(resept2, iterator.next());
    }
}