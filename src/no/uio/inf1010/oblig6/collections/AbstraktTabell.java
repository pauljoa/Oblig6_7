package no.uio.inf1010.oblig6.collections;

public interface AbstraktTabell<E> extends Iterable<E> {
    public boolean put(int index, E element);

    public E get(int index);


}
