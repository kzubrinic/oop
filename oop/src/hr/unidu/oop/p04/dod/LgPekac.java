package hr.unidu.oop.p04.dod;
/**
 * Na�in rje�enja probelma vi�estrukog naslije�ivanja u JAVI
 * Konkretna programska logika se mora navesti u svakom razredu najni�e
 * razine. U su�eljima koja se naslije�uju navode se deklaracije metoda
 * koje se moraju navesti u razredima najni�e razine.
 */

public class LgPekac implements CdPekac, DvdPekac {

    /* (non-Javadoc)
     * @see primjer2.CdPekac#pecenjeDiska()
     * Ovdje navodimo konkretnu programsku logiku na�eg razreda tako da
     * je programer odgovoran da napi�e odgovaraju�u programsku logiku.
     */
    
    
    public void kreni(){
        // Ovisno o tome koji se medij stavi u peka�, stvara 
        // se objekt tipa Cd ili Dvd
        Medij m = new Cd();
        //Medij m = new Dvd();
        m.setPrazan(true);
        m.setRw(true);
        m.pecenjeDiska();
    }
    public boolean pecenjeDiska(Cd m){
        if (!m.pecenjeDiska()) {
            System.out.println("Gre�ka kod pe�enja");
            return false;
        }
        System.out.println("Pe�enje CD-a uspje�no!");
        return true;
    }
    public boolean pecenjeDiska(Dvd m){
        if (!m.pecenjeDiska()) {
            System.out.println("Gre�ka kod pe�enja");
            return false;
        }
        System.out.println("Pe�enje DVD-a uspje�no!");
        return true;
    }
}