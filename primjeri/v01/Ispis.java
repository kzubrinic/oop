/**
 * Razlièiti naèini formatiranog i neformatiranog ispisa.
 * 
 * @author Krunoslav Žubriniæ 
 * @version veljaèa 2015.
 */
public class Ispis
{
    public static void main(String[] args){
        Ispis i = new Ispis();
        i.output1();
        i.output2();
        i.output3();
        i.output4();
    }
    public void output1(){
        System.out.println("Danas je srijeda ");
        System.out.println("25. veljaèe 2015.");
    }
    public void output2(){
        System.out.print("Danas je srijeda ");
        System.out.print("25. veljaèe 2015.");
    }
    public void output3(){
        System.out.println("PI je "+Math.PI);
        System.out.printf("PI na 3 decimale je %.3f",Math.PI);
    }
    public void output4(){
        System.out.print("Danas je tako \"kišno\" vrijeme!\n");
        System.out.print("Stvarno \\je kišno\\\t STVARNO!");
    }
    

}
