package no.uio.inf1010.oblig6.collections;

public interface AbstraktTabell<E> extends Iterable<E> {
	public boolean add(int index, E element);

	public void clear();

	public int size();

	public E get(int index);
}
