package hr.unidu.oop.p02;
/**
 * Klasa koja služi kao primjer korištenja varijabli klase.
 */
public class Pdv1 {
    /**
     * pdv je varijabla klase - svi objekti tipa Pdv1 dijele istu kopiju varijable
     * pdv. Promjena njezine vrijednosti iz bilo kojeg objekta, odmah je vidljiva
     * u svim objektima tipa Pdv1. Koristi se navođenjem imena klase, a
     * ne pojedine instance: Pdv1.pdv
     */
    private static double pdv = 0;

    public void racPdv(double osn) {
        double iznosPdva;
        iznosPdva = osn * Pdv1.pdv / 100;
        System.out.println("Stopa je " + Pdv1.pdv + " PDV na osnovicu "+ osn + " je " + iznosPdva);
    }
    public boolean postaviStopu(double ns){
    	if (ns < 0) {
    		System.out.println("Stopa ne smije biti negativna!"); 
    		return false;
    	}
        Pdv1.pdv = ns;
        return true;
    }
    public static void main(String[] args) {
     	Pdv1 p1 = new Pdv1();
    	if (!p1.postaviStopu(25)) return;
    	Pdv1 p2 = new Pdv1();
    	if (!p2.postaviStopu(10)) return;
    	p1.racPdv(100);
    	p2.racPdv(100);
    }
}
