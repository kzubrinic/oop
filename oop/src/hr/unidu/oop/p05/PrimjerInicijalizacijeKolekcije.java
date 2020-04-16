package hr.unidu.oop.p05;

import java.util.ArrayList;
import java.util.List;

public class PrimjerInicijalizacijeKolekcije {
	private List<String> l = new ArrayList<>(){ // anonimna unutarnja klasa tipa ArrayList<String>
        { // inicijalizator instance objekta 
            add("prvi"); 
            add("drugi"); 
            add("treći"); 
            add("četvrti");
        } 
    }; 
	public static void main(String[] args) {
		PrimjerInicijalizacijeKolekcije p = new PrimjerInicijalizacijeKolekcije();
		for(String s: p.l)
			System.out.println(s);

	}

}
