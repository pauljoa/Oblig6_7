package no.uio.inf1010.oblig6.lege;

import no.uio.inf1010.oblig6.Lik;
import no.uio.inf1010.oblig6.legemiddel.Mikstur;

public class Lege implements Lik, Comparable<Lege> {
    protected String navn;

    public Lege(String navn) {
        this.navn = navn;
    }

    @Override
    public boolean samme(String s) {
        return navn.equalsIgnoreCase(s);
    }

    public String navn() {
        return navn;
    }

    @Override
    public int compareTo(Lege o) {
        return navn.compareToIgnoreCase(o.navn);
    }

    @Override
    public String toString() {
		return String.format("%s, %d", navn, 0);
    }
}
