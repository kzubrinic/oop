/** Vje�be 4
  * Primjer 2
  * primjer naslije�ivanja
  * 3 nivoa naslije�ivanja -�ivotinja, skupine �ivotinja i pojedine �ivotinje 
  * Glavni program koji testira razrede i njihove metode   */
package hr.unidu.oop.p04.primjer2;
public class Preglednik {
	public static void main(String[] args) {
		Macka m=new Macka();
		System.out.println("MACKA");
		m.glasanje();
		m.hranjenje();
		m.spavanje();
		Hipo p=new Hipo();
		System.out.println("HIPPO");
		p.glasanje();
		p.hranjenje();
		p.spavanje();
		Sismis s=new Sismis();
		System.out.println("SISMIS");
		s.glasanje();
		s.hranjenje();
		s.spavanje();
		s.letenje();
		// nadopunite za ostale zivotinje
	}
}