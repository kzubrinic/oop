package hr.unidu.oop.p04.objekt;
/**
 * Primjer korištenja metoda krovnog razreda Object
 * 
 * @author Krunoslav Žubrinić
 * @version veljača 2021.
 */
public class ZajednickiObjekt {
     public void prikaziRezultat() {
        String s1 = "Pero Perić";
        Integer i1 = 127;
        Object objekt1 = s1;
        Object objekt2 = i1;
        Object objekt3 = new Trokut();
        Object objekt4 = new Trokut(3, 4, 5);
        System.out.println("Jednakost objekata objekt3 i objekt4 je: "+objekt3.equals(objekt4));
        System.out.println("Jednakost objekata s1 i objekt1 je: "+s1.equals(objekt1));
        System.out.println("\nHash kod objekta objekta1 je: "+objekt1.hashCode() + ", objekta2 je: "+objekt2.hashCode()+", objekta3: "+objekt3.hashCode() + ", a objekta4: " +objekt4.hashCode());
        System.out.println("\nString reprezentacija\nobjekta1 je: "+objekt1.toString()+"\nobjekta2 je: "+objekt2.toString() + "\nobjekta3 je: "+objekt3.toString()+"\nobjekta4 je: " +objekt4.toString());
    }
     public static void main(String[] args) {
    	 ZajednickiObjekt zo = new ZajednickiObjekt();
    	 zo.prikaziRezultat();
     }
}