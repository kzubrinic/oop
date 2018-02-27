/** Vje�be 4
  * Primjer 2
  * primjer naslje�ivanja
  * 3 nivoa naslije�ivanja -�ivotinja, skupine �ivotinja i pojedine �ivotinje 
  * apstraktni razred PorodicaMacaka nadre�en svim �ivotinjama iz te vrste */
package hr.unidu.oop.p04.primjer2;
abstract class PorodicaMacaka extends Zivotinja {
	// konkretna metoda za razred PorodicaMacaka i sve podredjene
	public void lutanje() {
		System.out.println("Lutam i odlazim od kuce malo se prosetati i vidjeti sto ima novoga u svijetu!");	
	}
}