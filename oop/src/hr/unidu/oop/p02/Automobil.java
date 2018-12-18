package hr.unidu.oop.p02;
/**
 * Razred Automobil
 * 
 * @author Krunoslav Žubrinić
 * @version December 2018.
 */
public class Automobil 
{
    private String regBroj;
    private int brzina, maxBrzina;
    /**
     * Konstruktor koji postavlja inicijalne podatke vozila
     * @param reg - registracijski broj
     * @param max - maksimalna brzina
     */
    public Automobil(String reg, int max)
    {
        regBroj = reg;
        maxBrzina = max;
    }
    /**
     * Metoda povećava brzinu vozila za zadani korak
     * @param step - korak ubrzanja
     * @return - logička vrijednost je li ubrzanje obavljeno ili nije 
     */
    public boolean ubrzanje(int step) 
    {
        brzina = brzina + step;
        if (brzina >= maxBrzina) 
        {
            brzina = maxBrzina;
            return true;
        }
        else
            return false;
    }
    /**
     * Dohvati trenutnu brzinu - getter/accessor metoda
     * @return - trenutna brzina
     */
    public int getBrzina()
    {
       return brzina; 
    }
    /**
     * Dohvati registracijski broj - getter/accessor metoda
     * @return registracijski broj vozila
     */
    public String getRegBroj()
    {
       return regBroj; 
    }  
}
