package hr.unidu.oop.p02;

public class GreskaStatic
{
    private int x, y;
    public static void main(String[] args) {
    	// Iz static metode pristupa se varijablama i metodama instance
         x = 3;
         y = 5;
         System.out.println(x + " + " + y + " = "+zbroj(x, y)); 
    }   
    public int zbroj(int a, int b) {
        return a+b;
    }
}