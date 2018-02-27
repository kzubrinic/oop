/** Vje�be 4
  * Primjer 2
  * primjer naslije�ivanja
  * 3 nivoa naslije�ivanja -�ivotinja, skupine �ivotinja i pojedine �ivotinje 
  * apstraktni razred PorodicaPasa nadre�en svim �ivotinjama iz te vrste */
package hr.unidu.oop.p04.primjer2;
abstract class PorodicaPasa extends Zivotinja {
	// konkretna metoda za razred PorodicaPasa i sve podredjene
	public void lutanje() {
		System.out.println("Lutam i obilazim svoj teritorij od stabla do stabla!");	
	}
}