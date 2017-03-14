package Super;
public class Zivotinja {
    String ime;
    Zivotinja(String ime){
       System.out.println("Izvodi se konstruktor klase Zivotinja");
       this.ime=ime;
    } 
    public void glasanje() {
        System.out.println("Glasanje ŽIVOTINJE!");   
    }   
    
    public void hranjenje() {
        System.out.println("Hranjenje ŽIVOTINJE!");   
    }   
    public static void spavanje() {
        System.out.println("STATIC spavanje ŽIVOTINJE!");   
    }   
}
