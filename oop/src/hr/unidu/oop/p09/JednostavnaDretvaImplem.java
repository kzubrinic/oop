package hr.unidu.oop.p09;
 

/**
 * Dretva pomoću implementacije sučelja
 * @author Krunoslav Žubrinić
 */
public class JednostavnaDretvaImplem implements Runnable{
    // Posao koji se obavlja u dretvi stavlja se u metodu run
    public void run(){  
        for (int i = 0; i < 5; i++) {
            System.out.println("broj " + i);
        }
        System.out.println("Gotovo brojanje");  
    }   
    public static void main(String[] args){
        JednostavnaDretvaImplem obj = new JednostavnaDretvaImplem();  
        Thread t1 = new Thread(obj);  
        t1.start();     
    }  
}