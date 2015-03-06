
public class LegeAvtale implements Lik,Avtale {
	protected String navn;
	protected int avtalenr;
		
	LegeAvtale(String n,int a){
		this.navn=n;
		this.avtalenr=a; 
		
	}
	@Override
	public boolean samme(String s) {
		boolean isTrue=false;
		if((this.navn).equalsIgnoreCase(s)) {
			isTrue=true;
		}
		return isTrue;
	}

	public String getNavn() {
		return navn;
	}
	@Override
	public int avnr() {
		return avtalenr;
	}

}
