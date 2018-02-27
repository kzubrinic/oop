package hr.unidu.oop.p02;
 

/**
 * Pretvorba izme�u razli�itih tipova podataka pomo�u
 * metoda klasa omota�a
 * 
 * @author Kruno 
 * @version velja�a 2015.
 */
public class Casting
{
    public void casting() {
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
    public static void main(String[] args) {
    	Casting c = new Casting();
    	c.casting();
    }
}
