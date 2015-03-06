package no.uio.inf1010.oblig6.lege;

import no.uio.inf1010.oblig6.Lik;

public class Lege implements Lik {
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
}
