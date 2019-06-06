package hr.unidu.oop.p04.sucelje;

public class KoristenjeKonstantiSucelja implements Sucelje {


    public KoristenjeKonstantiSucelja() {
        System.out.println("Neradan dan je " + NERADNI_DAN);
        System.out.println("Tekuća godina je " + TEKUCA_GODINA);
    }
    public void ispisTeksta() {
       System.out.println("Tekst");    
    }  
    // Od Jave 8 - default metoda na sučelju se može "pregaziti" 
    //	verzijom metode u klasi koja implementira to sučelje. 
    public void ispis3() {
		System.out.println("Promijenjeni Ispis 3");
	}
    public static void main(String[] args) {
    	// Od Jave 8 - static metoda na sučelju - poziva se navođenjem sučelja
    	Sucelje.ispis();
    	KoristenjeKonstantiSucelja k = new KoristenjeKonstantiSucelja();
    	// Od Jave 8 - default metoda na sučelju - poziva se navođenjem reference
    	//  na objekt klase koja implementira sučelje
    	k.ispis2();
    	// Poziva se metoda ispis3 u ovoj klasi
    	k.ispis3();
    }
}