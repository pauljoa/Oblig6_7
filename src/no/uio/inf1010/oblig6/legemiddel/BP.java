package no.uio.inf1010.oblig6.legemiddel;

public class BP extends Legemiddel implements Piller {
    protected int vane;
    protected int mengde;
    protected double perEnhet;

    public BP(String navn, double virkestoff, int pris, int vane, int mengde) {
        super(navn, virkestoff, pris);
        this.vane = vane;
        this.mengde = mengde;

        perEnhet = virkestoff / mengde;
    }

    @Override
    public int mengde() {
        return mengde;
    }

    @Override
    public double perEnhet() {
        return perEnhet;
    }

    public int vane() {
        return vane;
    }
}
