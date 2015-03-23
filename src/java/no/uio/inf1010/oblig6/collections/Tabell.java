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
		ensureSize(index + 1);
        tabell.add(index, element);
        return true;
    }

	private void ensureSize(int size) {
		tabell.ensureCapacity(size);
		while (tabell.size() < size) {
			tabell.add(null);
		}
	}

    @Override
    public E get(int index) {
        return tabell.get(index);
    }

	public void clear() {
		tabell.clear();
	}

	public int size() {
		return tabell.size();
	}

	private class TabellIterator implements Iterator<E> {
        private int index;
        private ArrayList<E> list;

        TabellIterator(ArrayList<E> list) {
            this.list = list;
            this.index = -1;
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
