package hr.unidu.oop.p02;
public class TestToString{
    public static void main(String[] args){
        // razred Osoba nema implementiranu metodu toString()
        // dok je ona implementirana u razredu Osoba2
        Osoba p1 = new Osoba();
        Osoba2 p2 = new Osoba2("Ana");
        p2.setStarost(25);
        System.out.println(p2);
        System.out.println(p1);
    }
}
