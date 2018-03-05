package hr.unidu.oop.p02;

public class TestirajPrivatniKonstruktor {
	public static void main(String[] args) {
		// Ovako se NE MOŽE stvoriti objekt koji ima private konstriktor!
		// PrivatniKonstruktor p = new PrivatniKonstruktor();
		
		// Ovako se stvara takav objekt - pozivom tvorničke metode klase
		PrivatniKonstruktor p = PrivatniKonstruktor.stvoriObjekt();
		System.out.println(p);

	}
}
