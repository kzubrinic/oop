package hr.unidu.oop.p02;

public class IspravljenaGreskaStatic1{
    private static int x, y;
    public static void main(String[] args){
        // Greška je ispravljena tako da se static varijablama i metodama pristupa 
    	// navođenjem naziva klase. varijable i metode su označene kao static 
    	// (varijable i metode klase).
    	IspravljenaGreskaStatic1.x = 3;
    	IspravljenaGreskaStatic1.y = 5;
        System.out.println(IspravljenaGreskaStatic1.x + " + " + 
    	IspravljenaGreskaStatic1.y + " = "+
        		 IspravljenaGreskaStatic1.zbroj(IspravljenaGreskaStatic1.x, IspravljenaGreskaStatic1.y)); 
    }   
    public static int zbroj(int a, int b){
        return a+b;
    }
}
