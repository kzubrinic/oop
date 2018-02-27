package hr.unidu.oop.p01;
 

public class Scope{
    // varijabla je vidljiva u �itavoj klasi
    int a=0;
    public void metoda() {
        int a=1;
        // verzija varijable a deklarirana u ovoj metodi vidljiva je
        // samo u toj metodi
        System.out.println ("a u metodi 'metoda' = " + a);
        // varijabla i je vuidljiva samo u for petlji
        for (int i=0; i<1;i++) {
            System.out.println ("i u for bloku = " + i);
        }
        // Varijabla i je vidljiva samo u for bloku
        //i = 9;
    }
    public void metoda2() {
        // verzija varijable a deklarirana van metoda
        System.out.println ("a van metoda = " + a);
    }
    public static void main(String[] args) {
    	Scope c = new Scope();
    	c.metoda();
    	c.metoda2();
    }
}
