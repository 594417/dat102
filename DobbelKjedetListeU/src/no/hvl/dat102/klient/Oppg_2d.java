package no.hvl.dat102.klient;

import no.hvl.dat102.kjedet.DobbelKjedetOrdnetListe;

public class Oppg_2d {

	public static void main(String[] args) {

		int tall[] = {1, 2, 3, 4, 5};
		
		DobbelKjedetOrdnetListe<Integer> liste = new DobbelKjedetOrdnetListe<Integer>(0, 50);
		
		for (int i = 0; i < tall.length; i++) {
			liste.leggTil(tall[i]);
		}
		
		System.out.println(liste);

		System.out.println(liste.tilStrengBaklengs());

		System.out.println(liste.fjern(3));

		System.out.println(liste.fjern(1));
		
		System.out.println(liste);

	}

}
