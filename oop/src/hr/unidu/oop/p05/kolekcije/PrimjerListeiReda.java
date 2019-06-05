package hr.unidu.oop.p05.kolekcije;
/**
 * implements interface List
 */
import java.util.*;
public class PrimjerListeiReda {
  public void startl() {
    System.out.println("Implementacija ArrayList-om");
    List<String> list = new ArrayList<>();
    list.add("Ivo");
    list.add("Ana");
    list.add("Vlaho");
    list.add("Ana");
    list.add("Kate");
    System.out.println("5 elemenata dodano u listu"); 
    System.out.println(list);
    System.out.println("3. element: " + list.get(2));
    System.out.println("1. element: " + list.get(0));
    // Ispis pomoću iteratora
    System.out.println("Ispis pomoću iteratora");
    for (ListIterator<String> it = list.listIterator(); it.hasNext(); ) {
        String el = it.next();
        System.out.println(el);
    }
    System.out.println("Izmjene elemenata liste pomoću iteratora");
    for (ListIterator<String> it = list.listIterator(); it.hasNext(); ) {
        String el = it.next();
        //it.set(el.toUpperCase());
        el.toUpperCase();

    }
    for (ListIterator<String> it = list.listIterator(); it.hasNext(); ) {
        String el = it.next();
        System.out.println(el);
    }
    
    System.out.println("Implementacija reda linkanom listom - preba�eni podaci prethodne liste");
    Deque<String> red = new LinkedList<>(list);
    System.out.println(red);
    red.addFirst("Ivo");
    red.addFirst("Ana");
    red.addFirst("Vlaho");
    red.addFirst("Ana");
    red.addFirst("Kate");
    System.out.println("5 elemenata dodano u red"); 
    System.out.println(red);
    System.out.println("2 elementa uklonjena s repa reda"); 
    System.out.println(red.removeLast());
    System.out.println(red.removeLast());
    System.out.println("1 element uklonjen s glave reda"); 
    System.out.println(red.removeFirst());
    System.out.println(red);
  }
}