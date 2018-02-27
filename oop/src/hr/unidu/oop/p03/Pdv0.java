package hr.unidu.oop.p03;
/**
 * Klasa koji slu�i kao primjer prikaza varijabli instance
 */
public class Pdv0 {
    // varijabvla instance - svaki objekt ima svoju kopiju varijable
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
}
