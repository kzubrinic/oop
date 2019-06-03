package hr.unidu.oop.p02;

public class Osoba2{
    private String ime;
    private int starost;
    // defaultni konstruktor
    public Osoba2(){
        System.out.println("Nova osoba!");
    }
    // konstruktor koji postavlja ime,a starost na inicijalnu vrijednost 20
    public Osoba2(String im){
    	// Ovaj konstruktor poziva drugi konstruktor koji prima dva parametra
    	this(im, 20);
    }
    // konstruktor koji postavlja ime i starost
    public Osoba2(String im, int sta){
        ime = im;
        starost = sta;
        System.out.println("Nova osoba " + ime + " ima " + starost + " godina.");
    }
    public void setIme(String im){
        ime = im;
    }
    public String getIme() {
    	return ime;
    }
    public void setStarost(int sta){
        starost = sta;
    }
    public int getStarost() {
    	return starost;
    }
    public String toString(){
        return "Ime: " + ime + " Starost: " + starost;
    }
    public static void main(String[] args) {
    	// Stvaranje objekta pomoću konstruktora s imenom
    	Osoba2 o1 = new Osoba2("Ana");
    	// Stvaranje osobe pomoću konstruktora s imenom i starosti
    	Osoba2 o2 = new Osoba2("Ivo", 27);
    	// Stvaranje osobe s "defaultnim" konstruktorom
    	Osoba2 o3 = new Osoba2();
    	// Pristup varijablama stvorenog objekta
    	o3.setIme("Pero");
    	o3.setStarost(34);
    	// ispis objekta - ispisne metode koriste metodu toString
    	System.out.println(o1);
    	System.out.println(o2);
    	System.out.println(o3);
    }
}
