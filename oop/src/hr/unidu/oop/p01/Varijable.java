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
        // Ako bi se redci
        //    suma = suma + 2;
        //    i
        // 	  System.out.println(suma);
        // odkomentirali, program se ne bi mogao prevesti i izvesti jer
        // varijabla "suma" prije korištenja nije inicijalizirana!
        //suma = suma + 2;
        //System.out.println(suma);
    }
    /**
     * Korištenje varijable koja je prije korištenja inicijalizirana
     */
    public void koristenjeVarijableIspravno(){
        // Varijabla se prije prvog korištenja na desnoj strani izraza 
    	//  mora inicijalizirati
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
        // Program se ne može prevesti!
        // Ako bi se sljedeća 2 retka odkomentirala, program se ne bi mogao
        // prevesti jer se veći podatak (int) pokušava spremiti u polje 
        // manjeg tipa (byte)
        //byte y = x;
        //System.out.println(y);
    }
    /**
     * Spremanje vrijednosti iz podatka "većeg" tipa u podatak "manjeg" tipa
     * na ispravan način.
     */
    public void gubitakPreciznostiIspravno(){
        int x = 24;
        // Svjesni smo mogućeg gubitka i vršimo pretvorbu podataka
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
