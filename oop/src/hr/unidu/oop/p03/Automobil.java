package hr.unidu.oop.p03;
/**
 * Razred Automobil
 * 
 * @author Krunoslav �ubrini�
 * @version February 2008.
 */
public class Automobil 
{
    private String regBroj;
    private int brzina, maxBrzina;

    public Automobil(String reg, int max)
    {
        regBroj = reg;
        maxBrzina = max;
    }    
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
    public int getBrzina()
    {
       return brzina; 
    }
    public String getRegBroj()
    {
       return regBroj; 
    }  
}
