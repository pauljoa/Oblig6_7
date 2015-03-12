package no.uio.inf1010.oblig6.collections;

import no.uio.inf1010.oblig6.resept.Resept;

public class EldsteForstReseptListe extends EnkelReseptListe {

    @Override
    public boolean push(Resept r) {
        Node<Resept> node = new Node<>(r);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        length++;
        return true;
    }
}
