import java.util.Arrays;
/**
 * Arrays
 * 
 * @author Krunoslav Žubrinić
 * @version ožujak 2008.
 */

public class Polje 
{
    private int[] days, x = {1,3,7,4,8};
    public void prikaziPolje()
    {
        days = new int[7];
        days[0] = 2;
        days[1] = 34;
        days[2] = 71;
        days[3] = 9;
        days[4] = 31;
        days[5] = 8;
        days[6] = 48;
        for (int i = 0; i < days.length; i++) 
            System.out.println("Broj dana u "+i+" je: "+days[i]);
        for (int i = 0; i < x.length; i++) 
            System.out.println("Broj drugih dana u "+i+" je: "+x[i]);
    }
    public void sortirajPolje()
    {
        prikaziPolje();
        Arrays.sort(days);
        Arrays.sort(x);
        for (int i = 0; i < days.length; i++) 
            System.out.println("SORTIRANI PODACI: Broj dana u "+i+" je: "+days[i]);
        for (int i = 0; i < x.length; i++) 
            System.out.println("SORTIRANI PODACI: Broj drugih dana u "+i+" je: "+x[i]);
    }

}