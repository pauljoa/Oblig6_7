package no.uio.inf1010.oblig6.legemiddel;

public class CM extends Legemiddel implements Mikstur {

    protected double volum;
    protected double perCm3;

	public CM(String navn, int pris, double volum, double virkestoff) {
		super(navn, pris, virkestoff);
		this.volum = volum;

		perCm3 = virkestoff / volum;
	}

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
        return "CM{" +
                "volum=" + volum +
                ", perCm3=" + perCm3 +
                '}';
    }
}
