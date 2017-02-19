/**
 * Razred koji služi kao primjer varijabli instance
 */
public class Pdv1 {
    // varijabla razreda - svi objekti tipa Pdv1 dijele istu kopiju varijable
    // pdv. Promjena njezine vrijednosti iz bilo kojeg objekta, odmah je vidljiva
    // us vim objektima tipa Pdv1.
    public static double pdv = 0;

    public void racPdv(double osn) {
        double iznosPdva;
        iznosPdva = osn * pdv / 100;
        System.out.println("PDV na osnovicu "+ osn + " je " + iznosPdva);
    }
    public void postaviStopu(double ns){
        pdv = ns;
    }
}
