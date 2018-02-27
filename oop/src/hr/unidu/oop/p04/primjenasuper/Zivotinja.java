package hr.unidu.oop.p04.primjenasuper;

public class Zivotinja {
	String ime;

	Zivotinja(String ime) {
		System.out.println("Izvodi se konstruktor klase Zivotinja");
		this.ime = ime;
	}

	public void glasanje() {
		System.out.println("Glasanje �IVOTINJE!");
	}

	public void hranjenje() {
		System.out.println("Hranjenje �IVOTINJE!");
	}

	public static void spavanje() {
		System.out.println("STATIC spavanje �IVOTINJE!");
	}
}
