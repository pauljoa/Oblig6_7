package no.uio.inf1010.oblig6.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Tabell<E> implements AbstraktTabell<E> {

	private Map<Integer, E> map;

	public Tabell(int size) {
		map = new HashMap<>(size);
	}

	@Override
	public boolean add(int index, E element) {
		map.put(index, element);
		return true;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public E get(int index) {
		return map.get(index);
	}

	@Override
	public Iterator<E> iterator() {
		return map.values().iterator();
	}


}
