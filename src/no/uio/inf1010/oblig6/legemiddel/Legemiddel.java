package no.uio.inf1010.oblig6.legemiddel;

public abstract class Legemiddel {
    private static int teller = 0;

    protected String navn;
    protected double virkestoff;
    protected int pris;
    protected int unik;

    public Legemiddel(String navn, int pris, double virkestoff) {
        this.navn = navn;
        this.pris = pris;
		this.virkestoff = virkestoff;

        unik = teller;
        teller++;
    }

	public Legemiddel(int nr, String navn, int pris, double virkestoff) {
		this.navn = navn;
		this.pris = pris;
		this.virkestoff = virkestoff;

		teller = nr;
		unik = teller;
		teller++;
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

	public static void resetTeller() {
		teller = 0;
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
