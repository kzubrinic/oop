package hr.unidu.oop.p04.polimorfizam3;

 


/**
 * Write a description of class Gramofon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gramofon
{
    private Zivotinja  z;
    
    public void javiSe(Zivotinja z) {
        this.z=z;
        this.z.glasanje();
    }
   
}
