package hr.unidu.oop.p02;

/**
 * Različiti načini formatiranog i neformatiranog ispisa.
 */
public class Ispis{
    public void output1(){
        System.out.println("Danas je ");
        System.out.println("sunčan dan.");
    }
    public void output2(){
        System.out.print("Danas je ");
        System.out.print("sunčan dan.\n");
    }
    public void output3(){
        System.out.println("PI je "+Math.PI);
        System.out.printf("PI na 3 decimale je %.3f\n",Math.PI);
    }
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
