package hr.unidu.oop.p03;

/**
 * Klasa Osoba s primjerom varijabli i metode
 *
 * @version February 2016.
 */
public class Cestitar
{
    public void cestitanje(Osoba o){
        o.cestitajRodjendan();
    }


    public static void main(String[] args){
        // ulančavanje - u jednom retku
        new Cestitar().cestitanje(new Osoba());

        // isto što i korištenje pojedinačnih referenci
        Cestitar c = new Cestitar();
        Osoba o = new Osoba();
        c.cestitanje(o);
        Double d1 = 1023d;
        Double d2 = 1023d;

        // function call to compare two double values
        if (Double.compare(d1, d2) == 0) {

            System.out.println("d1=d2");
        }

    }
}
