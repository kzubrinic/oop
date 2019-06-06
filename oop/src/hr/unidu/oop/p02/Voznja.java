package hr.unidu.oop.p02;
/**
 * Test klasa za klasu Automobil
 */
public class Voznja{
    public static void main(String[] args){
        Automobil punto=new Automobil ("DU 111 A",137);
        boolean end=false;
        System.out.println("Automobil miruje.");
        while(!end){
          end=punto.ubrzanje(20);
          System.out.print("Automobil " + punto.getRegBroj() );
          System.out.println(" vozi brzinom " + punto.getBrzina());
          if (end)
            break;
        }
        System.out.print("Automobil miruje.");
    }   
}    