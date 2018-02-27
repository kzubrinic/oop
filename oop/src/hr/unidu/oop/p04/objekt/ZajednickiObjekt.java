package hr.unidu.oop.p04.objekt;
/**
 * Primjer kori�tenja metoda krovnog razreda Object
 * 
 * @author Krunoslav �ubrini�
 * @version o�ujak 2015.
 */
public class ZajednickiObjekt {
     public void prikaziRezultat() {
        String objekt1 = "Pero Peri�";
        Integer objekt2 = new Integer(127);
        Trokut objekt3 = new Trokut();
        Trokut objekt4 = new Trokut(3, 4, 5);
        System.out.println("Jednakost objekata objekt3 i objekt4 je: "+objekt3.equals(objekt4));
        System.out.println("Hash kod objekta objekta1 je: "+objekt1.hashCode() + ", objekta2 je: "+objekt2.hashCode()+", objekta3: "+objekt3.hashCode() + ", a objekta4: " +objekt4.hashCode());
        System.out.println("String reprezentant objekta1 je:"+objekt1.toString()+"\nobjekta2 je: "+objekt2.toString() + "\nobjekta3 je: "+objekt3.toString()+"\nobjekta4 je: " +objekt4.toString());
    }
}