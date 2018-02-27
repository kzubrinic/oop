package hr.unidu.oop.p03;
public class PoljeObjekata
{
    // instance variables - replace the example below with your own
    private Tocka[] pT;

    public PoljeObjekata(){
        pT = new Tocka[10];
        int i = 0;
        for (Tocka t: pT)
            t = new Tocka((int)(Math.random()*100), (int)(Math.random()*100));
    }

}
