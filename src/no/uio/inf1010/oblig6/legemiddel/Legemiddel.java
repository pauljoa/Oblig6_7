package no.uio.inf1010.oblig6.legemiddel;

public abstract class Legemiddel {
    private static int nr = 0;

    protected String navn;
    protected double virkestoff;
    protected int pris;
    protected int unik;

    public Legemiddel(String navn, double virkestoff, int pris) {
        this.navn = navn;
        this.virkestoff = virkestoff;
        this.pris = pris;

        unik = nr;
        nr++;
    }

    public String getNavn() {
        return navn;
    }

    public double getVirkestoff() {
        return virkestoff;
    }

    public int getPris() {
        return pris;
    }

    public int getNr() {
        return unik;
    }

    @Override
    public String toString() {
        return "Legemiddel{" +
                "navn='" + navn + '\'' +
                ", virkestoff=" + virkestoff +
                ", pris=" + pris +
                ", unik=" + unik +
                '}';
    }
}