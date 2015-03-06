
public class CP extends Legemiddel implements Piller {

	protected int mengde;
	protected double perEnhet= (virkestoff/mengde);
	
	CP(String n, double v, int p,int m) {
		super(n, v, p);
		this.mengde=m;
		
	}

	@Override
	public int mengde() {
		return this.mengde;
	}

	@Override
	public double perEnhet() {
		return this.perEnhet;
	}

}
