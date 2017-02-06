/**
 * Primjer pridruživanja vrijednosti varijablama
 * ispravne i neispravne metode
 * 
 * @author Kruno 
 * @version veljaèa 2015.
 */ 

public class Varijable
{

    public void varijable()
    {
        int suma;
        // greška! Varijabla suma nije inicijalizirana
        suma = suma + 2;
    }

    public void varijable_ispravno()
    {
        // varijabla se prije prvog korištenja na desnoj strani izraza mora inicijalizirati
        int suma = 0;
        suma = suma + 2;

    }

    public void varijable2()
    {
        int x = 24;
        // greška - moguæi gubitak podataka
        byte y = x;
    }

    public void varijable2_ispravno()
    {
        int x = 24;
        // svjesni smo mopguæeg gubitka i vršimo pretvorbu podataka
        byte y = (byte)x;
    }

}
