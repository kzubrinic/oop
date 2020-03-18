package hr.unidu.oop.p06;
import java.util.*;

/**
 * Primjer obrade iznimki.
 * 
 * @author Krunoslav Žubrinić
 * @version Travanj 2009.
 */
public class ObradaIznimki{
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
        ObradaIznimki o = new ObradaIznimki();
        while(true){
	        try {
	          o.drugaMetoda(s);
	          break;
	        }
	        catch (InputMismatchException pogTip) { 
	          System.out.println("Tip podataka nije odgovarajuć!");
	          System.out.println("Morate unijeti cijeli broj!");
	        }
        }
        s.close();
    }    
    private void drugaMetoda(Scanner a) throws InputMismatchException{
        System.out.println("Uneseni broj je: " + trecaMetoda(a));
    }
    private int trecaMetoda(Scanner a) throws InputMismatchException{
        return metodaGreska(a);
    }    
    private int metodaGreska(Scanner a) throws InputMismatchException{
        System.out.print("Unesite broj: ");
        return a.nextInt();
    }
}
