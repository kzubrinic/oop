package hr.unidu.oop.p02;

import java.util.Objects;

public class Osoba3{
    private String ime;
    private int starost;
    // defaultni konstruktor
    public Osoba3(){
        System.out.println("Nova osoba: " + toString());
    }
    // konstruktor koji postavlja ime
    public Osoba3(String im){
        ime = im;
        System.out.println("Nova osoba: " + toString());
    }
    // konstruktor koji postavlja ime i starost
    public Osoba3(String im, int sta){
        ime = im;
        starost = sta;
        System.out.println("Nova osoba: " + toString());
    }
    public void setIme(String im){
        ime = im;
    }
    public void setStarost(int sta){
        starost = sta;
    }
    public String toString(){
        return "Ime: " + ime + " Starost: " + starost;
    }
    // Metoda koja uspoređuje dva objekta tipa Osoba3
    // mora ići u paru s metodom hashCode() koja kod usporedbe 
    // treba koristiti iste varijable instance kao metoda equals().
    public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Osoba3)){
			return false;
		}
		Osoba3 drugi = (Osoba3) obj;
		return starost == drugi.starost &&
				(Objects.equals(ime, drugi.ime));
		// Stari načlin
        // return starost == drugi.starost &&
        //				(ime == drugi.ime || (ime != null && ime.equals(drugi.ime)));
	}
    public int hashCode() {
		final int prim = 31;
		int hash = 1;
		hash = prim * hash + starost;
		hash = prim * hash + (null == ime ? 0 : ime.hashCode());
		return hash;
	}
}