package no.uio.inf1010.oblig6.legemiddel;

public class AP extends Legemiddel implements Piller {
    protected int styrke;
    protected int mengde;
    protected double perEnhet;

    public AP(String navn, int pris, int mengde, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
        this.mengde = mengde;

        perEnhet = virkestoff / this.mengde;
    }

	public AP(int nr, String navn, int pris, int mengde, double virkestoff, int styrke) {
		super(nr, navn, pris, virkestoff);
		this.styrke = styrke;
		this.mengde = mengde;

		perEnhet = virkestoff / this.mengde;
	}

    @Override
    public int mengde() {
        return mengde;
    }

    @Override
    public double perEnhet() {
        return perEnhet;
    }

    public int nark() {
        return styrke;
    }

    @Override
    public String toString() {
        return "AP{" +
                "styrke=" + styrke +
                ", antall=" + mengde +
                ", perEnhet=" + perEnhet +
                '}';
    }
}
