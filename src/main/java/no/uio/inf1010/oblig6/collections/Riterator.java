package no.uio.inf1010.oblig6.collections;

import java.util.Iterator;

public class Riterator<E> implements Iterator<E> {
    private Node<E> next;

    public Riterator(Node<E> node) {
        this.next = node;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public E next() {
        if (hasNext()) {
            Node<E> current = next;
            next = next.next;
            return current.data;
        }

        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
