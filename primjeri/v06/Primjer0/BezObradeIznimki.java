package Primjer0;
import java.util.*;

/**
 * Primjer obrade iznimki.
 * 
 * @author Krunoslav Žubriniæ
 * @version Travanj 2009.
 */
public class BezObradeIznimki
{
    public static void main(String[] args) {
        BezObradeIznimki o = new BezObradeIznimki();
        o.drugaMetoda();
    }    
    private void drugaMetoda() {
        System.out.println("Uneseni broj je: " + trecaMetoda());
    }
    private int trecaMetoda() {
        return metodaGreska();
    }    
    private int metodaGreska() {
       Scanner a = new Scanner(System.in);
       System.out.print("Unesite broj: ");
       return a.nextInt();
    }
}
