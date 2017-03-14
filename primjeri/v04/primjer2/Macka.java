/** Vježbe 4
  * Primjer 2
  * primjer naslijeðivanja
  * 3 nivoa naslijeðivanja -životinja, skupine životinja i pojedine životinje 
  * razred Macka opisuje životinje te vrste */
package primjer2;
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