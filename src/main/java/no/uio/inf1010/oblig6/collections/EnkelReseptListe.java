package no.uio.inf1010.oblig6.collections;

import no.uio.inf1010.oblig6.resept.Resept;
import no.uio.inf1010.oblig6.resept.ReseptNotFoundException;

import java.util.Iterator;

public abstract class EnkelReseptListe implements Iterable<Resept> {
    protected Node<Resept> head;
    protected Node<Resept> tail;
    protected int length;

    public EnkelReseptListe() {
        length = 0;
    }

    public abstract boolean push(Resept r);

    public Resept get(int reseptNr) {
        for (Resept r : this) {
            if (r.getNr() == reseptNr) {
                length--;
                return r;
            }
        }

        throw new ReseptNotFoundException(reseptNr);
    }

    @Override
    public Iterator<Resept> iterator() {
        return new Riterator<>(head);
    }

    public int size() {
        return length;
    }

	public void clear() {
		head = null;
		tail = null;
		length = 0;
	}
}
