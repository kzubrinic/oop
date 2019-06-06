package hr.unidu.oop.p06.tokovi;
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
		return broj % 2 == 0;
	}
}