package hr.unidu.oop.p03;

/**
 * String comparison
 * 
 * @author Krunoslav �ubrini�
 * @version February  2009.
 */
public class Usporedba
{
    public void usporedi1()
    {
           String s1 = "Ana";
           String s2 = s1;
           if (s1.equals(s2))
                System.out.println("OBJEKTI su ISTI!");
           else     
                System.out.println("OBJEKTI su RAZLI�ITI!");
           if (s1==s2)     
                System.out.println("REFERENCE pokazuju na ISTI objekt!");
           else     
                System.out.println("REFERENCE pokazuju na RAZLI�ITE objekte!");
    }
    public void usporedi2()
    {
           String s1 = "Ana";
           String s2 = new String("Ana");
           if (s1.equals(s2))
                System.out.println("OBJEKTI su ISTI!");
           else     
                System.out.println("OBJEKTI su RAZLI�ITI!");
           if (s1==s2)     
                System.out.println("REFERENCE pokazuju na ISTI objekt!");
           else     
                System.out.println("REFERENCE pokazuju na RAZLI�ITE objekte!");
    }
    
    public void usporediOsobe(){
        Osoba2[] p = new Osoba2[4];
        for (int i = 0; i < 3; i++){
            p[i] = new Osoba2("Ana", 33);
        }
        p[3] = new Osoba2("Pero", 57);
        // provjera jednakosti
        for (int i = 0; i < 3; i++){
            if (p[0].equals(p[i+1]))
                System.out.println("Jednaki");
            else
                System.out.println("NISU jednaki");
        }
        // provjera hash koda
        for (int i = 0; i < 4; i++){
            System.out.println(p[i].hashCode());
        }
    }
    public void usporediOsobe3(){
        Osoba3[] p = new Osoba3[4];
        for (int i = 0; i < 3; i++){
            p[i] = new Osoba3("Ana", 33);
        }
        p[3] = new Osoba3("Pero", 57);
        // provjera jednakosti
        for (int i = 0; i < 3; i++){
            if (p[0].equals(p[i+1]))
                System.out.println(p[0]+"i "+p[i+1]+ " su Jednake");
            else
                System.out.println(p[0]+"i "+p[i+1]+ " NISU jednake");
        }
        // provjera hash koda
        for (int i = 0; i < 4; i++){
            System.out.println(p[i].hashCode());
        }

    }
     
}
