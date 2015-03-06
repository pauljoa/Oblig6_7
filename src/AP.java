
public class AP extends Legemiddel implements Piller {
	protected int narkotisk;
	protected int mengde;
	protected double perEnhet=virkestoff/mengde;
	public AP(String n, double v, int p,int x,int m) {
		super(n, v, p);
		this.narkotisk=x;
		this.mengde=m;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public int mengde() {
		return mengde;
	}
	@Override
	public double perEnhet() {	
		return perEnhet;
	}
	
	public int nark() {
		return narkotisk;
	}


}
