package hr.unidu.oop.p03;
/**
 * Test razred za razred Automobil
 * 
 * @author Krunoslav �ubrini�
 * @version February 2008.
 */
public class Voznja 
{
    public static void main(String[] args) 
    {
        Automobil punto=new Automobil ("DU 111 A",137);
        boolean end=false;
        System.out.println("Automobil miruje.");
        while(!end)
        {
          end=punto.ubrzanje(20);
          System.out.print("Automobil " + punto.getRegBroj() );
          System.out.println(" vozi brzinom " + punto.getBrzina());
          if (end)
            break;
        }
        System.out.print("Automobil miruje.");
    }   
}   
    