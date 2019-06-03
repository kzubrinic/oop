package hr.unidu.oop.p02;

/**
 * Usporedba objekata
 */
public class Usporedba{
    private void usporedi1(){
           String s1 = "Ana";
           String s2 = s1;
           // Usporedba jesu li dva objekta jednaka
           if (s1.equals(s2))
                System.out.println("OBJEKTI su ISTI!");
           else     
                System.out.println("OBJEKTI su RAZLIČITI!");
           // Usporedba jesu li dvije varijable reference na isti objekt
           if (s1 == s2)     
                System.out.println("REFERENCE pokazuju na ISTI objekt!");
           else     
                System.out.println("REFERENCE pokazuju na RAZLIČITE objekte!");
    }
    private void usporedi2(){
           String s1 = "Ana";
           String s2 = new String("Ana");
           // Usporedba jesu li dva objekta jednaka
           if (s1.equals(s2))
                System.out.println("OBJEKTI su ISTI!");
           else     
                System.out.println("OBJEKTI su RAZLIČITI!");
           // Usporedba jesu li dvije varijable reference na isti objekt
           if (s1 == s2)     
                System.out.println("REFERENCE pokazuju na ISTI objekt!");
           else     
                System.out.println("REFERENCE pokazuju na RAZLIČITE objekte!");
    }
    
    // Klasa Osoba2 nema implementirane metode equals i hashCode!
    private void usporediOsobe(){
        Osoba2[] p = new Osoba2[4];
        for (int i = 0; i < 3; i++){
            p[i] = new Osoba2("Ana", 33);
        }
        p[3] = new Osoba2("Pero", 57);
        // Provjera jednakosti objekata
        for (int i = 0; i < 3; i++){
            if (p[0].equals(p[i+1]))
                System.out.println(p[0] + " i " + p[i+1] + " SU jednaki");
            else
                System.out.println(p[0] + " i " + p[i+1] + " NISU jednaki");
        }
        // Ispis hash koda objekata
        for (int i = 0; i < 4; i++){
            System.out.println(p[i].hashCode());
        }
    }
 // Klasa Osoba3 IMA implementirane metode equals i hashCode!
    private void usporediOsobe3(){
        Osoba3[] p = new Osoba3[4];
        for (int i = 0; i < 3; i++){
            p[i] = new Osoba3("Ana", 33);
        }
        p[3] = new Osoba3("Pero", 57);
        // Provjera jednakosti objekata
        for (int i = 0; i < 3; i++){
        	if (p[0].equals(p[i+1]))
                System.out.println(p[0] + " i " + p[i+1] + " SU jednaki");
            else
                System.out.println(p[0] + " i " + p[i+1] + " NISU jednaki");
        }
        // Ispis hash koda objekata
        for (int i = 0; i < 4; i++){
            System.out.println(p[i].hashCode());
        }
    }
     public static void main(String[] args) {
    	 Usporedba o = new Usporedba();
    	 // 1. usporedba objekata tipa String 
    	 o.usporedi1();
    	 // 2. usporedba objekata tipa String 
    	 o.usporedi2();
    	 
    	 // Usporedba objekata tipa Osoba2 koji NEMAJU implementirane
    	 //   metode equals i hashCode
    	 o.usporediOsobe();
    	 //Usporedba objekata tipa Osoba3 koji IMAJU implementirane
    	 //   metode equals i hashCode
    	 o.usporediOsobe3();
     }
}
