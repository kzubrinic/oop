package hr.unidu.oop.p04.polimorfizam2;


/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    public void test() {
        Gramofon g=new Gramofon();
        g.javiSe(new Pas());
        g.javiSe(new Hipo());
        g.javiSe(new Macka());
        //g.javiSe(new Zirafa());
        
        Vlasnik v=new Vlasnik();
        v.javiSe(new Pas());
        v.javiSe(new Hipo());
        v.javiSe(new Macka());
        //v.javiSe(new Zirafa());
    }    
}
