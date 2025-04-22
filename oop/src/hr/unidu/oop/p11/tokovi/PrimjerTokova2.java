package hr.unidu.oop.p11.tokovi;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class PrimjerTokova2 {

	private static Osoba[] ulaz = {new Osoba("Pero", "Katić"), new Osoba("Pero", "Perić"), new Osoba("Ana", "Anić"), new Osoba("Ivo", "Ivić"), new Osoba("Kate", "Katić"), new Osoba("Ivo", "Ivić")}; 


	// Komparator po prezimenu koji vodi računa o hr kodnoj stranici u stringovima
	private static Comparator<Object> hrComp = Collator.getInstance(Locale.forLanguageTag("hr"));
	public static Comparator<Osoba> komparatorPoPrezimenuSilazno =(o1, o2) -> {
		int i = hrComp.compare(o2.getPrezime(), o1.getPrezime());
		if(i == 0)
			return hrComp.compare(o2.getIme(), o1.getIme());
		return i;
	};

	public static void main(String[] args) {
		List<Osoba> lista = Arrays.asList(ulaz);
		PrimjerTokova2 pt = new PrimjerTokova2();
		
		pt.transformacija(lista);
		pt.transformacija2();
	}
	
	private void transformacija(List<Osoba> lista) {
		System.out.println("--------------------");
		System.out.println("Osobe, silazno sortirane");
		System.out.println("--------------------");
		// Filtriranje jedinstvenih elemenata kolekcije
		//  sortiranje u silaznom redosljedu koristeći posebni komparator i
		//	ispis tih elemenata
		lista.stream()
				.distinct()
				.sorted(komparatorPoPrezimenuSilazno)
				.forEach(System.out::println);
		System.out.println("--------------------");
	}

	private void transformacija2() {
		List<List<String>> listaLista = Arrays.asList(
	            Arrays.asList("a", "b", "c"),
	            Arrays.asList("d", "e"),
	            Arrays.asList("f", "g", "h")
	        );
		   List<String> flatLista = listaLista.stream()
		     .flatMap(List::stream)
		     .collect(Collectors.toList());
		   
		   flatLista.stream().forEach(System.out::println);
	}
	
}
