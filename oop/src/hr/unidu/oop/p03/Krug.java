package hr.unidu.oop.p03;
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
}
