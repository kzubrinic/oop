package hr.unidu.oop.p06;

/**
 * Vježbe 6 Primjer korištenja klase Scanner bez hvatanja grešaka
 * 
 */
import java.util.*;

public class Primjer1 {
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		System.out.print("Unesite broj: ");
		int b = a.nextInt();
		System.out.println(b);
	}
}
