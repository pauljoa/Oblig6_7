package no.uio.inf1010.oblig6.legemiddel;

public class BM extends Legemiddel implements Mikstur {
    protected int vane;
    protected double volum;
    protected double perCm3;

    public BM(String navn, double virkestoff, int pris, int vane, double volum) {
        super(navn, virkestoff, pris);
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

}
