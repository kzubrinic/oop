package hr.unidu.oop.p02;

public class TestirajPrivatniKonstruktor {
	public static void main(String[] args) {
		// Ovako se NE MOŽE stvoriti objekt koji ima private konstruktor!
		// PrivatniKonstruktor p = new PrivatniKonstruktor();
		
		// Ovako se stvara takav objekt - pozivom tvorničke metode klase
		PrivatniKonstruktor p1 = PrivatniKonstruktor.stvoriObjekt();
		System.out.println(p1);
		// Metoda će vratiti referencu na isti objekt
		PrivatniKonstruktor p2 = PrivatniKonstruktor.stvoriObjekt();
		System.out.println(p2);
		// Ispisuje true jer se radi o istom objektu (a dvije varijable reference).
		System.out.println(p1.equals(p2));
	}
}
