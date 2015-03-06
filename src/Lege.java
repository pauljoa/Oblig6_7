
public class Lege implements Lik {
	protected String navn;
	public Lege(String n) {
		this.navn=n;
	}

	@Override
	public boolean samme(String s) {
		if((this.navn).equalsIgnoreCase(s)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String navn() {
		return navn;
	}

}
