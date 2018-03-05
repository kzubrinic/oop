package hr.unidu.oop.p02;
public class Krug{
    private double polumjer;
    public Krug() { // defaultni konstruktor
        polumjer = 1;
    }
    public Krug(double pol) { // konstruktor koji prima parametar
        setPolumjer(pol);
    }
    public double vratiPovrsinu() { // metoda ra�una povr�inu kruga
        return polumjer * polumjer * Math.PI;
    }
    public double vratiOpseg() { // metoda ra�una opseg kruga
        return 2 * polumjer * Math.PI;
    }
    public void setPolumjer(double pol) { // metoda postavlja polumjer kruga
        polumjer = pol;             //   ako se krug stvara pomo�u
    }                               //   defaultnog konstruktora.
    public double getPolumjer() { // metoda vra�a polumjer kruga
        return polumjer;    
    }
    public String toString() {
    	return "Krug polumjera: " + polumjer + " opsega: " + vratiOpseg() + " površine: " + vratiPovrsinu(); 
    }
    public static void main(String[] args) {
    	// Stvaranje objekta pomoću konstruktora s parametrom
    	Krug o1 = new Krug(10);
    	// Stvaranje objekta s "dafualutnim" konstruktorom
    	Krug o2 = new Krug();
    	// Pristup metodama stvorenog objekta
    	o2.setPolumjer(5);
    	// ispis objekta - ispisne metode koriste metodu toString
    	System.out.println(o1);
    	System.out.println(o2);
    }
}
