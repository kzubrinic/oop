package hr.unidu.oop.p09;
public class Pomocna{
    private String naziv;
    private int br;

    public Pomocna(String naziv, int br){
        this.naziv = naziv;
        this.br = br;
    }
    public String getNaziv(){
        return naziv;
    }
    public int getBr(){
        return br;
    }
}
