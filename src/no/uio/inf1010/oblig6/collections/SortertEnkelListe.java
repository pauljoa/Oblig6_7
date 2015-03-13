package no.uio.inf1010.oblig6.collections;

import no.uio.inf1010.oblig6.Lik;

import java.util.Iterator;

/**
 * source: http://www.java2s.com/Code/Java/Collections-Data-Structure/SimplelinkedlistclasswhichusesaComparatortosortthenodes.htm
 *
 * @param <E>
 */
public class SortertEnkelListe<E extends Comparable<E> & Lik> implements AbstraktSortertEnkelListe<E> {

    private Node<E> head;
    private Node<E> tail;
    private int length;


    @Override
    public boolean push(E e) {
        Node<E> newnode = new Node<>(e);

        if (head == null) {
            // empty list
            head = newnode;
            tail = newnode;
        } else {
            if (e.compareTo(head.data) <= 0) {
                // Check if it needs to go right at the head
                newnode.next = head;
                head = newnode;
            } else if (e.compareTo(tail.data) >= 0) {
                // Check if it needs to go right at the tail
                tail.next = newnode;
                tail = newnode;
            } else {
                // It needs to be inserted into the middle of the list
                Node<E> next = head.next;
                Node<E> prev = head;

                while (e.compareTo(next.data) > 0) {
                    prev = next;
                    next = next.next;
                }

                // Do the actual insertion
                prev.next = newnode;
                newnode.next = next;
            }
        }

        length++;
        return true;
    }

    @Override
    public E get(String s) {
        for (E e : this) {
            if (e.samme(s)) {
                return e;
            }
        }

        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Riterator<>(head);
    }

    private void remove(E e) {
        Node<E> next = head;
        Node<E> prev = null;

        while (next != null) {
            if (next.data == e) {
                // Need to remove this node
                length--;
                if (prev != null) {
                    // It's not the head
                    prev.next = next.next;
                } else {
                    // It was the head
                    head = next.next;
                }
                // Check if it's the tail
                if (next == tail) {
                    tail = prev;
                }
            }
            prev = next;
            next = next.next;
        }
    }

    public int size() {
        return length;
    }
}
