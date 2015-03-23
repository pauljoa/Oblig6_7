package no.uio.inf1010.oblig6.legemiddel;

public class AM extends Legemiddel implements Mikstur {
    protected double volum;
    protected double perCm3;
    protected int narkotisk;

	public AM(int nr, String navn, int pris, double volum, double virkestoff, int styrke) {
		super(nr, navn, pris, virkestoff);
		this.volum = volum;
		this.narkotisk = styrke;

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

    public int nark() {
        return narkotisk;
    }

	@Override
	public String toString() {
		return String.format("%d, %s, %s, %s, %d, %f, %f, %d", unik, navn, Mikstur.DESCRPTION, "a", pris, volum, virkestoff, narkotisk);
	}
}
