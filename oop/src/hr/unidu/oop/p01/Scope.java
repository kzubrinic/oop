package hr.unidu.oop.p01;
 
/**
 * Primjer različitih vidljivosti varijable (klasa, metoda i blok naredbi)
 */
public class Scope{
    /**
     * Varijabla "a" je varijabla instance (objekta) vidljiva 
     * u čitavoj klasi.
     */
    int a=0;
    /**
     * Demonstracija vidljivosti lokalne varijable
     */
    public void metoda() {
        int a=1;
        // verzija varijable "a" deklarirana u ovoj metodi vidljiva je
        // samo u toj metodi
        System.out.println ("a u metodi 'metoda' = " + a);
        // varijabla "i" je vidljiva samo u for petlji (bloku naredbi)
        for (int i=0; i<10;i++) {
            System.out.println ("i u for bloku = " + i);
        }
    }
    /**
     * Demonstracija vidljivosti varijable instance
     */
    public void metoda2() {
        // Koristi se verzija varijable "a" deklarirana van metoda koja je vidljiva
    	//  u čitavoj klasi.
        System.out.println ("a van metoda = " + a);
    }
    
    public static void main(String[] args) {
    	Scope c = new Scope();
    	c.metoda();
    	c.metoda2();
    }
}
