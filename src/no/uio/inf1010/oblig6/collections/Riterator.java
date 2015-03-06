package no.uio.inf1010.oblig6.collections;

import java.util.Iterator;

public class Riterator<E> implements Iterator<E> {
	 private Node<E> current;
     private Node<E> next;
     private Node<E> previous;

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
             previous = current;
             current = next;
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
