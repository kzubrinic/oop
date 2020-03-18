package hr.unidu.oop.p06;

/**
 * Vježbe 6 Primjer s hvatanjem i obradom grešaka
 * 
 */
import java.util.*;
public class Primjer2  {
  public static void main(String[] args)  {
    Scanner s = new Scanner(System.in);
    float r;
    while(true){
      System.out.print("Unesite polumjer kruga: ");
      try {
         r = s.nextFloat();
      }
      catch (InputMismatchException pogTip) {   
        s.next();  // preskoči pogrešno unesen podatak
        System.out.println("Pogrešan format! Morate unijeti realan broj!");
        continue;
      }
      System.out.println("Opseg kruga je " + 2 * r * Math.PI);
      break;
    }
    s.close();
  }
}
