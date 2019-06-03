package hr.unidu.oop.p01;
/**
 * Primjer pridruživanja vrijednosti varijablama
 * ispravne i neispravne metode
 */ 
public class Varijable{
	/**
	 * Prikaz greške gdje varijabla prije korištenja nije inicijalizirana
	 */
    public void koristenjeVarijablePogresno(){
        int suma;
        // Program se ne može prevesti i izvesti jer varijabla "suma" 
        // prije korištenja nije inicijalizirana!
        // Varijabla se prije prvog korištenja na desnoj strani izraza 
    	// mora inicijalizirati
        // Kod inicijalizacije, vrijednost je trebala biti postavljena 
        // na početnu vrijednost (primjerice 0) naredbom 
        //   int suma = 0;
        suma = suma + 2;
        System.out.println(suma);
    }
    /**
     * Korištenje varijable koja je prije korištenja inicijalizirana
     */
    public void koristenjeVarijableIspravno(){
        int suma = 0;
        suma = suma + 2;
        System.out.println(suma);
    }
    /**
     * Spremanje vrijednosti iz podatka "većeg" tipa u podatak "manjeg" tipa
     * Potencijalna greška, pa se program ne može prevesti
     */
    public void gubitakPreciznostiPogresno(){
        int x = 24;
        // Greška - mogući gubitak podataka
        // Program se ne može prevesti jer se veći 32-bitni podatak 
        // tipa int pokušava spremiti u manji 8-bitni prostor rezerviran 
        // za podatak tipa byte.
        byte y = x;
        System.out.println(y);
    }
    /**
     * Spremanje vrijednosti iz podatka "većeg" tipa u podatak "manjeg" tipa
     * na ispravan način.
     */
    public void gubitakPreciznostiIspravno(){
        int x = 24;
        // Svjesni smo mogućeg gubitka i svjesno vršimo pretvorbu 
        // iz 32-bitnog u 8-bitni tip podatka.
        byte y = (byte)x;
        System.out.println(y);
    }
    
    public static void main(String[] args) {
    	Varijable v = new Varijable();
    	v.koristenjeVarijablePogresno();
    	v.koristenjeVarijableIspravno();
    	v.gubitakPreciznostiPogresno();
    	v.gubitakPreciznostiIspravno();
    }
}
