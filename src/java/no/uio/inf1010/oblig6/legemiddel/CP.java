package no.uio.inf1010.oblig6.legemiddel;

public class CP extends Legemiddel implements Piller {

    protected int mengde;
    protected double perEnhet;

	public CP(int nr, String navn, int pris, int mengde, double virkestoff) {
        super(nr, navn, pris, virkestoff);
        this.mengde = mengde;

        perEnhet = virkestoff / mengde;
    }

    @Override
    public int mengde() {
        return this.mengde;
    }

    @Override
    public double perEnhet() {
        return this.perEnhet;
    }

    @Override
    public String toString() {
        return "CP{" +
                "volum=" + mengde +
                ", perEnhet=" + perEnhet +
                '}';
    }
}
