package hr.unidu.oop.p02;

import hr.unidu.oop.p01.Osoba;

public class TestToString
{
    public void testiraj(){
        // razred Osoba nema implementiranu metodu toString()
        // dok je ona implementirana u razredu Osoba2
        Osoba p1 = new Osoba();
        Osoba2 p2 = new Osoba2("Ana");
        p2.setStarost(25);
        System.out.println(p2);
        System.out.println(p1);
        Osoba2 p3 = new Osoba2(p1);
    }
}
