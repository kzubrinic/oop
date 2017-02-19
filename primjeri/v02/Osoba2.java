public class Osoba2{
    private String ime;
    private int starost;
    // defaultni konstruktor
    public Osoba2(){
        System.out.println("Nova osoba!");
    }
    // konstruktor koji postavlja ime
    public Osoba2(String im){
        ime = im;
        System.out.println("Nova osoba s imenom "+ime);
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
    public void setStarost(int sta){
        starost = sta;
    }
    public String toString(){
        return "Ime: " + ime + " Starost: " + starost;
    }
}
