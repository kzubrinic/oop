package hr.unidu.oop.p03;
// Primjer konstanti
public class Test{
    // Konstanta na nivou klase. Kod deklaracije pridru�uje joj se
    // vrijednost i ta vrijednost se naknadno ne mo�e promijeniti.
    // Sucelje se uobi�ajno ozna�avaju velikim slovima s podcrtom
    // (ako se naziv sastoji od vi�e rije�i).
    public static final double PI = 3.141;
    // parametar ozna�en s final je na�in na koji se osiguravamo da
    // se u metodi primljena vrijednost parametra ne mo�e promijeniti.
    public void metoda1(final double PROMJER_KRUGA){
        // lokalna varijabla ozna�ena s final je konstanta na nivou
        // jedne metode. Kod deklaracije pridru�uje joj se
        // vrijednost i ta vrijednost se naknadno ne mo�e promijeniti.
        final int X = 5;
    }
}
