package no.uio.inf1010.oblig6.legemiddel;

public class CP extends Legemiddel implements Piller {

    protected int mengde;
    protected double perEnhet;

    public CP(String navn, double virkestoff, int pris, int mengde) {
        super(navn, virkestoff, pris);
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

}
