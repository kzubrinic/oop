/** Vje�be 4
  * Primjer 2
  * primjer naslije�ivanja
  * 3 nivoa naslije�ivanja -�ivotinja, skupine �ivotinja i pojedine �ivotinje 
  * razred Pas opisuje �ivotinje te vrste */
package hr.unidu.oop.p04.primjer2;
public class Pas extends PorodicaPasa implements KucniLjubimci{
	public void glasanje() {
		System.out.println("Vau, vau, ja sma �uvar ku�e! Dobar vam dan!");	
	}
	public void hranjenje() {
		System.out.println("Koja kost dobro bi mi do�la...");	
	}
	public void zivotUStanu(){
        System.out.println("Vau, vau! U stanu imam svoje mjesto za spavanje i lopticu za igranje!"); 
    }
}