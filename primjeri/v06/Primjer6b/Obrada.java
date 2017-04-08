package Primjer6b;
/**
 * Vje�be 7 Primjer izazivanja iznimne situacije
 * 
 */
import java.util.*;
public class Obrada {
    public static void main (String[] args) {
      float r; 
      Scanner s = new Scanner(System.in);
      while(true){
          System.out.print("Unesite polumjer kruga: ");
          try {
              r = s.nextFloat();
              if (r <=0)
                throw new PolumjerException("Polumjer ["+r+"] mora biti pozitivan!");
          }
          catch (InputMismatchException pogTip) {   
             s.next();  // presko�i pogre�no unesen podatak
             System.out.println("Pogre�an format! Morate unijeti realan broj!");
             continue;
          }
          catch (PolumjerException e) {   
             System.out.println(e.getMessage());
             continue;
          }
          System.out.println("Opseg kruga je " + 2 * r * Math.PI);
          break;
    }
    }
}


