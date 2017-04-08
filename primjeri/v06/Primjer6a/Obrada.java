package Primjer6a;

/**
 * Vježbe 7 Primjer izazivanja iznimne situacije
 * 
 */
import java.util.*;
public class Obrada {
    public int vrati() throws InputMismatchException, ArrayIndexOutOfBoundsException {
        int[] a={1,2,7};
        Scanner s = new Scanner(System.in);
        System.out.print("Unesite indeks polja (0-2): ");
        int i = s.nextInt();
        if (i>2)
            throw new ArrayIndexOutOfBoundsException("Pogrešan indeks [" + i + "]. Indeks mora biti u intervalu 0-2!");
        return a[i];
    }
}


