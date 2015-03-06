
public class Person {
	String navn;
	int persNr;
	String adresse;
	static int nr;
	protected int unik;
	Person(String n,int p,String adr,int vnr,int post) {
		this.navn=n;
		this.persNr=p;
		this.adresse=adr+" "+vnr+" "+post;
		unik=nr;
		nr++;
		
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
	public int getUnik() {
		return unik;
	}

}
