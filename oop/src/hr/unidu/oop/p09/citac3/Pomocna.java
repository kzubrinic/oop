package hr.unidu.oop.p09.citac3;
public class Pomocna{
    private String naziv;
    private String tip;

    public Pomocna(String naziv, String tip){
        this.naziv = naziv;
        this.tip = tip;
    }
    public String getNaziv(){
        return naziv;
    }
    public String getTip(){
        return tip;
    }
    public String toString() {
    	return naziv+tip;
    }
}
