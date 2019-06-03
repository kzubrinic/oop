package hr.unidu.oop.p01;
/**
 * Različiti načini formatiranog i neformatiranog ispisa.
 */
public class Ispis{
	/**
	 * Metoda ispisuje poruku u dva retka metodom println
	 */
    public void output1(){
        System.out.println("Danas je ");
        System.out.println("sunčan dan.");
    }
    /**
	 * Metoda ispisuje poruku u jednom retka metodom print
	 */
    public void output2(){
        System.out.print("Danas je ");
        System.out.print("sunčan dan.\n");
    }
    /**
	 * Metoda ispisuje neformatiranu poruku u prvom retku metodom println,,
	 * a u drugom formatiranu poruku metodom printf.
	 */
    public void output3(){
        System.out.println("PI je "+Math.PI);
        System.out.printf("PI na 3 decimale je %.3f\n",Math.PI);
    }
    /**
	 * Metoda ispisuje poruku u dva retka metodom print. Prijelaz u novi
	 * redak ostvaruje se umetanjem posebnog znaka za prijelaz u novi 
	 * redak \n
	 */
    public void output4(){
        System.out.print("Danas je tako \"sunčan\" dan!\n");
        System.out.print("Stvarno \\je sunčano\\\t STVARNO!\n");
    }
    public static void main(String[] args){
        Ispis i = new Ispis();
        i.output1();
        i.output2();
        i.output3();
        i.output4();
    }
}
