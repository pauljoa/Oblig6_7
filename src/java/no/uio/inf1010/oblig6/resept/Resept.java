package no.uio.inf1010.oblig6.resept;

import no.uio.inf1010.oblig6.lege.Lege;
import no.uio.inf1010.oblig6.legemiddel.Legemiddel;

public class Resept {
    private static int unikTeller = 0;

    protected int unikNr;
    protected Legemiddel legemiddel;
    protected Lege lege;
    protected int reit;
    protected int personnr;

    public Resept(int personnr, int reit, Lege lege, Legemiddel legemiddel) {
        this.personnr = personnr;
        this.reit = reit;
        this.lege = lege;
        this.legemiddel = legemiddel;

        unikNr = unikTeller;
        unikTeller++;
    }

	public Resept(int nr, int personnr, int reit, Lege lege, Legemiddel legemiddel) {
		unikNr = nr;
		this.personnr = personnr;
		this.reit = reit;
		this.lege = lege;
		this.legemiddel = legemiddel;

		if (nr > unikTeller) {
			unikTeller = nr;
		}
		unikTeller++;
	}

	public int getNr() {
        return unikNr;
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

    @Override
    public String toString() {
        return "Resept{" +
                "unikNr=" + unikNr +
                ", legemiddel=" + legemiddel +
                ", lege=" + lege +
                ", reit=" + reit +
                ", personnr=" + personnr +
                '}';
    }
}
