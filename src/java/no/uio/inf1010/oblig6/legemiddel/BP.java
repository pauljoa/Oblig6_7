package no.uio.inf1010.oblig6.legemiddel;

public class BP extends Legemiddel implements Piller {
	protected int vane;
	protected int antall;
	protected double perEnhet;

	public BP(int nr, String navn, int pris, int antall, double virkestoff, int vane) {
		super(nr, navn, pris, virkestoff);
		this.antall = antall;
		this.vane = vane;

		perEnhet = virkestoff / this.antall;
	}

	@Override
	public int mengde() {
		return antall;
	}

	@Override
	public double perEnhet() {
		return perEnhet;
	}

	public int vane() {
		return vane;
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %s, %s, %d, %d, %f, %d", unik, navn, Piller.DESCRPTION, "b", pris, antall, virkestoff, vane);
	}
}
