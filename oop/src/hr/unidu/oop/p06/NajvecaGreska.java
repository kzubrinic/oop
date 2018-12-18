package hr.unidu.oop.p06;
/**
 * Primjer najveće greške koju možete napraviti
 * pri korištenju iznimki u Javi
 * Krerirati event handler, a ne koristiti ga!
 * 
 * @author Krunoslav Žubrinić
 * @version travanj 2010.
 */
public class NajvecaGreska
{
    public void ispisiNajgore () { 
        int z[]={1,7,9};
        try {
            System.out.println("Treći element je " + z[3]);
        }
        catch (Exception e) {
            // Nemam vremena pa ću 
            // programski kod obrade iznimke napisati 
        	// u nekoj od idućih verzija.
            // Valjda se neće dogoditi neka greška
        }
    }
    public void ispisiDobro1 () { 
        int z[]={1,7,9};
        try {
            System.out.println("Treći element je " + z[3]);
        }
        catch (Exception e) {
            System.out.println("Greška u metodi ispisiDobro ");
            e.printStackTrace();
        }
    }
    
    public void ispisiDobro2 () { 
        int z[]={1,7,9};
        System.out.println("Treći element je " + z[3]);
    }
    
    public static void main(String[] args) {
    	NajvecaGreska k = new NajvecaGreska();
    	k.ispisiDobro1();
    	k.ispisiDobro2();
    	k.ispisiNajgore();
    }
}
