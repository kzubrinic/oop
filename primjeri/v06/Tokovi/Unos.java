package Tokovi;
/**
 * standardne metode vezane uz unos podataka
 */

import java.util.Scanner;
public class Unos {
	private Scanner sc;
	public double unesiDouble(String poruka) {
		System.out.print(poruka);
		sc = new Scanner(System.in);
		return sc.nextDouble();
	}
	public int unesiInt(String poruka) {
		System.out.print(poruka);
		sc = new Scanner(System.in);
		return sc.nextInt();
	}
	public String unesiString(String poruka) {
		System.out.print(poruka);
		sc = new Scanner(System.in);
		return sc.next();
	}	
	public String unesiLiniju(String poruka) {
		System.out.print(poruka);
		sc = new Scanner(System.in);
		return sc.nextLine();
	}
	public boolean paranBroj(double broj) {
		if (broj%2 == 0) {
			return true;
		}
		else {
			return false;
		}	
	}
}