package no.uio.inf1010.oblig6.legemiddel;

public abstract class Legemiddel {
    protected String navn;
    protected double virkestoff;
    protected int pris;
    protected int unik;

	public Legemiddel(int unik, String navn, int pris, double virkestoff) {
		this.unik = unik;
		this.navn = navn;
		this.pris = pris;
		this.virkestoff = virkestoff;

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
