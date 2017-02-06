/**
 * Primjer pridru�ivanja vrijednosti varijablama
 * ispravne i neispravne metode
 * 
 * @author Kruno 
 * @version velja�a 2015.
 */ 

public class Varijable
{

    public void varijable()
    {
        int suma;
        // gre�ka! Varijabla suma nije inicijalizirana
        suma = suma + 2;
    }

    public void varijable_ispravno()
    {
        // varijabla se prije prvog kori�tenja na desnoj strani izraza mora inicijalizirati
        int suma = 0;
        suma = suma + 2;

    }

    public void varijable2()
    {
        int x = 24;
        // gre�ka - mogu�i gubitak podataka
        byte y = x;
    }

    public void varijable2_ispravno()
    {
        int x = 24;
        // svjesni smo mopgu�eg gubitka i vr�imo pretvorbu podataka
        byte y = (byte)x;
    }

}
