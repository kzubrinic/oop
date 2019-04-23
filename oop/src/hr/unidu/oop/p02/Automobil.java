package hr.unidu.oop.p02;
/**
 * Klasa Automobil
 */
public class Automobil{
	/**
	 * Varijabla instance koja čuva registracijski broj
	 */
    private String regBroj;
    /**
	 * Varijabla instance koja čuva trenutnu brzinu vozila
	 */
    private int brzina;
    /**
	 * Varijabla instance koja čuva maksimalnu brzinu vozila
	 */
    private int maxBrzina;
    /**
     * Konstruktor koji postavlja inicijalne podatke vozila
     * @param reg - registracijski broj
     * @param max - maksimalna brzina
     */
    public Automobil(String reg, int max){
        regBroj = reg;
        maxBrzina = max;
    }
    /**
     * Metoda povećava trenutnu brzinu vozila za zadani korak
     * @param step - korak ubrzanja
     * @return - logička vrijednost je li ubrzano ili nije 
     */
    public boolean ubrzanje(int step){
        brzina = brzina + step;
        if (brzina >= maxBrzina){
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
    public int getBrzina(){
       return brzina; 
    }
    /**
     * Dohvati registracijski broj - getter/accessor metoda
     * @return registracijski broj vozila
     */
    public String getRegBroj(){
       return regBroj; 
    }  
}
