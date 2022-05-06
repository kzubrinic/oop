package hr.unidu.oop.p11;

import java.util.Arrays;
import java.util.List;

class PrimjerRefMetoda{
	  public PrimjerRefMetoda(){
	  }
	  public PrimjerRefMetoda(String s){
	    System.out.println("Konstruktor klase primjerRefMetode: " + s);
	  }
	  static void staticMetoda(String s)  {
	    System.out.println("Static metoda: " + s);
	  }
	  void metoda(String s)  {
	    System.out.println("Metoda koja nije static: " + s);
	  }
	  public static void main(String[] args){
	    List<String> list = Arrays.asList("AAA", "BBB", "CCC");
	    // referenciranje static metode
	    list.forEach(PrimjerRefMetoda::staticMetoda);
	    // referenciranje metode koja nije static
	    list.forEach(new PrimjerRefMetoda()::metoda);
	    // referenciranje konstruktora
	    list.forEach(PrimjerRefMetoda::new);
	  }
}

