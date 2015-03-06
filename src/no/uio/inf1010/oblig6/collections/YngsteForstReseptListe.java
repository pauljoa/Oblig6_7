package no.uio.inf1010.oblig6.collections;

import no.uio.inf1010.oblig6.resept.Resept;

public class YngsteForstReseptListe extends EnkelReseptListe {

	@Override
	public boolean push(Resept r) {
		Node<Resept> node = new Node<Resept>(r);
		if(head==null) {
			head=node;
			tail=node;
		}
		else {
			head.next=node;
			head=node;
			
		}
		return true;
	}
}
