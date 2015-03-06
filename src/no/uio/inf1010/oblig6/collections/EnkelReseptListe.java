package no.uio.inf1010.oblig6.collections;

import java.util.Iterator;
import no.uio.inf1010.oblig6.resept.Resept;

public abstract class EnkelReseptListe  implements Iterable<Resept>{
	
	protected Node<Resept> head;
	protected Node<Resept> tail;
	
	public abstract boolean push(Resept r);
	public Resept get(int reseptNr) {
		for(Resept r : this) {
			if(r.getNr()==reseptNr) {
				return r;
			}
		}
		throw new IllegalStateException();
	}

	@Override
	public Iterator<Resept> iterator() {
		
		return new Riterator<Resept>(head);
	}
	
	
	
	
	

}
