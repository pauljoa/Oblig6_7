package no.uio.inf1010.oblig6.collections;

import no.uio.inf1010.oblig6.resept.Resept;

public class YngsteForstReseptListe extends EnkelReseptListe {

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("YngsteForstReseptListe {");
        sb.append("\n");

        for (Resept resept : this) {
            sb.append("  ");
            sb.append(resept.toString().replace("\n", ", "));
            sb.append("\n");
        }

        sb.append("}");
        sb.append("\n");
        return sb.toString();
    }
}
