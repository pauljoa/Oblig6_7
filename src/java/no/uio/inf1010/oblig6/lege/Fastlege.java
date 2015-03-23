package no.uio.inf1010.oblig6.lege;

public class Fastlege extends Lege implements Avtale {
    protected int avtalenr;

    public Fastlege(String navn, int avtalenr) {
        super(navn);
        this.avtalenr = avtalenr;
    }

    @Override
    public int avnr() {
        return avtalenr;
    }

	@Override
	public String toString() {
		return String.format("%s, %d", navn, avtalenr);
	}
}
