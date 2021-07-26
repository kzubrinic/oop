package hr.unidu.oop.p05;

import java.util.Iterator;
import java.util.Random;

public class TestnaMojaKolekcija {

	public static void main(String[] args) {
		Random r = new Random();
		MojaKolekcija<Integer> mk = new MojaKolekcija<Integer>(10);
		// Dodajemo elemente
		for(int i = 0; i<10;++i) {
			mk.add(r.nextInt(100)+1);
		}
		// Ispisujemo broj elemenata
		System.out.println("Kolekcija ima "+ mk.getSize() + " elemenata.");
		// Ispisujemo sve elemente pomoću iteratora
		System.out.println("Elementi kolekcije su:");
		for(Iterator<Integer> i =  mk.iterator();i.hasNext();)
			System.out.println(i.next());
		// Dohvaćamo 4. element kolekcije
		System.out.println("4. element kolekcije je: " + mk.getElement(3));
	}

}
