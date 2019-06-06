package hr.unidu.oop.p04.psuper;

public class Ljubimac {
	Ljubimac() {
		Pas p = new Pas("Reks");
		p.glasanje();
		p.lutanje();
		Zivotinja.spavanje();

		// primjer kori�tenja klju�ne rije�i super
		PorodicaPasa pp = new PorodicaPasa("reks");
		pp.glasanje();
	}

}
