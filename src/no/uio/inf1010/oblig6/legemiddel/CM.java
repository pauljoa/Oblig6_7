package no.uio.inf1010.oblig6.legemiddel;

public class CM extends Legemiddel implements Mikstur {

    protected double volum;
    protected double perCm3;

    public CM(String navn, double virkestoff, int pris, double volum) {
        super(navn, virkestoff, pris);
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

}
