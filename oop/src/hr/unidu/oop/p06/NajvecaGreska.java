package hr.unidu.oop.p06;
/**
 * Primjer najve�e gre�ke koju mo�ete napraviti
 * pri kori�tenju iznimki u Javi
 * Krerirati event handler, a ne koristiti ga!
 * 
 * @author Krunoslav �ubrini�
 * @version travanj 2010.
 */
import java.util.*;
public class NajvecaGreska
{
    public void ispisiNajgore () { 
        int z[]={1,7,9};
        try {
            System.out.println("Tre�i element je " + z[3]);
        }
        catch (Exception e) {
            // Nemam vremena pa �u obradu iznimki pa �u
            // programski kod napisati u idu�oj verziji.
            // Valjda se ne�e dogoditi neka gre�ka
        }
    }
    public void ispisiDobro1 () { 
        int z[]={1,7,9};
        try {
            System.out.println("Tre�i element je " + z[3]);
        }
        catch (Exception e) {
            System.out.println("Gre�ka u metodi ispisiDobro ");
            e.printStackTrace();
        }
    }
    
    public void ispisiDobro2 () { 
        int z[]={1,7,9};
        System.out.println("Tre�i element je " + z[3]);
    }
}
