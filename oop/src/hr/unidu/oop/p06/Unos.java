package hr.unidu.oop.p06;


/**
 * Primjer kori�tenja try-with-resource naredbe za automatsko
 * zatvaranje objekta navedenog unutar te naredbe
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Unos
{
    /**
     * metoda koja koristi try-with-resource
     */
    public void unosAutomatskoZatvaranje() {
        try (Scanner s = new Scanner(System.in)) {
            String n = s.nextLine();
            System.out.println("Unesen je niz: " + n);
        }
    }
    
    /**
     * metoda koja NE koristi try-with-resource pa resurs treba
     * zatvoriti ru�no.
     */
    public void unosRucnoZatvaranje() {
        Scanner s = new Scanner(System.in);
        String n = s.nextLine();
        System.out.println("Unesen je niz: " + n);
        s.close();
    }

}
