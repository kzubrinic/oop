package hr.unidu.oop.v02;
import java.util.Scanner;
public class Opseg {
	public static void main(String[] args) {
		System.out.println("Unesite duljinu:");	

		Scanner sc = new Scanner(System.in);

    	int i = sc.nextInt();

		System.out.println("Opseg kvadrata je ");
		System.out.print(i*4); 
		sc.close();
	}
}
