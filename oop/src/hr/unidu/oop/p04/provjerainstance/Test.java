package hr.unidu.oop.p04.provjerainstance;

public class Test
{
    public static void main(String[] args) {
        Trokut t1 = new Trokut();
        Lik t2 = new Trokut();
        if (t1 instanceof Trokut)
            System.out.println("T1 JE trokut");
        else
            System.out.println("T1 NIJE trokut");
        if (t2 instanceof  Trokut)
            System.out.println("T2 JE trokut");
        else
            System.out.println("T2 NIJE trokut");
            
            
        if (t1.getClass() == t2.getClass())
            System.out.println("T1 i T2 su istog tipa");
        else
            System.out.println("T1 i T2 nisu istog tipa");
    

    }
}
