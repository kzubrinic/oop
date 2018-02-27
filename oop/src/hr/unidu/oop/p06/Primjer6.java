package hr.unidu.oop.p06;

/**
 * Vje�be 7 Primjer spu�tanje gre�ke do razine na kojoj
 * se vr�i njezina obrada uz ispis stabla iznimke
 * 
 */
public class Primjer6 {
	public static void main(String[] args) {
		Obrada ob  = new Obrada();
		try {
			System.out.println("I je " + ob.vrati());
		}
		catch (ArrayIndexOutOfBoundsException izn) {
			System.out.println("Gre�ka u programu!");
			System.out.println("Tra�eni element matrice ne postoji!");
			System.out.println(izn.getMessage());
			izn.printStackTrace();
		}
	}
}


