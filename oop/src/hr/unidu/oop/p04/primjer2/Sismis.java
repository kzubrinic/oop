/** Vje�be 4
  * Primjer 2
  * primjer naslije�ivanja
  * 3 nivoa naslije�ivanja -�ivotinja, skupine �ivotinja i pojedine �ivotinje 
  * naknadni pridoslica posebne vrste */
package hr.unidu.oop.p04.primjer2;
public class Sismis extends Zivotinja {
	boolean nocnaZivotinja=true;
	public void glasanje() {
		System.out.println("Mene ne cujete jer sam necujan po noci");	
	}
	public void hranjenje() {
		System.out.println("Musice male, musice slatke...");	
	}
	public void spavanje() {
		System.out.println("Ja sam poseban jer spavam naglavacke i po danu!");	
	}
	public void letenje() {
		System.out.println("Ja i letim!");	
	}
}