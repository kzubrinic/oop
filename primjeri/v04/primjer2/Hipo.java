/** Vježbe 4
  * Primjer 2
  * primjer naslijeđivanja
  * 3 nivoa naslijeđivanja -životinja, skupine životinja i pojedine životinje 
  * razred Hipo opisuje životinje te vrste */
package primjer2;
public class Hipo extends Zivotinja {
	public void glasanje() {
		System.out.println("Ja sam Hiippoooooo dobar vam dan!");	
	}
	public void hranjenje() {
		System.out.println("Njam, njam, kupam se ronim i hranim raznim biljem.");	
	}
}