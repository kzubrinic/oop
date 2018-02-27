package hr.unidu.oop.p01;
 

/**
 * Primjer pridruživanja vrijednosti varijablama
 * ispravne i neispravne metode
 * 
 * @author Kruno 
 * @version veljača 2015.
 */ 

public class Varijable{
	/*
    public void varijable(){
        int suma;
        // greška! Varijabla suma nije inicijalizirana
        suma = suma + 2;
        System.out.println(suma);
    }
    */

    public void varijable_ispravno(){
        // varijabla se prije prvog korištenja na desnoj strani izraza mora inicijalizirati
        int suma = 0;
        suma = suma + 2;
        System.out.println(suma);
    }

    /*
    public void varijable2(){
        int x = 24;
        // greška - mogući gubitak podataka
        byte y = x;
        System.out.println(y);
    }
    */

    public void varijable2_ispravno(){
        int x = 24;
        // svjesni smo mogućeg gubitka i vršimo pretvorbu podataka
        byte y = (byte)x;
        System.out.println(y);
    }
    public static void main(String[] args) {
    	Varijable v = new Varijable();
    	//v.varijable();
    	v.varijable2_ispravno();
    	//v.varijable2();
    	v.varijable2_ispravno();
    }
}
