package hr.unidu.oop.p04.polimorfizam3;

public class Vlasnik
{
    private Zivotinja  z;
    
    public void javiSe(Zivotinja z) {
        this.z=z;
        System.out.println("Moj ljubimac!");
        this.z.glasanje();
    }
   
}