package no.uio.inf1010.oblig6.legemiddel;

public class CM extends Legemiddel implements Mikstur {

    protected double volum;
    protected double perCm3;

	public CM(int nr, String navn, int pris, double volum, double virkestoff) {
		super(nr, navn, pris, virkestoff);
		this.volum = volum;

		perCm3 = virkestoff / volum;
	}

    @Override
    public double volum() {
        return volum;
    }

    @Override
    public double perCm3() {
        return perCm3;
    }

    @Override
    public String toString() {
		return String.format("%d, %s, %s, %s, %d, %f, %f", unik, navn, Mikstur.DESCRPTION, "c", pris, volum, virkestoff);
	}
}
