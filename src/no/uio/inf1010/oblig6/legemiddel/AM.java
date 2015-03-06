package no.uio.inf1010.oblig6.legemiddel;

public class AM extends Legemiddel implements Mikstur {
    protected double volum;
    protected double perCm3;
    protected int narkotisk;

    public AM(String navn, double virkestoff, int pris, double volum, int narkotisk) {
        super(navn, virkestoff, pris);
        this.volum = volum;
        this.narkotisk = narkotisk;

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
}
