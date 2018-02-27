package hr.unidu.oop.p05.kolekcije;
/**
 * implements iterface Set
 */
import java.util.*;

public class PrimjerSkupa {
  private Set<String> set;
  private Set<String> sortedSet;
  private List<String> list;
  public void start() {
    
    
    System.out.println("Stvorena ArrayLista s 5 elemenata (2 jednaka)");  
    list = new ArrayList<String>();
    list.add("Ivo");
    list.add("Ana");
    list.add("Vlaho");
    list.add("Ana");
    list.add("Kate");
    System.out.println(list);
    set = new HashSet<String>(list);
    System.out.println("Ovo je implementacija hash seta iz liste"); 
    System.out.println(set);
    // implementation of sorted set!
    System.out.println("Ovo je (sortirana) implementacija TreeSet"); 
    sortedSet = new TreeSet<String>(set);
    System.out.println(sortedSet);  
  }    
}