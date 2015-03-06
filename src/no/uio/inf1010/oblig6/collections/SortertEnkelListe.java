package no.uio.inf1010.oblig6.collections;

import no.uio.inf1010.oblig6.Lik;

import java.util.Iterator;

/**
 * source: http://www.java2s.com/Code/Java/Collections-Data-Structure/SimplelinkedlistclasswhichusesaComparatortosortthenodes.htm
 * @param <E>
 */
public class SortertEnkelListe<E extends Comparable<E> & Lik> implements AbstraktSortertEnkelListe<E> {

    private Node head;
    private Node tail;
    private int length;

    private class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private class SELIterator implements Iterator<E> {

        private Node current;
        private Node next;
        private Node previous;

        public SELIterator(Node node) {
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

    @Override
    public boolean push(E e) {
        Node newnode = new Node(e);

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
                Node next = head.next;
                Node prev = head;

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
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new SELIterator(head);
    }

    private void remove(E e) {
        Node next = head;
        Node prev = null;

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
