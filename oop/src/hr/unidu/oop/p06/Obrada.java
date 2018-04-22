package hr.unidu.oop.p06;

/**
 * Vježbe 6 Primjer spuštanje greške do razine na kojoj
 * se vrši njezina obrada
 * 
 */
public class Obrada {
    public int vrati() throws ArrayIndexOutOfBoundsException {
        int[] a={1,2,7};
        return a[4];
    }
    public static void main(String[] args) {
    	Obrada o = new Obrada();
    	o.vrati();
    }
}


