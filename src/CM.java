
public class CM extends Legemiddel implements Mikstur {
	
	protected double volum;
	protected double perCm3=virkestoff/volum;

	CM(String n, double v, int p,double x) {
		super(n, v, p);
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
	
}
