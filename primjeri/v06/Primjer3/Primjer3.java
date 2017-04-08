package Primjer3;

/**
 * Vježbe 7 Primjer spuštanje greške do razine na kojoj
 * se vrši njezina obrada
 * 
 */
public class Primjer3 {
	public static void main(String[] args) {
		Obrada ob = new Obrada();
		try {
			System.out.println("I je " + ob.vrati());
		}
		catch (ArrayIndexOutOfBoundsException izn) {
			System.out.println("Greška u programu!");
			System.out.println("Traženi element matrice ne postoji!");
		}
	}
}


