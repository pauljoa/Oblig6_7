package no.uio.inf1010.oblig6.resept;

import no.uio.inf1010.oblig6.lege.Lege;
import no.uio.inf1010.oblig6.legemiddel.Legemiddel;

public class Resept {
    static int nr = 0;

    protected int unik;
    protected Legemiddel legemiddel;
    protected Lege lege;
    protected int reit;
    protected int personnr;

    public Resept(int personnr, int reit, Lege lege, Legemiddel legemiddel) {
        this.personnr = personnr;
        this.reit = reit;
        this.lege = lege;
        this.legemiddel = legemiddel;

        unik = nr;
        nr++;
    }

    public int getNr() {
        return unik;
    }

    public Legemiddel getLegemiddel() {
        return legemiddel;
    }

    public Lege getLege() {
        return lege;
    }

    public int getReit() {
        return reit;
    }

    public int getPersonnr() {
        return personnr;
    }

}
