package hr.unidu.oop.p05;
/**
 * implements interface Map
 */
import java.util.*;
public class PrimjerMape {
  private Map<Integer, String> map;
  private Map<Integer, String> sortedMap;
  public void start() {
    System.out.println("Ovo je HashMap implementacija");  
    map = new HashMap<>();

    map.put(72,"Ivo");
    map.put(2,"Ana");
    map.put(3132,"Vlaho");
    map.put(1,"Ana");
    map.put(4215,"Kate");
    System.out.println("5 elemenata dodano u mapu"); 
    System.out.println(map);
    System.out.println("Ovo je (sortirana!) implementacija TreeMap"); 
    sortedMap = new TreeMap<>(map);
    System.out.println(sortedMap);
    // Ispiši vrijednosti mape
    System.out.println("Dohvaćene vrijednosti");
    for (String a : sortedMap.values()) 
        System.out.println(a);
    // Izmjene elemenata mape - s istim ključem zapisi novu vrijednost
    map.put(4215,"Katica");
    // Ispiši ključeve mape
        System.out.println("Dohvaćeni ključevi");
    for (Integer i : sortedMap.keySet()) 
        System.out.println(i);
        
       

  }
}