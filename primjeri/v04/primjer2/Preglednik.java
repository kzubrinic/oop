/** Vježbe 4
  * Primjer 2
  * primjer naslijeðivanja
  * 3 nivoa naslijeðivanja -životinja, skupine životinja i pojedine životinje 
  * Glavni program koji testira razrede i njihove metode   */
package primjer2;
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