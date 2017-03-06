/**
 * Primjer varijabli razreda (static) te
 * getter i setter metoda.
 * 
 * @author Krunoslav Žubrinić
 * @version ožujak 2015.
 */
 
public class Pdv1Ispravna {
    // varijabla instance - vidljiva u čitavoj klasi
    private static double pdv = 25.0;
    private boolean nulta = false;
    
    public static void main(String[] args) {
        Pdv1Ispravna novi=new Pdv1Ispravna();
        System.out.println("Za osnovicu 100, PDV je "+novi.racPdv(100));
    }
    public double racPdv(double osnova) {
        // lokalna varijabla - vidljiva samo u ovoj metodi
        double iznosPdva;

        iznosPdva=osnova*pdv/100;
        return iznosPdva;
    }
    public void novaStopa(double pdv) {
        Pdv1Ispravna.pdv=pdv;
    } 
    public double getStopaPdva() {
          return pdv;
    }
    public boolean isNulta() {
          return nulta;
    }
}