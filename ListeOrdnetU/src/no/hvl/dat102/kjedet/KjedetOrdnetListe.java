package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		//?
		T resultat = foerste.getElement();
		foerste = foerste.getNeste();

		if (foerste == null)
			siste = null;
		
		antall --;
		
		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		//?
		T resultat = siste.getElement();
		LinearNode<T> forrige = null;
		LinearNode<T> denne = foerste;

		while (denne.getNeste() != null) {
			forrige = denne;
			denne = denne.getNeste();
		}

		siste = forrige;
		if (siste == null) 
			foerste = null;
		else 
			forrige.setNeste(null);

		antall--;

		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = foerste.getElement();

		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		
		LinearNode <T> node = new LinearNode <T> (element), denne = foerste, forrige = null;
		
		while (denne != null && element.compareTo(denne.getElement()) > 0) {

			forrige = denne;
			denne = denne.getNeste();

		}
		
		if (forrige == null) {
			foerste = node;
			foerste.setNeste(denne);
			//denne.setNeste(foerste);
			//foerste = node;
		} else {
			forrige.setNeste(node);
			node.setNeste(denne);
		} 
		
		if (denne == null) {
			//foerste = node;
			siste = node;
		}
		
		antall++;

	}


	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;

		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // F�rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
