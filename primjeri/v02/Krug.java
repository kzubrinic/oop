public class Krug{
    private double polumjer;
    public Krug() { // defaultni konstruktor
        polumjer = 1;
    }
    public Krug(double pol) { // konstruktor koji prima parametar
        setPolumjer(pol);
    }
    public double vratiPovrsinu() { // metoda raèuna površinu kruga
        return polumjer * polumjer * Math.PI;
    }
    public double vratiOpseg() { // metoda raèuna opseg kruga
        return 2 * polumjer * Math.PI;
    }
    public void setPolumjer(double pol) { // metoda postavlja polumjer kruga
        polumjer = pol;             //   ako se krug stvara pomoæu
    }                               //   defaultnog konstruktora.
    public double getPolumjer() { // metoda vraæa polumjer kruga
        return polumjer;    
    }
}
