
public class ReseptBlaa {
	static int nr=0;
	protected Legemiddel l;
	protected Lege p;
	protected int reit;
	protected int personnr;
	protected int unik;
	
	public ReseptBlaa(int r,Lege c,Legemiddel y,int pers) {
		unik=nr;
		nr++;
		this.l=y;
		this.reit=r;
		this.p=c;
		this.personnr=pers;
	}
	
	public int getNr() {
		return unik;
	}
	
	public Legemiddel getL() {
		return l;
	}
	public Lege getP() {
		return p;
	}
	public int getReit() {
		return reit;
	}
	public int getPersonnr() {
		return personnr;
	}

}
