package hr.unidu.oop.p04.psuper;

public class PorodicaPasa extends Zivotinja {
	PorodicaPasa(String ime) {
		super(ime);
		System.out.println("Izvodi se konstruktor klase PorodicaPasa");
	}

	public void lutanje() {
		System.out.println("Lutanje PORODICE PASA!");
	}

	public void glasanje() {
		super.glasanje();
	}
}
