package hr.unidu.oop.p03;

import java.util.Objects;

public class Osoba4 {
    private String ime;
    private int starost;
    private double visina;
    // defaultni konstruktor
    public Osoba4(){
        System.out.println("Nova osoba!");
    }
    // konstruktor koji postavlja ime, starost i visinu
    public Osoba4(String im, int sta, double v){
        ime = im;
        starost = sta;
        visina = v;
        System.out.println("Nova osoba imena " + ime + " ima " + starost + " " +
                "godina i visoka je " + visina + "m." );
    }
    public void setIme(String im){
        ime = im;
    }
    public void setStarost(int sta){
        starost = sta;
    }
    public void setVisina(double v){
        visina = v;
    }
    public String toString(){
        return "Ime: " + ime + " Starost: " + starost + " Visina: " + visina;
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Osoba4)){
            return false;
        }
        Osoba4 drugi = (Osoba4) obj;
        return (Objects.equals(Integer.valueOf(starost),
                Integer.valueOf(drugi.starost))) &&
                (Objects.equals(ime, drugi.ime)) &&
                (Objects.equals(Double.valueOf(visina),
                        Double.valueOf(drugi.visina)));
    }
    public int hashCode() {
        return Objects.hash(Integer.valueOf(starost), ime, Double.valueOf(visina));
    }

    public static void main(String[] args) {
        Osoba4 o1 = new Osoba4("Ana", 33, 1.72);
        Osoba4 o2 = new Osoba4("Ana", 33, 1.72);
        Osoba4 o3 = new Osoba4("Ivo", 36, 1.81);
        System.out.println(o1.equals(o2));
        System.out.println(o1.equals(o3));
    }
}
