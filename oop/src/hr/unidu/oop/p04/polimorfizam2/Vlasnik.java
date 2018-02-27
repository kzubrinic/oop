package hr.unidu.oop.p04.polimorfizam2;

public class Vlasnik
{
     private Pas p;
    private Macka m;
    private Lav l;
    private Hipo h;
//    private Zirafa z;
    
    public void javiSe(Pas p) {
        this.p=p;
        System.out.println("Moj ljubimac!");
        this.p.glasanje();
    }
    public void javiSe(Macka m) {
        this.m=m;
        System.out.println("Moj ljubimac!");
        this.m.glasanje();
    }
    public void javiSe(Lav l) {
        this.l=l;
        System.out.println("Moj ljubimac!");
        this.l.glasanje();
    }
    public void javiSe(Hipo h) {
        this.h=h;
        System.out.println("Moj ljubimac!");
        this.h.glasanje();
    }
/*    public void javiSe(Zirafa z) {
        this.z=z;
        System.out.println("Moj ljubimac!");
        this.z.glasanje();
    }
*/ 
}
