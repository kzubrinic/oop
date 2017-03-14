/** Vježbe 4
  * Primjer 2
  * primjer naslijeðivanja
  * 3 nivoa naslijeðivanja -životinja, skupine životinja i pojedine životinje 
  * razred Pas opisuje životinje te vrste */
package primjer2;
public class Pas extends PorodicaPasa implements KucniLjubimci{
	public void glasanje() {
		System.out.println("Vau, vau, ja sma èuvar kuæe! Dobar vam dan!");	
	}
	public void hranjenje() {
		System.out.println("Koja kost dobro bi mi došla...");	
	}
	public void zivotUStanu(){
        System.out.println("Vau, vau! U stanu imam svoje mjesto za spavanje i lopticu za igranje!"); 
    }
}