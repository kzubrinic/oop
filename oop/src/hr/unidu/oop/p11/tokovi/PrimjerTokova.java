package hr.unidu.oop.p11.tokovi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrimjerTokova {
	private static String[] ulaz = {"Pero Perić, UNIDU", "Ana Anić, UNIZG", "Ivo Ivić, UNIPU", "Kate Katić, UNIDU", "Pero Perić, UNIDU", "Vlaho Vlahić, UNIDU"}; 

	public static void main(String[] args) {
		List<String> lista = Arrays.asList(ulaz);
		PrimjerTokova pt = new PrimjerTokova();
		
		pt.brojiElementeToka(lista);
		pt.podudaranjeElemenataToka(lista);
		pt.samoUnidu(lista);
		pt.samoImenaUnidu(lista);
		pt.redukcija(lista);
		pt.slozenaTransformacija(lista);
	}
	private void brojiElementeToka(List<String> lista) {
		long brEl, brJedEl;
		brEl = lista.stream()
				.count();
		brJedEl = lista.stream()
				.distinct()
				.count();
		System.out.println("Broj elemenata je: " + brEl);
		// Jedan element se u listi ponavlja pa će ovaj broj biti za 1 manji od prethodnog
		System.out.println("Broj JEDINSTVENIH elemenata je: " + brJedEl);
	}
	
	private void podudaranjeElemenataToka(List<String> lista) {
		// Neki elementi sadrže tekst "UNIDU"
		boolean baremJedan = lista.stream()
				.anyMatch(element -> element.contains("UNIDU"));
		// SVI elementi sadrže znak zareza
		boolean svi = lista.stream()
				.allMatch(element -> element.contains(","));
		// Niit jedan element ne sadrži tekst UNIRI
		boolean nitiJedan = lista.stream()
				.noneMatch(element -> element.contains("UNIRI"));
		System.out.println(baremJedan + ", " + svi + ", " + nitiJedan);
	}
	
	private void samoUnidu(List<String> lista) {
		// Filtriranje jedinstvenih elemenata kolekcije 
		//	koji sadrže tekst UNIDU i
		//	stvaranje nove liste iz tih elemenata
		List<String> samoUnidu = lista.stream()
				.distinct()
				.filter(element -> element.contains("UNIDU"))
				.collect(Collectors.toList());
		
		System.out.println("--------------------");
		System.out.println("Samo UNIDU");
		System.out.println("--------------------");
		// "Klasičan" način iteracije kroz kolekciju i ispis elemenata
		for(String s:samoUnidu) {
			System.out.println(s);
		}
		System.out.println("--------------------");
	}
	
	private void samoImenaUnidu(List<String> lista) {
		// Filtriranje jedinstvenih elemenata kolekcije
		//	koji sadrže tekst UNIDU,
		//  njihova transformacija (izbacivanjem kratice sveučilišta) i
		//	stvaranje nove liste iz tih elemenata
		List<String> samoUnidu = lista.stream()
				.distinct()
				.filter(element -> element.contains("UNIDU"))
				.map(element -> element.split(",")[0])
				.collect(Collectors.toList());
		
		System.out.println("--------------------");
		System.out.println("Samo imena UNIDU");
		System.out.println("--------------------");
		// "Klasičan" način iteracije kroz kolekciju i ispis elemenata
		for(String s:samoUnidu) {
			System.out.println(s);
		}
		System.out.println("--------------------");
	}
	
	private void redukcija(List<String> lista) {
		// Filtriranje jedinstvenih elemenata kolekcije i 
		//	redukcija svih elemenata spajanjem u jedan niz znakova
		String spojeniNiz = lista.stream()
				.distinct()
				.reduce("", (a, b) -> a + "; " + b);
		
		System.out.println(spojeniNiz);
		System.out.println("--------------------");
	}
	
	private void slozenaTransformacija(List<String> lista) {
		System.out.println("--------------------");
		System.out.println("Samo imena UNIDU, velikim slovima, silazno sortirana");
		System.out.println("--------------------");
		// Filtriranje jedinstvenih elemenata kolekcije
		//	koji sadrže tekst UNIDU,
		//  njihova transformacija (izbacivanjem kratice sveučilišta i 
		//  pretvorbom u velika slova),
		//  sortiranje u silaznom redosljedu i
		//	ispis tih elemenata
		lista.stream()
				.distinct()
				.filter(element -> element.contains("UNIDU"))
				.map(element -> element.split(",")[0])
				.map(element -> element.toUpperCase())
				.sorted(Comparator.reverseOrder())
				.forEach(System.out::println);
		System.out.println("--------------------");
	}

}
