/**
 * Vje�be 4 primjer su�elja koje slu�i kao spremnik programskih konstanti
 */
package hr.unidu.oop.p04.sucelje;
public interface Konstante {
	public static final int DULJINA = 5;
	public static final String NERADNI_DAN = "NEDJELJA";
	public static final String TEKUCA_GODINA = "2008";
	public void ispisTeksta();
	// Od Jave 8 - static metoda na sučelju - poziva se navođenjem sučelja
	static void ispis() {
		System.out.println("Static Ispis");
	}
	// Od Jave 8 - default metoda na sučelju - poziva se navođenjem reference
	//  na objekt klase koja implementira sučelje
	default void ispis2() {
		System.out.println("Default Ispis 2");
	}
	// Od Jave 8 - default metoda na sučelju - poziva se navođenjem reference
	//  na objekt klase koja implementira sučelje
	// U toj klasi se može "pregaziti" vlastitom kopijom metode. 
	default void ispis3() {
		System.out.println("Default Ispis 3");
	}
}