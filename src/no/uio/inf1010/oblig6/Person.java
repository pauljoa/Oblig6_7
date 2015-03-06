package no.uio.inf1010.oblig6;

public class Person {
    private static int nr;

    private int unik;
    private String navn;
    private int persNr;

    private String adresse;
    private int postnr;

    Person(String navn, int persNr, String adr, int vnr, int postnr) {
        this.navn = navn;
        this.persNr = persNr;
        this.adresse = adr + " " + vnr;
        this.postnr = postnr;

        unik = nr;
        nr++;
    }

    public static int getNr() {
        return nr;
    }

    public int getUnik() {
        return unik;
    }

    public String getNavn() {
        return navn;
    }

    public int getPersNr() {
        return persNr;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getPostnr() {
        return postnr;
    }
}
