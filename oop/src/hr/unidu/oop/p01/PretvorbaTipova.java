package hr.unidu.oop.p01;
 

/**
 * Pretvorba između različitih tipova podataka pomoću
 * metoda klasa omotača
 */
public class PretvorbaTipova
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
    	PretvorbaTipova c = new PretvorbaTipova();
    	c.casting();
    }
}
