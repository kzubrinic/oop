package hr.unidu.oop.p02;
/**
 * Klasa koji služi kao primjer prikaza varijabli instance
 */
public class Pdv0 {
    /**
     * pdv je varijabla instance (objekta).
     * Svaki objekt ima svoju kopiju varijable pdv. Promjena njezine 
     * vrijedbnosti odnosi se samo na jedan objekt.
     */
    private double pdv = 0;

    public void racPdv(double osn) {
        double iznosPdva;
        iznosPdva = osn * pdv / 100;
        System.out.println("Stopa je " + pdv + " PDV na osnovicu "+ osn + " je " + iznosPdva);
    }
    public boolean postaviStopu(double ns){
    	if (ns < 0) {
    		System.out.println("Stopa ne smije biti negativna!"); 
    		return false;
    	}
        pdv = ns;
        return true;
    }
    public static void main(String[] args) {
    	Pdv0 p1 = new Pdv0();
    	if (!p1.postaviStopu(25)) return;
		
    	Pdv0 p2 = new Pdv0();
    	if (!p2.postaviStopu(10)) return;
    	
    	p1.racPdv(100);
    	p2.racPdv(100);
   	
    }
}
