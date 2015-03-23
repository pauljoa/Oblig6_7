package no.uio.inf1010.oblig6.legemiddel;

public class AM extends Legemiddel implements Mikstur {
    protected double volum;
    protected double perCm3;
    protected int narkotisk;

	public AM(String navn, int pris, double volum, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.volum = volum;
        this.narkotisk = styrke;

        perCm3 = virkestoff / volum;
    }

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
        return "AM{" +
                "volum=" + volum +
                ", perCm3=" + perCm3 +
                ", styrke=" + narkotisk +
                '}';
    }
}