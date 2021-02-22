package hr.unidu.oop.p03;

import java.util.Arrays;

public class FunkcijePolja {
	private static void ispisi(int[] polje) {
		for(int el : polje)
			System.out.print(""+el+", ");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] polje1 = {23,17,9,8,4,0};
		// polje 1 i polje2 su dvije reference na isto polje
		int[] polje2 = polje1;
		// polje3 je kopija - novo polje
		int[] polje3 = Arrays.copyOf(polje1, polje1.length);
		// sadržaj prvog polja može se promijeniti pomoću reference polje1 ili polje2
		polje2[2] = 999;
		ispisi(polje1);
		ispisi(polje2);
		ispisi(polje3);
		System.out.println();
		// referenca polje3 mijenja sadržaj samo svoje kopije polja
		polje3[0] = 777;
		ispisi(polje1);
		ispisi(polje2);
		ispisi(polje3);
		System.out.println();
		// sortoiranje prvog polja - sortirani sadržaj dostupan je pomoću reference polje1 ili polje2
		Arrays.sort(polje1);
		ispisi(polje1);
		ispisi(polje2);
		ispisi(polje3);
		
	}

}
