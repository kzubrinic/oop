package hr.unidu.oop.p04.primjenasuper;

public class Pas extends PorodicaPasa {
	Pas(String ime) {
		super(ime);
		System.out.println("Izvodi se konstruktor klase Pas");
	}

	public void glasanje() {
		System.out.println("Glasanje PSA!");
	}

	public void hranjenje() {
		System.out.println("Hranjenje PSA!");
	}

	public static void spavanje() {
		System.out.println("STATIC spavanje PSA!");
	}
}
