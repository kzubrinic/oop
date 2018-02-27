package hr.unidu.oop.p02;

import hr.unidu.oop.p01.Osoba;

/**
 * Primjer stvaranja jednog objekta, pristup varijablama
 * i metodama stvorenog objekta.
 * @author Krunoslav �ubrini�
 * velja�a 2017.
 */
public class Upoznavanje {
	public static void main(String[] args) {
		// Deklarira se varijabla referenca za pristup
		// objektu tipa Osoba
		Osoba susjed;
		// Stvara se novi objekt tipa Osoba pomo�u operatora new.
		// Prethodno deklarirana referenca susjed povezuje se sa
		// stvorenim objektom.
		susjed = new Osoba();
		// Napomena: Objekt mo�emo stvoriti i kra�e u 1 retku
		// Osoba susjed = new Osoba();
		
		// Vrijednost varijable objekta mijenja se pomo�u operatora "to�ka"
		// Sintaksa je: referenca to�ka imeVarijable.
		susjed.ime = "Ivo";
		susjed.starost = 37;
		// Ispisuje se ime prijatelja (sadr�aj varijable ime objekta).
		System.out.println("Dobar dan, ja sam " + susjed.ime);
		// Metode se na stvorenom objektu pozivaju na isti na�in kao
		// �to se pristupa varijablama (pomo�u operatora "to�ka").
		// Poziva se metoda rodjendan() koja mijenja starost susjeda.
		susjed.rodjendan();
		// Ispisuje se starost prijatelja (sadr�aj varijable starost objekta).
		System.out.println("Danas mi je ro�endan i imam " + susjed.starost+" godina.");
	}
}