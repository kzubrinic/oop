/** Vježbe 4
  * Primjer 2
  * primjer nasljeðivanja
  * 3 nivoa nasljeðivanja -životinja, skupine životinja i pojedine životinje 
  * apstraktni razred Zivotinja kojei je na vrhu hijerarhije   */
package primjer2;
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