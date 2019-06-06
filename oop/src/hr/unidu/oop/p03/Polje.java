package hr.unidu.oop.p03;

import java.util.Arrays;
import java.util.Random;

/**
 * Arrays
 *
 * @author Krunoslav Žubrinić
 * @version ožujak 2008.
 */

public class Polje {
    private int[] days, x;

    public void prikaziPolje() {
        days = new int[10];
        x = new int[12];
        Random r = new Random();
        for (int i = 0; i < days.length; i++)
            days[i] = r.nextInt(365) + 1;
        for (int i = 0; i < x.length; i++)
            x[i] = r.nextInt(31) + 1;

        for (int i = 0; i < days.length; i++)
            System.out.println("Broj dana u godini " + i + " je: " + days[i]);
        for (int i = 0; i < x.length; i++)
            System.out.println("Broj dana u mjesecu " + i + " je: " + x[i]);
    }

    public void sortirajPolje() {
        Arrays.sort(days);
        Arrays.sort(x);
        for (int i = 0; i < days.length; i++)
            System.out.println("SORTIRANI PODACI: Broj dana u " + i + " je: " + days[i]);
        for (int i = 0; i < x.length; i++)
            System.out.println("SORTIRANI PODACI: Broj drugih dana u " + i + " je: " + x[i]);
    }

    public static void main(String[] args) {
        Polje p = new Polje();
        p.prikaziPolje();
        p.sortirajPolje();
    }
}