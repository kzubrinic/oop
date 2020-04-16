package hr.unidu.oop.p03;

import java.util.Random;

public class Inicijalizatori {
	//static inicijalizator se izvodi samo jednom, kada se stvori prvi objekt ovog tipa 
	private static int broj;
	private int n;
	static {
		ispisiPoruku();
		broj = 0;
	}
	// inicijalizator instance se izvodi kod stvaranja svakog objekta, neposredno prije
	// izvođenja programskogkoda konstruktora.
	{
		ispisiPoruku2();
		n = 0;
		Inicijalizatori.broj++;
	}

	public Inicijalizatori() {
		// Konstruktor se izvodi kod stvaranja svakog objekta
		System.out.println("Stvoren objekt! " +broj);
    }
	private static void ispisiPoruku() {
		System.out.println("Ovo je obrada u static inicijalizatoru!");
	}
	private void ispisiPoruku2() {
		System.out.println("Ovo je obrada u inicijalizatoru instance!");
	}
	public static void main(String[] args) {
		Random r = new Random();
		for(int i = 0; i < 10; ++i) {
			new Inicijalizatori();
		}
	}
}
