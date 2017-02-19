// Primjer konstanti
public class Test{
    // Konstanta na nivou klase. Kod deklaracije pridružuje joj se
    // vrijednost i ta vrijednost se naknadno ne može promijeniti.
    // Konstante se uobièajno oznaèavaju velikim slovima s podcrtom 
    // (ako se naziv sastoji od više rijeèi).
    public static final double PI = 3.141;
    // parametar oznaèen s final je naèin na koji se osiguravamo da
    // se u metodi primljena vrijednost parametra ne može promijeniti.
    public void metoda1(final double PROMJER_KRUGA){
        // lokalna varijabla oznaèena s final je konstanta na nivou
        // jedne metode. Kod deklaracije pridružuje joj se
        // vrijednost i ta vrijednost se naknadno ne može promijeniti.
        final int X = 5;
    }
}
