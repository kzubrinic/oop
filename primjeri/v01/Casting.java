/**
 * Pretvorba izmeðu razlièitih tipova podataka pomoæu
 * metoda klasa omotaèa
 * 
 * @author Kruno 
 * @version veljaèa 2015.
 */
public class Casting
{
    public void casting()
    {
        String sNum = "246";
        int iNum = Integer.parseInt(sNum);
        double dNum = Double.parseDouble(sNum);
        String sNum1 = Integer.toString(iNum);
        String sNum2 = Double.toString(dNum);
        System.out.println("sNum: "+sNum);
        System.out.println("dNum: "+dNum);
        System.out.println("sNum1: "+sNum1);
        System.out.println("sNum2: "+sNum2);
    }
}
