package no.uio.inf1010.oblig6.collections;

class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
    }

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

}
