package no.uio.inf1010.oblig6.collections;

import no.uio.inf1010.oblig6.Lik;

import java.util.Iterator;


public class SortertEnkelListe<E extends Comparable<E> & Lik> implements AbstraktSortertEnkelListe<E> {

    private Node first;

    private class Node {
        protected E data;

        private Node next;

        public Node(E data) {
            this.data = data;
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
            previous.next = next;
            current = previous;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new SELIterator(first);
    }

    @Override
    public boolean push(E element) {
        Node node = new Node(element);


        if (first == null) {
            first = node;
        } else {
            Node current = first;

            while (current.next != null) {
                current = current.next;
            }

            current.next = node;
        }

        sort();

        return true;
    }

    @Override
    public E get(String s) {
        // TODO Auto-generated method stub
        return null;
    }

    protected void sort() {
        if (first != null && first.next != null) {
            Node newHead = first;
            Node pointer = first.next;

            while (pointer != null) {
                Node innerPointer = newHead;
                Node next = pointer.next;

                System.out.println(pointer.data.compareTo(newHead.data));
                if (pointer.data.compareTo(newHead.data) >= 0) {
                    Node oldHead = newHead;
                    newHead = pointer;
                    newHead.next = oldHead;
                } else {
                    while (innerPointer.next != null) {
                        if (pointer.data.compareTo(innerPointer.data) < 0 && pointer.data.compareTo(innerPointer.next.data) >= 0) {
                            Node oldNext = innerPointer.next;
                            innerPointer.next = pointer;
                            pointer.next = oldNext;
                        }

                        innerPointer = innerPointer.next;
                    }

                    if (pointer.data.compareTo(innerPointer.data) < 0) {
                        innerPointer.next = pointer;
                        pointer.next = null;
                    }
                }

                pointer = next;
            }

            first = newHead;
        }
    }
}
