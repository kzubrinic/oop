package hr.unidu.oop.p11.tokovi;

import java.util.Arrays;
import java.util.List;

public class PrimjerPosebnihVrstiTokova {

	private static SlozeniObjekt[] ulaz = {
			new SlozeniObjekt("C", 12, 8245677997L, 3.141),
			new SlozeniObjekt("A", 7, 67293457997L, 8.11),
			new SlozeniObjekt("B", 93, 123478899116L, 2587456.001234568),
	};
	public static void main(String[] args) {
		List<SlozeniObjekt> lista = Arrays.asList(ulaz);
		PrimjerPosebnihVrstiTokova pt = new PrimjerPosebnihVrstiTokova();
		
		pt.primjerTokaIntegera(lista);
		pt.primjerTokaLongIntegera(lista);
		pt.primjerTokaDouble(lista);
	}
	private void primjerTokaIntegera(List<SlozeniObjekt> lista) {
		int suma = lista.stream()
				.mapToInt(e -> e.getCijeliBroj()) // objekt tipa IntStream
				.sum(); // operacija na objektu tipa IntStream - vraća int
		int max = lista.stream()
				.mapToInt(e -> e.getCijeliBroj()) // objekt tipa IntStream
				.max() // operacija na objektu tipa IntStream - vraća Optional za int vrijednost
				.orElse(Integer.MAX_VALUE); // Optional može biti prazan i u tom slučaju MAX cijeli broj
		double prosjek = lista.stream()
				.mapToLong(e -> e.getCijeliBroj()) // objekt tipa IntStream
				.average() // operacija vraća prosjek - uvijek Optional za double vrijednost
				.orElse(0.0); // Optional može biti prazan i u tom slučaju vraća nulu
		System.out.println("Zbroj cijelih brojeva je: " + suma);
		System.out.println("Maksimalan cijeli broj (u kolekciji ili općenito) je: " + max);
		System.out.println("Prosjek cijelih brojeva je: " + prosjek);
	}
	private void primjerTokaLongIntegera(List<SlozeniObjekt> lista) {
		long suma = lista.stream()
				.mapToLong(e -> e.getDugacakCijeliBroj()) // objekt tipa LongStream
				.sum(); // operacija na objektu tipa LongStream - vraća long
		long min = lista.stream()
				.mapToLong(e -> e.getDugacakCijeliBroj()) // objekt tipa IntStream
				.min() // operacija na objektu tipa LongStream - vraća Optional za long vrijednost
				.orElse(Long.MIN_VALUE); // Optional može biti prazan i u tom slučaju MIN long cijeli broj
		double prosjek = lista.stream()
				.mapToLong(e -> e.getDugacakCijeliBroj()) // objekt tipa IntStream
				.average() // operacija vraća prosjek - uvijek Optional za double vrijednost
				.orElse(0.0); // Optional može biti prazan i u tom slučaju vraća nulu
		System.out.println("Zbroj dugačkih cijelih brojeva je: " + suma);
		System.out.println("Minimalan dugačak cijeli broj (u kolekciji ili općenito) je: " + min);
		System.out.println("Prosjek dugačkih cijelih brojeva je: " + prosjek);
	}

	private void primjerTokaDouble(List<SlozeniObjekt> lista) {
		double suma = lista.stream()
				.mapToDouble(e -> e.getRealniBroj()) // objekt tipa LongStream
				.sum(); // operacija na objektu tipa DoubleStream - vraća double
		double prosjek = lista.stream()
				.mapToDouble(e -> e.getRealniBroj()) // objekt tipa DoubleStream
				.average() // operacija vraća prosjek - uvijek Optional za double vrijednost
				.orElse(0.0); // Optional može biti prazan i u tom slučaju vraća nulu
		System.out.println("Zbroj realnih brojeva je: " + suma);
		System.out.println("Prosjek realnih brojeva je: " + prosjek);
		
	}


	
}
