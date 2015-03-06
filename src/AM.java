
public class AM extends Legemiddel implements Mikstur{
	protected double volum;
	protected double perCm3=virkestoff/volum;
	protected int narkotisk;
	public AM(String n, double v, int p,double y,int x) {
		super(n, v, p);
		this.volum=y;
		this.narkotisk=x;
	}
	@Override
	public double volum() {
		return volum;
	}
	@Override
	public double perCm3() {
		return perCm3;
	}
	public int nark() {
		return narkotisk;
	}
}
