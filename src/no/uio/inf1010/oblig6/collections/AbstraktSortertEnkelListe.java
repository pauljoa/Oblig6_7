package no.uio.inf1010.oblig6.collections;

import no.uio.inf1010.oblig6.Lik;

public interface AbstraktSortertEnkelListe<E extends Comparable<E> & Lik> extends Iterable<E> {

    public boolean push(E element);

    public E get(String s);
}
