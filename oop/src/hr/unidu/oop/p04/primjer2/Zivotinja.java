/** Vje�be 4
  * Primjer 2
  * primjer naslje�ivanja
  * 3 nivoa naslje�ivanja -�ivotinja, skupine �ivotinja i pojedine �ivotinje 
  * apstraktni razred Zivotinja kojei je na vrhu hijerarhije   */
package hr.unidu.oop.p04.primjer2;
abstract class Zivotinja {
	String nazivZivotinje, slikaZivotinje;
	//apstraktne metoda koja mora biti implementirana na nizem nivou
	abstract void glasanje();
	abstract void hranjenje();
	// konkretna metoda za razred Zivotinje i sve podredjene
	public void spavanje() {
		System.out.println("Laku noc! Hrrrrrr... Zzzzzzz....");	
	}
}