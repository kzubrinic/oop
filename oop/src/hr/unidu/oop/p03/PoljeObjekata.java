package hr.unidu.oop.p03;

import java.util.Random;

public class PoljeObjekata
{
    // instance variables - replace the example below with your own
    private Tocka[] pT;

    public PoljeObjekata(){
        pT = new Tocka[10];
        int i = 0;
        Random r = new Random();
        for (Tocka t: pT) {
            t = new Tocka(r.nextInt(100), r.nextInt(100));
        }
    }

    public static void main(String[] args) {
        new PoljeObjekata();
    }
}
