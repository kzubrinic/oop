package DoD;
/**
 * Naèin rješenja probelma višestrukog naslijeðivanja u JAVI
 * Konkretna programska logika se mora navesti u svakom razredu najniže
 * razine. U suèeljima koja se naslijeðuju navode se deklaracije metoda
 * koje se moraju navesti u razredima najniže razine.
 */

public class LgPekac implements CdPekac, DvdPekac {

    /* (non-Javadoc)
     * @see primjer2.CdPekac#pecenjeDiska()
     * Ovdje navodimo konkretnu programsku logiku našeg razreda tako da
     * je programer odgovoran da napiše odgovarajuæu programsku logiku.
     */
    
    
    public void kreni(){
        // Ovisno o tome koji se medij stavi u pekaè, stvara 
        // se objekt tipa Cd ili Dvd
        Medij m = new Cd();
        //Medij m = new Dvd();
        m.setPrazan(true);
        m.setRw(true);
        m.pecenjeDiska();
    }
    public boolean pecenjeDiska(Cd m){
        if (!m.pecenjeDiska()) {
            System.out.println("Greška kod peèenja");
            return false;
        }
        System.out.println("Peèenje CD-a uspješno!");
        return true;
    }
    public boolean pecenjeDiska(Dvd m){
        if (!m.pecenjeDiska()) {
            System.out.println("Greška kod peèenja");
            return false;
        }
        System.out.println("Peèenje DVD-a uspješno!");
        return true;
    }
}