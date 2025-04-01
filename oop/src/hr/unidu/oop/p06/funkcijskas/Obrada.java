package hr.unidu.oop.p06.funkcijskas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Obrada {
	private List<Automobil> vozila;
	public static void main(String[] args) {
		new Obrada().kreni();

	}
	public Obrada() {
		vozila = new ArrayList<>();
	}
	
	private void kreni() {
		dodajVozila();
		Collections.sort(vozila);
		prviNacin(); 	// klasičan
		drugiNacin(); 	// funkcijska sučelja
		treciNacin();	// anonimne klase (i funkcijska sučelja)
		cetvrtiNacin();	// lambda izrazi (i funkcijska sučelja)
		petiNacin();	// lambda izrazi (objava pomoću Consumer funkcijskog sučelja)
		
		sortiraj();
		sortiraj1(); // lambda izraz koristi referencu na metodu
		ispis();
	}

	private void dodajVozila() {
		vozila.add(new Automobil("Opel", Boja.SIVA, Kategorija.OD_55_DO_70));
		vozila.add(new Automobil("Peugeot", Boja.ZELENA, Kategorija.OD_70_DO_100));
		vozila.add(new Automobil("Golf", Boja.CRVENA, Kategorija.OD_100_DO_130));
		vozila.add(new Automobil("Seat", Boja.CRVENA, Kategorija.OD_70_DO_100));
		vozila.add(new Automobil("Kia", Boja.BIJELA, Kategorija.DO_55));
		vozila.add(new Automobil("Toyota", Boja.SIVA, Kategorija.PREKO_130));
	}
	
	// "Klasičan" način - za svaku obradu posebna metoda s kompletnim kodom
	private void prviNacin() {
		System.out.println("---- POTENCIJALNO AGRESIVNI (1) ----");
		ispisiPotencijalnoAgresivne();
		System.out.println("------------------------------------");
		System.out.println("---------- MALE SNAGE (1) ----------");
		ispisiVozilaMaleSnage();
		System.out.println("------------------------------------");
	}
	public void ispisiPotencijalnoAgresivne() {
		for(Automobil a : vozila) {
			if (a.getBoja() == Boja.CRVENA) {
				System.out.println(a);
			}
		}
	}
	public void ispisiVozilaMaleSnage() {
		for(Automobil a : vozila) {
			if (a.getKategorija() == Kategorija.DO_55 ) {
				System.out.println(a);
			}
		}
	}
	
	// Korištenje funkcijskih sučelja - posebna klasa koja implementira FS, a zajednička
	//  obrada koja kao objekt prima FS
	private void drugiNacin() {
		System.out.println("---- POTENCIJALNO AGRESIVNI (2) ----");
		Predicate<Automobil> pa = new PotencijalnoAgresivni();
		ispisiFs(pa);
		System.out.println("------------------------------------");
		System.out.println("---------- MALE SNAGE (2) ----------");
		Predicate<Automobil> ms = new MaleSnage();
		ispisiFs(ms);
		System.out.println("------------------------------------");
	}
	
	public void ispisiFs(Predicate<Automobil> pa) {
		for(Automobil a : vozila) {
			if (pa.test(a)) {
				System.out.println(a);
			}
		}
	}
	
	// Korištenje anonimnih klasa (i funkcijskih sučelja)
	private void treciNacin() {
		System.out.println("---- POTENCIJALNO AGRESIVNI (3) ----");
		ispisiFs(new Predicate<Automobil>() {
			@Override
			public boolean test(Automobil t) {
				return t.getBoja() == Boja.CRVENA;
			}
		});
		System.out.println("------------------------------------");
		System.out.println("---------- MALE SNAGE (3) ----------");
		ispisiFs(new Predicate<Automobil>() {
			@Override
			public boolean test(Automobil t) {
				return t.getKategorija() == Kategorija.DO_55;
			}
		});
		System.out.println("-----------------------------------");
	}
	
	// Korištenje lambda izraza (i funkcijskih sučelja)
	private void cetvrtiNacin() {
		System.out.println("---- POTENCIJALNO AGRESIVNI (4) ----");
		ispisiFs((t) -> {
			return t.getBoja() == Boja.CRVENA;
		});
		System.out.println("------------------------------------");
		System.out.println("---------- MALE SNAGE (4) ----------");
		ispisiFs(t -> t.getKategorija() == Kategorija.DO_55);
		System.out.println("------------------------------------");
	}
	
	// Korištenje lambda izraza (i ispisa pomoću metode Consumer sučelja)
	private void petiNacin() {
		System.out.println("---- POTENCIJALNO AGRESIVNI (5) ----");
		ispisiFs2(
			(t) -> t.getBoja() == Boja.CRVENA,
			(t) -> System.out.println(t)
		);
		System.out.println("------------------------------------");
		System.out.println("---------- MALE SNAGE (5) ----------");
		ispisiFs2(
			(t) -> t.getKategorija() == Kategorija.DO_55,
			(t) -> System.out.println(t)
		);
		System.out.println("------------------------------------");
	}
	public void ispisiFs2(Predicate<Automobil> pa, Consumer<Automobil> ak) {
		for(Automobil a : vozila) {
			if (pa.test(a)) {
				ak.accept(a);
			}
		}
	}
	
	private void ispis() {
		System.out.println("------- SVI AUTOMOBILI --------");
		ispisCon((t) -> System.out.println(t));
		System.out.println("-------------------------------");
	}
	
	public void ispisCon(Consumer<Automobil> pa) {
		vozila.forEach(pa);
	}
	
	public void sortiraj() {
		Collections.sort(vozila, 
				(a,b) -> Automobil.compareByModel(a,b) );
	}
	public void sortiraj1() {
		Collections.sort(vozila, Automobil::compareByModel);
	}

}
