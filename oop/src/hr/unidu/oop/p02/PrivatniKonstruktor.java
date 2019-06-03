package hr.unidu.oop.p02;
/**
 * Primjer klase s privatnim konstruktorom i graditeljskom metodom
 * koja dozvoljava stvaranje samo jednog objekta (oblikovni 
 * obrazac singleton). 
 */
public class PrivatniKonstruktor {
	private static PrivatniKonstruktor objekt;
	/**
	 * Objekt se ne može stvarati izravno operatorom new
	 */
	private PrivatniKonstruktor() {} 
	/**
	 * Objekt se stvara "graditeljskom" (builder) metodom koja dozvoljava
	 * stvaranje samo jednog objekta tipa PrivatniKonstruktor.
	 * Ako objekt postoji, vraća referencu na taj objekt, a ako ne postoji 
	 * stvara novi objekt i vraća referencu na njega.
	 * Ovaj oblikovni obrazac se naziva singleton.
	 */
	public static PrivatniKonstruktor stvoriObjekt() {
		if(PrivatniKonstruktor.objekt == null) {
			PrivatniKonstruktor.objekt = new PrivatniKonstruktor();
		}
		return PrivatniKonstruktor.objekt;
	}
	public String toString() {
		return "Objekt stvoren iz klase s privatnim konstruktorom.";
	}
}