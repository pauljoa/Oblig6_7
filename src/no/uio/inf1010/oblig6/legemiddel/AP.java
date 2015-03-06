package no.uio.inf1010.oblig6.legemiddel;

public class AP extends Legemiddel implements Piller {
    protected int narkotisk;
    protected int mengde;
    protected double perEnhet;


    public AP(String navn, double virkestoff, int pris, int narkotisk, int mengde) {
        super(navn, virkestoff, pris);
        this.narkotisk = narkotisk;
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

    public int nark() {
        return narkotisk;
    }
}
