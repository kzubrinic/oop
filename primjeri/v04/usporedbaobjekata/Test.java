package usporedbaobjekata;
import java.util.Arrays;
import java.util.Comparator;
public class Test implements Comparator<Trokut>{
    // instance variables - replace the example below with your own
    public void testiraj(){
        Trokut t1 = new Trokut(9,6,4);
        Trokut t2 = new Trokut(1,2,3);
        Trokut t3 = new Trokut(3,4,5);
        Trokut[] trokuti = {t1, t2, t3};
        System.out.println("Nesortirani trokuti:");
        for (Trokut t: trokuti)
            System.out.println(t);
        Arrays.sort(trokuti);
        System.out.println("Sortirani trokuti:");        
        for (Trokut t: trokuti)
            System.out.println(t);
    }
    public int compare(Trokut t1, Trokut t2){
        if (t1.getA()+t1.getB()+t1.getC() < t2.getA()+t2.getB()+t2.getC()) return -1;
        else if (t1.getA()+t1.getB()+t1.getC() > t2.getA()+t2.getB()+t2.getC()) return 1;
        else return 0;
 }

}
