package hr.unidu.oop.p02;
/**
 * Primjer konstanti u Javi
 */
public class Test{
    /** Konstanta na nivou klase. Kod deklaracije pridružuje joj se
      * vrijednost i ta vrijednost se naknadno ne može promijeniti.
      * Konstante se uobičajeno označavaju velikim slovima s podcrtom 
      * (ako se naziv sastoji od više riječi).
      */
    private static final double MOJ_PI = 3.141;
    /** Parametar označen s final je način na koji se osiguravamo da
      * se u metodi primljena vrijednost parametra ne može promijeniti.
      */
    public void metoda1(final double PROMJER_KRUGA){
        /** Lokalna varijabla označena s final je konstanta na nivou
          * jedne metode. Kod deklaracije pridružuje joj se
          * vrijednost i ta vrijednost se naknadno ne može promijeniti.
          */
        final int X = 5;
        System.out.println("PROMJER_KRUGA = " + PROMJER_KRUGA);
        System.out.println("Lokalni X = " + X);
    }
    public static void main(String[] args) {
     	Test t = new Test();
     	System.out.println("MOJ_PI = " + MOJ_PI);
     	System.out.println("JDK PI = " + Math.PI);
     	t.metoda1(12.76);
    }
}
