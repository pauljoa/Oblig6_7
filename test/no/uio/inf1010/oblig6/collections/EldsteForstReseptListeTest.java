package no.uio.inf1010.oblig6.collections;

import no.uio.inf1010.oblig6.lege.Lege;
import no.uio.inf1010.oblig6.legemiddel.AM;
import no.uio.inf1010.oblig6.legemiddel.BP;
import no.uio.inf1010.oblig6.legemiddel.CP;
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
    private Legemiddel legemiddel3;
    private Resept resept1;
    private Resept resept2;
    private Resept resept3;

    private EldsteForstReseptListe liste;

    @Before
    public void setUp() throws Exception {
        lege = new Lege("bert");
        legemiddel1 = new AM("americanum", 1, 1, 1, 1);
        legemiddel2 = new BP("bortrorium", 2, 2, 2, 2);
        legemiddel3 = new CP("centrolium", 3, 3, 3);
        resept1 = new Resept(1, 1, lege, legemiddel1);
        resept2 = new Resept(2, 2, lege, legemiddel2);
        resept3 = new Resept(3, 3, lege, legemiddel3);

        liste = new EldsteForstReseptListe();
        liste.push(resept1);
        liste.push(resept2);
        liste.push(resept3);
    }

    @Test
    public void testPush() throws Exception {
        assertEquals(3, liste.size());
        liste.push(new Resept(1, 2, lege, legemiddel1));
        assertEquals(4, liste.size());
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(resept1, liste.get(resept1.getNr()));
        assertEquals(resept2, liste.get(resept2.getNr()));
        assertEquals(resept3, liste.get(resept3.getNr()));
    }

    @Test
    public void testIterator() throws Exception {
        Iterator<Resept> iterator = liste.iterator();

        assertEquals(resept3, iterator.next());
        assertEquals(resept2, iterator.next());
        assertEquals(resept1, iterator.next());
    }
}