package hr.unidu.oop.p05;
/**
 * implements interface List
 */
import java.util.*;
public class PrimjerListeiReda {
  public PrimjerListeiReda() {
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
    ispis(list);
    izmjena(list, true);
    ispis(list);

    System.out.println("Implementacija Vektora");
    Vector<String> v = new Vector<>(list);
    ispis(v);
    izmjena(v, false);
    ispis(v);

    System.out.println("Implementacija reda linkanom listom - prebačeni " +
            "podaci prethodne liste");
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

  private void ispis(List<String> l){
    // Ispis pomoću iteratora
    System.out.println("Ispis pomoću iteratora");
    for (ListIterator<String> it = l.listIterator(); it.hasNext(); ) {
      System.out.println(it.next());
    }
  }
  // Izmjena liste pomoću iteratora
  private void izmjena(List<String> l, boolean ucase){
    System.out.println("Izmjene elemenata liste pomoću iteratora");
    for (ListIterator<String> it = l.listIterator(); it.hasNext(); ) {
      String el = it.next();
      if (ucase)
        it.set(el.toUpperCase());
      else
        it.set(el.toLowerCase());
    }
  }

  public static void main(String[] args) {
    new PrimjerListeiReda();
  }
}