package no.uio.inf1010.oblig6.resept;

import no.uio.inf1010.oblig6.lege.Lege;
import no.uio.inf1010.oblig6.legemiddel.Legemiddel;

public class ReseptBlaa extends Resept {

    public ReseptBlaa(int personnr, int reit, Lege lege, Legemiddel legemiddel) {
        super(personnr, reit, lege, legemiddel);
    }

	public ReseptBlaa(int nr, int personnr, int reit, Lege lege, Legemiddel legemiddel) {
		super(nr, personnr, reit, lege, legemiddel);
	}

	@Override
	public int getPris() {
		return 0;
	}

	@Override
    public String toString() {
		return String.format("%d, %s, %d, %s, %d, %d", unikNr, "blå", personnr, lege.navn(), legemiddel.getNr(), reit);
	}
}
