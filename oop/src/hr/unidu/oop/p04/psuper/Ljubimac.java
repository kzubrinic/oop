package hr.unidu.oop.p04.psuper;

public class Ljubimac {
	Ljubimac() {
			}
	public static void main(String[] args) {
		Zivotinja p = new Pas("Reks");
		p.glasanje();
		p.lutanje();
		Zivotinja.spavanje(); // metoda KLASE

		// primjer korištenja ključne riječi super
		PorodicaPasa po = new PorodicaPasa("Floki");
		po.glasanje();

	}
}
