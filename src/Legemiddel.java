
public class Legemiddel {
	protected String navn;
	protected double virkestoff;
	protected int pris;
	static int nr=0;
	protected int unik;
	
	public Legemiddel(String n,double v,int p) {
		this.virkestoff =v;
		unik=nr;
		nr++;
		this.pris=p;
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
	
}