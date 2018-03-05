package hr.unidu.oop.p02;
/**
 * Klasa koji služi kao primjer prikaza varijabli instance
 */
public class Pdv0 {
    // varijabla instance - svaki objekt ima svoju kopiju varijable
    // pdv. promjena njezine vrijedbnosti odnosi se samo na jedan objekt.
    public double pdv = 0;

    public void racPdv(double osn) {
        double iznosPdva;
        iznosPdva = osn * pdv / 100;
        System.out.println("PDV na osnovicu "+ osn + " je " + iznosPdva);
    }
    public void postaviStopu(double ns){
        pdv = ns;
    }
    public static void main(String[] args) {
    	Pdv0 p1 = new Pdv0();
    	p1.postaviStopu(25);
    	Pdv0 p2 = new Pdv0();
    	p2.postaviStopu(10);
    	p1.racPdv(100);
    	p2.racPdv(100);
    	
    }
}
