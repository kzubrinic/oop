/** Vježbe 4
  * Primjer 2
  * primjer naslijeđivanja
  * 3 nivoa naslijeđivanja -životinja, skupine životinja i pojedine životinje 
  * apstraktni razred PorodicaPasa nadređen svim životinjama iz te vrste */
package primjer2;
abstract class PorodicaPasa extends Zivotinja {
	// konkretna metoda za razred PorodicaPasa i sve podredjene
	public void lutanje() {
		System.out.println("Lutam i obilazim svoj teritorij od stabla do stabla!");	
	}
}