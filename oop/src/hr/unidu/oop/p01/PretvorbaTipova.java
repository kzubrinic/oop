package hr.unidu.oop.p01;

/**
 * Pretvorba između različitih tipova podataka pomoću
 * metoda klasa omotača
 */
public class PretvorbaTipova
{
	/**
	 * Metoda demonstrira pretvorbu između različitih brojčanih 
	 * tipova podataka i niza znakova pomoću metoda klasa omotača
	 * brojeva (Integer, Double,...)
	 */
    public void casting() {
    	// Broj zadan kao niz znakova
        String sNum = "246";
        // Pretvori broj iz tipa String u cijeli broj
        int iNum = Integer.parseInt(sNum);
        // Pretvori broj iz tipa String u realni broj
        double dNum = Double.parseDouble(sNum);
        // Pretvori cijeli broj u niz znakova
        String sNum1 = Integer.toString(iNum);
        // Pretvori realni broj u niz znakova
        String sNum2 = Double.toString(dNum);
        // Ispiši
        System.out.println("sNum: "+sNum);
        System.out.println("dNum: "+dNum);
        System.out.println("sNum1: "+sNum1);
        System.out.println("sNum2: "+sNum2);
    }
    public static void main(String[] args) {
    	PretvorbaTipova c = new PretvorbaTipova();
    	c.casting();
    }
}
