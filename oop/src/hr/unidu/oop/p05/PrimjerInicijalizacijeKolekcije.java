package hr.unidu.oop.p05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimjerInicijalizacijeKolekcije {
	@SuppressWarnings("serial")
	private List<String> l1 = new ArrayList<>(){ // anonimna unutarnja klasa tipa ArrayList<String>
        { // inicijalizator instance objekta 
            add("prvi"); 
            add("drugi"); 
            add("treći"); 
            add("četvrti");
        } 
    }; 
    // Inicijalizacija korištenjem metode asList() klase Arrays
    private List<String> l2 = Arrays.asList("prvi", "drugi" ,"treći", "četvrti");

	public static void main(String[] args) {
		PrimjerInicijalizacijeKolekcije p = new PrimjerInicijalizacijeKolekcije();
		for(String s: p.l1)
			System.out.println(s);
		for(String s: p.l2)
			System.out.println(s);
	}
}
