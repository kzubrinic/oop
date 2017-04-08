package Primjer6a;

/**
 * Vježbe 7 Primjer izazivanja iznimne situacija
 * 
 */
import java.util.*;
public class Primjer6 {
	public static void main(String[] args) {
		Obrada ob  = new Obrada();
		try {
			System.out.println("I je " + ob.vrati());
		}
		catch (ArrayIndexOutOfBoundsException izn) {
			System.out.println(izn.getMessage());
			izn.printStackTrace();
		}
		catch (InputMismatchException e) {
			System.out.println("Greška u programu!");
			System.out.println("Za indeks morate unijeti cijeli broj!");
		}
	}
}