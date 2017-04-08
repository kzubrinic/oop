package Primjer5a;
/**
 * Primjer najveæe greške koju možete napraviti
 * pri korištenju iznimki u Javi
 * Krerirati event handler, a ne koristiti ga!
 * 
 * @author Krunoslav Žubriniæ
 * @version travanj 2010.
 */
import java.util.*;
public class NajvecaGreska
{
    public void ispisiNajgore () { 
        int z[]={1,7,9};
        try {
            System.out.println("Treæi element je " + z[3]);
        }
        catch (Exception e) {
            // Nemam vremena pa æu obradu iznimki pa æu
            // programski kod napisati u iduæoj verziji.
            // Valjda se neæe dogoditi neka greška
        }
    }
    public void ispisiDobro1 () { 
        int z[]={1,7,9};
        try {
            System.out.println("Treæi element je " + z[3]);
        }
        catch (Exception e) {
            System.out.println("Greška u metodi ispisiDobro ");
            e.printStackTrace();
        }
    }
    
    public void ispisiDobro2 () { 
        int z[]={1,7,9};
        System.out.println("Treæi element je " + z[3]);
    }
}
