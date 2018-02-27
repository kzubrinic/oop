package hr.unidu.oop.p04.polimorfizam2;


/**
 * Write a description of class Gramofon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gramofon
{
    private Pas p;
    private Macka m;
    private Lav l;
    private Hipo h;
//    private Zirafa z;
    
    public void javiSe(Pas p) {
        this.p=p;
        this.p.glasanje();
    }
    public void javiSe(Macka m) {
        this.m=m;
        this.m.glasanje();
    }
    public void javiSe(Lav l) {
        this.l=l;
        this.l.glasanje();
    }
    public void javiSe(Hipo h) {
        this.h=h;
        this.h.glasanje();
    }
/*    public void javiSe(Zirafa z) {
        this.z=z;
        this.z.glasanje();
    }
*/    
}
