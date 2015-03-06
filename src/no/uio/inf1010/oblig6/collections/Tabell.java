package no.uio.inf1010.oblig6.collections;

import java.util.ArrayList;
import java.util.Iterator;


public class Tabell<E> implements AbstraktTabell<E> {
    private ArrayList<E> tabell;

    public Tabell(int size) {
        this.tabell = new ArrayList<>(size);
    }

    @Override
    public Iterator<E> iterator() {
        return new TabellIterator(tabell);
    }

    @Override
    public boolean put(int index, E element) {
        tabell.add(index, element);
        return true;
    }

    @Override
    public E get(int index) {
        return tabell.get(index);
    }

    private class TabellIterator implements Iterator<E> {
        private int index;
        private ArrayList<E> list;

        TabellIterator(ArrayList<E> list) {
            this.list = list;
            this.index = 0;
        }

        private E getNext(int i) {
            E e = list.get(i);

            if (e == null) {
                i++;
                return getNext(i);
            } else {
                return e;
            }
        }

        @Override
        public boolean hasNext() {
            return getNext(index + 1) == null;
        }

        @Override
        public E next() {
            index++;
            return getNext(index);
        }

        @Override
        public void remove() {
            list.remove(index);
            index++;
        }
    }

}
