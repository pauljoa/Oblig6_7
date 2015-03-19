package no.uio.inf1010.oblig6;

public class Person {
    private static int teller;

    private int unik;
    private String navn;
    private int fodselsnr;

    private String adresse;
    private int postnr;

    public Person(String navn, int fodselsnr, String adr, int postnr) {
        this.navn = navn;
        this.fodselsnr = fodselsnr;
        this.adresse = adr;
        this.postnr = postnr;

        unik = teller;
        teller++;
    }

	public Person(int unikid, String navn, int fodselsnr, String adr, int postnr) {
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

    public String getNavn() {
        return navn;
    }

    public int getFodselsnr() {
        return fodselsnr;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getPostnr() {
        return postnr;
    }
}
