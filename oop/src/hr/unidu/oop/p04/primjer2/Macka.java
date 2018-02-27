/** Vje�be 4
  * Primjer 2
  * primjer naslije�ivanja
  * 3 nivoa naslije�ivanja -�ivotinja, skupine �ivotinja i pojedine �ivotinje 
  * razred Macka opisuje �ivotinje te vrste */
package hr.unidu.oop.p04.primjer2;
public class Macka extends PorodicaMacaka implements KucniLjubimci{
    public void glasanje() {
        System.out.println("Mijauuuu, mijau,...!"); 
    }
    public void hranjenje() {
        System.out.println("Malo mlijeka, tu i tamo whiskas...");   
    }
    public void zivotUStanu(){
        System.out.println("U stanu imam svoju kosaru i klupko vune!"); 
    }
}