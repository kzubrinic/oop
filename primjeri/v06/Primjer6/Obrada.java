package Primjer6;

/**
 * Vježbe 7 Primjer spuštanje greške do razine na kojoj
 * se vrši njezina obrada
 * 
 */
public class Obrada {
    public int vrati() throws ArrayIndexOutOfBoundsException {
        int[] a={1,2,7};
        return a[4];
    }
}


