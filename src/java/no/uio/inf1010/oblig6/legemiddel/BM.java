package no.uio.inf1010.oblig6.legemiddel;

public class BM extends Legemiddel implements Mikstur {
    protected int vane;
    protected double volum;
    protected double perCm3;

	public BM(String navn, int pris, double volum, double virkestoff, int vane) {
        super(navn, pris, virkestoff);
        this.vane = vane;
        this.volum = volum;

        perCm3 = virkestoff / volum;
    }

	public BM(int nr, String navn, int pris, double volum, double virkestoff, int vane) {
		super(nr, navn, pris, virkestoff);
		this.vane = vane;
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

    public int vane() {
        return vane;
    }

    @Override
    public String toString() {
        return "BM{" +
                "vane=" + vane +
                ", volum=" + volum +
                ", perCm3=" + perCm3 +
                '}';
    }
}
