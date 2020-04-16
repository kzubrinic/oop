package hr.unidu.oop.p03;

import java.util.Random;

public class StaticBlok {
	private static int broj;
	static {
		//static blok se izvodi samo jednom, kada se stvori prvi objekt ovog tipa 
		ispisiPoruku();
		broj = 0;
	}
	public StaticBlok() {
		broj++;
		// Konstruktor se izvodi kada se stvara svaki objekt
		System.out.println("Stvoren objekt! " +broj);
    }
	public StaticBlok(int c) {
		System.out.println("Stvoren objekt (drugi konstruktor)! " + c );
	    
	}
	private static void ispisiPoruku() {
		System.out.println("Ovo je obrada u static bloku!");
	}
	public static void main(String[] args) {
		Random r = new Random();
		for(int i = 0; i < 10; ++i) {
			if (r.nextBoolean())
				new StaticBlok(++broj);
			else
				new StaticBlok();
		}
	}
}
