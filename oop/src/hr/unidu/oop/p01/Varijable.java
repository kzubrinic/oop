package hr.unidu.oop.p01;
 

/**
 * Primjer pridruživanja vrijednosti varijablama
 * ispravne i neispravne metode
 */ 

public class Varijable{
    public void koristenjeVarijablePogresno(){
        int suma;
        // Greška! Varijabla suma nije inicijalizirana a pokušava se koristiti
        // Program se ne može prevesti!
        suma = suma + 2;
        System.out.println(suma);
    }

    public void koristenjeVarijableIspravno(){
        // Varijabla se prije prvog korištenja na desnoj strani izraza 
    	//  mora inicijalizirati
        int suma = 0;
        suma = suma + 2;
        System.out.println(suma);
    }

    public void gubitakPreciznostiPogresno(){
        int x = 24;
        // Greška - mogući gubitak podataka
        // Program se ne može prevesti!
        byte y = x;
        System.out.println(y);
    }

    public void gubitakPreciznostiIspravno(){
        int x = 24;
        // Svjesni smo mogućeg gubitka i vršimo pretvorbu podataka
        byte y = (byte)x;
        System.out.println(y);
    }
    public static void main(String[] args) {
    	Varijable v = new Varijable();
    	v.koristenjeVarijablePogresno();
    	v.koristenjeVarijableIspravno();
    	v.gubitakPreciznostiPogresno();
    	v.gubitakPreciznostiIspravno();
    }
}
