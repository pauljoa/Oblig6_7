
public class BM extends Legemiddel implements Mikstur {
	protected int vane;
	protected double volum;
	protected double perCm3=virkestoff/volum;
	public BM(String n, double v, int p,double x,int a) {
		super(n, v, p);
		this.vane=a;
		this.volum=x;
	}
	@Override
	public double volum() {
		return volum;
	}
	@Override
	public double perCm3() {
		return perCm3;
	}
	
	public int vane() {
		return vane;
	}

}
