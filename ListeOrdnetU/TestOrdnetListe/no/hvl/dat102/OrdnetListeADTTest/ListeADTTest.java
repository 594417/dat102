package no.hvl.dat102.OrdnetListeADTTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public abstract class ListeADTTest {

	/**
	 * Test av OrdnetListeADT med heltall.
	 * 
	 * @author Ole Olsen
	 */
	private OrdnetListeADT<Integer> liste;
    // TODO  mangler en god del!
	
	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;

	protected abstract OrdnetListeADT<Integer> reset();

	/**
	 * Opprett en tom liste for hver test.
	 * 
	 * 
	 */
	@BeforeEach
	public final void setup() {
		liste = reset();
	}

	/**
	 * Tester om en ny liste er tom.
	 */
	@Test
	public final void nyListeErTom() {
		Assert.assertTrue(liste.erTom());
	}

	/**
	 * Tester leggTil og fjern.
	 */
	@Test
	public final void leggTilOgFjern() {
		liste.leggTil(e0);
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e3);
		liste.leggTil(e4);
		liste.leggTil(e5);
		assertEquals(e5, liste.fjern(e5));
		assertEquals(e4, liste.fjern(e4));
		assertEquals(e3, liste.fjern(e3));
		assertEquals(e2, liste.fjern(e2));
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e0, liste.fjern(e0));
	}

	/**
	 * Tester ordning ikke-avtagende
	 * 
	 */
	@Test
	public final void viseOrdnetIkkeAvtagende() {
		// ... Fyll ut
		// ... Legg til elementer og bruk fjernFoerste
		try {
		liste.leggTil(e5);
		liste.leggTil(e2);
		liste.leggTil(e3);
		liste.leggTil(e1);
		liste.leggTil(e4);
		liste.leggTil(e0);
		assertEquals(e5, liste.fjernFoerste());
		assertEquals(e1, liste.fjernFoerste());
		assertEquals(e4, liste.fjernFoerste());
		assertEquals(e3, liste.fjernFoerste());
		assertEquals(e2, liste.fjernFoerste());
		assertEquals(e0, liste.fjernFoerste());
		} catch(EmptyCollectionException e) {
			fail("feilet uventet " + e.getMessage());
		}
	}
	
	@Test
	public final void viseOrdnetIkkeStigende() {
		try {
			liste.leggTil(e1);
			liste.leggTil(e2);
			liste.leggTil(e5);
			liste.leggTil(e0);
			liste.leggTil(e4);
			liste.leggTil(e3);
			assertEquals(e5, liste.fjernSiste());
			assertEquals(e4, liste.fjernSiste());
			assertEquals(e3, liste.fjernSiste());
			assertEquals(e2, liste.fjernSiste());
			assertEquals(e1, liste.fjernSiste());
			assertEquals(e0, liste.fjernSiste());
		} catch(EmptyCollectionException e) {
			fail("feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Tester leggTil og fjern med like verdier.
	 */
	@Test
	public final void leggTilOgfjernMedDuplikater() {
		try {
			// ... Fyll ut med � legge til passende elementer
			liste.leggTil(e2);
			liste.leggTil(e4);
			liste.leggTil(e1);
			liste.leggTil(e5);
			liste.leggTil(e0);
			liste.leggTil(e3);
			assertEquals(e0, liste.fjern(e0));
			assertEquals(e1, liste.fjern(e1));
			assertEquals(e4, liste.fjern(e4));
			assertEquals(e1, liste.fjern(e1));
			assertEquals(e2, liste.fjern(e2));
			assertEquals(e3, liste.fjern(e3));

		} catch (EmptyCollectionException e) {
			fail("feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Tester leggTil og inneholder
	 */
	@Test
	public final void leggTilOgInnholder() {
		liste.leggTil(e2);
		liste.leggTil(e1);
		liste.leggTil(e4);
		liste.leggTil(e0);
		liste.leggTil(e3);
		Assert.assertTrue(liste.inneholder(e0));
		Assert.assertTrue(liste.inneholder(e1));
		Assert.assertTrue(liste.inneholder(e2));
		Assert.assertTrue(liste.inneholder(e3));
		Assert.assertTrue(liste.inneholder(e4));
		assertFalse(liste.inneholder(e5));

	}

	/**
	 * Tester om listen med verdier ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		liste.leggTil(e1);
		liste.leggTil(e3);
		liste.leggTil(e2);
		liste.leggTil(e4);
		liste.leggTil(e5);
		assertFalse(liste.erTom());
	}

	/**
	 * Tester om leggTil-fjern p� en tom liste gir en tom liste.
	 */
	@Test
	public final void leggTilFjernErTom() {
		// ...Fyll ut. Legg inn elementer og fjern de
		liste.leggTil(e4);
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e0);
		liste.leggTil(e3);
		liste.leggTil(e5);
		assertEquals(e0, liste.fjern(e0));
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e4, liste.fjern(e4));
		assertEquals(e5, liste.fjern(e5));
		assertEquals(e2, liste.fjern(e2));
		assertEquals(e3, liste.fjern(e3));
	}

	/**
	 * Pr�ver � ta ut et element fra en tom liste.
	 * 
	 * ... Fyll ut
	 */
	@Test
	public void fjernFraTomListe() {	
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			liste.fjernFoerste();
		});
		}

	/**
	 * Fors�k p� � returnere f�rste fra tom liste
	 * 
	 * @exception EmptyCollectionException expected exception
	 */
	@Test
	public void foersteFraTom() {
		Assertions.assertThrows(EmptyStackException.class, () -> {
			liste.foerste();
		});
	}

}
