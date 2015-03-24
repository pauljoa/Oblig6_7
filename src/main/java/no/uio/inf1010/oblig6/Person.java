package no.uio.inf1010.oblig6;

public class Person {
    private static int teller;

    private int unik;
    private String navn;
    private String fodselsnr;

    private String adresse;
    private String postnr;

    public Person(String navn, String fodselsnr, String adr, String postnr) {
        this.navn = navn;
        this.fodselsnr = fodselsnr;
        this.adresse = adr;
        this.postnr = postnr;

        unik = teller;
        teller++;
    }

	public Person(int unikid, String navn, String fodselsnr, String adr, String postnr) {
		this.navn = navn;
		this.fodselsnr = fodselsnr;
		this.adresse = adr;
		this.postnr = postnr;

		teller = unikid;
		unik = teller;
		teller++;
	}

    public static int getTeller() {
        return teller;
    }

    public int getUnik() {
        return unik;
    }

	public static void resetTeller() {
		teller = 0;
	}


	public String getNavn() {
        return navn;
    }

    public String getFodselsnr() {
        return fodselsnr;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPostnr() {
        return postnr;
    }

	@Override
	public String toString() {
		return String.format("%d, %s, %s, %s, %s", unik, navn, fodselsnr, adresse, postnr);
	}
}
