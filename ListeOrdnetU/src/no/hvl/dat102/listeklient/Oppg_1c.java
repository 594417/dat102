package no.hvl.dat102.listeklient;

import no.hvl.dat102.tabell.TabellOrdnetListe;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import java.util.Scanner;

public class Oppg_1c {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		KjedetOrdnetListe <Person> ordnetListe = new KjedetOrdnetListe<>();
		TabellOrdnetListe <Person> ordnetListeEn = new TabellOrdnetListe<>();


		String fornavn;
		String etternavn;
		int foedselsaar;

		for (int i = 0; i <= 6; i++) {

			System.out.println("Skriv inn fornavn, etternavn og fødselsår: ");
			
			System.out.println("Fornavn: ");
			fornavn = scanner.nextLine();
			System.out.println("Etternavn: ");
			etternavn = scanner.nextLine();
			System.out.println("Fødselsår: ");
			foedselsaar = scanner.nextInt();

			Person objekt = new Person(fornavn, etternavn, foedselsaar);
			ordnetListe.leggTil(objekt);
			ordnetListeEn.leggTil(objekt);

			scanner.close();

			while(ordnetListe.antall() > 0 && ordnetListeEn.antall() > 0) {

				ordnetListe.fjernSiste();
				ordnetListeEn.fjernSiste();

				System.out.println(objekt);
			}

			System.out.println(fornavn + etternavn + foedselsaar);

		}

	}

}
