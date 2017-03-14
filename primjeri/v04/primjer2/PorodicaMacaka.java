/** Vježbe 4
  * Primjer 2
  * primjer nasljeðivanja
  * 3 nivoa naslijeðivanja -životinja, skupine životinja i pojedine životinje 
  * apstraktni razred PorodicaMacaka nadreðen svim životinjama iz te vrste */
package primjer2;
abstract class PorodicaMacaka extends Zivotinja {
	// konkretna metoda za razred PorodicaMacaka i sve podredjene
	public void lutanje() {
		System.out.println("Lutam i odlazim od kuce malo se prosetati i vidjeti sto ima novoga u svijetu!");	
	}
}