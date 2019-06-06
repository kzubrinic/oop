package hr.unidu.oop.p05;
/**
 * ArrayList
 *
 * @author Krunoslav �ubrini�
 * @version travanj 2015.
 */

import java.util.*;

public class PrimjerListe {
    // lista cijelih brojeva
    List<Integer> lista1;
    // lista objekata (u nju ulazi bilo koji tip)
    List<Object> lista2;
    Integer broj1;
    String niz1;
    Enter u;

    public void start() {
        listaCijelih();
        listaSvih();

    }

    private void listaCijelih() {
        Integer broj;
        // implementacija liste stati�kim poljem
        lista1 = new ArrayList<>(3);
        u = new Enter();

        // dodaj element na kraj liste
        addBroj();
        // dodaj element na zadanu poziciju liste 
        lista1.add(1, 9999);
        // Čitaj sve elemente liste (klasi�an for)
        for (int i = 0; i < lista1.size(); i++) {
            broj = lista1.get(i);
            System.out.println("Na poziciji " + i + " je broj: " + broj);
        }
        // brisanje podatka sa zadane pozicije
        broj = lista1.remove(0);
        System.out.println("Izbrisan broj " + broj + " s prve pozicije.");
        // brisanje zadanog elementa
        broj = 9999;
        if (lista1.contains(broj)) {
            lista1.remove(broj);
            System.out.println("Obrisan broj " + broj);
        } else
            System.out.println(broj + " se ne nalazi u listi!");
        // sortiraj elemente
        Collections.sort(lista1);
        // �itaj sve elemente liste (for-each)  - sortirani ispis
        for (Integer el : lista1) {
            System.out.println("Broj: " + el);
        }
    }

    private void listaSvih() {
        Integer broj;
        String niz;
        Object o;
        // implementacija liste vezanom listom
        lista2 = new LinkedList<>();
        u = new Enter();

        // dodaj element na kraj liste
        addNiz();
        lista2.add(1, 9999);
        // �itaj sve elemente liste (klasi�an for)        
        for (int i = 0; i < lista2.size(); i++) {
            if (lista2.get(i) instanceof Integer) {
                broj = (Integer) lista2.get(i);
                System.out.println("Na poziciji " + i + " je broj: " + broj);
            } else if (lista2.get(i) instanceof String) {
                niz = (String) lista2.get(i);
                System.out.println("Na poziciji " + i + " je niz: " + niz);
            } else
                System.out.println("Na poziciji " + i + " je podatak nepoznatog tipa");
        }
        // brisanje podatka sa zadane pozicije
        o = lista2.remove(0);
        System.out.println("Izbrisan podatak " + o + " s prve pozicije.");
        // brisanje zadanog elementa
        broj = 9999;
        if (lista2.contains(broj)) {
            lista2.remove(broj);
            System.out.println("Obrisan broj " + broj);
        } else
            System.out.println(broj + " se ne nalazi u listi!");
        // Čitaj sve elemente liste (for-each)
        for (Object el : lista2) {
            System.out.println("Element: " + el);
        }
    }

    private void addBroj() {
        int a;
        while (true) {
            a = u.addInt("Unesi cijeli broj (0 za kraj):");
            if (a == 0)
                break;
            lista1.add(a);
        }
    }

    private void addNiz() {
        String s;
        int a;
        while (true) {
            a = u.addInt("Unesi cijeli broj (0 za kraj):");
            if (a == 0)
                break;
            lista2.add(a);
        }
        while (true) {
            s = u.addString("Unesi niz znakova (\"x\" za kraj):");
            if (s.equals("x"))
                break;
            lista2.add(s);
        }
    }

    public static void main(String[] args) {
        PrimjerListe p = new PrimjerListe();
        p.listaCijelih();
        p.listaSvih();
    }
}