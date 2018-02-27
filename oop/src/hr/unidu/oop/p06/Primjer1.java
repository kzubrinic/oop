package hr.unidu.oop.p06;

/**
 * Vje�be 7 Primjer kori�tenja klase Scanner bez hvatanja gre�aka
 * 
 */
import java.util.*;
public class Primjer1 {
  public static void main(String[] args)  {
    Scanner a = new Scanner(System.in);
	  System.out.print("Unesite broj: ");
	  int b = a.nextInt();
    System.out.println(b);
    }
}
