package no.uio.inf1010.oblig6.resept;

public class ReseptNotFoundException extends RuntimeException {
    private int reseptNr;

    public ReseptNotFoundException(int reseptNr) {
        this.reseptNr = reseptNr;
    }
}
