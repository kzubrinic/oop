package hr.unidu.oop.p06.iznimke;
import java.util.*;

/**
 * Primjer obrade iznimki.
 * 
 * @author Krunoslav �ubrini�
 * @version Travanj 2009.
 */
public class ObradaIznimki
{
    public static void main(String[] args) {
        ObradaIznimki o = new ObradaIznimki();
        while(true){
        try {
          o.drugaMetoda();
          break;
        }
        catch (InputMismatchException pogTip) { 
          System.out.println("Tip podataka nije odgovaraju�!");
          System.out.println("Morate unijeti cijeli broj!");
        }
    }
    }    
    private void drugaMetoda() throws InputMismatchException {
        System.out.println("Uneseni broj je: " + trecaMetoda());
    }
    private int trecaMetoda() throws InputMismatchException {
        return metodaGreska();
    }    
    private int metodaGreska() throws InputMismatchException{
       Scanner a = new Scanner(System.in);
       System.out.print("Unesite broj: ");
       return a.nextInt();
    }
}
