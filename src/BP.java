
public class BP extends Legemiddel implements Piller {
	protected int vane;
	protected int mengde;
	protected double perEnhet=virkestoff/mengde;
	
	public BP(String n, double v, int p,int a,int m) {
		super(n, v, p);
		this.vane=a;
		this.mengde=m;
	}

	@Override
	public int mengde() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perEnhet() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int vane() {
		return vane;
	}
	
}
