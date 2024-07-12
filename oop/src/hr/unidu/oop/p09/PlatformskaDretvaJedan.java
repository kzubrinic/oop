package hr.unidu.oop.p09;
/**
 * Platformska dretva pomoću implementacije sučelja
 * Prvi način stvaranja
 * @author Krunoslav Žubrinić
 */
public class PlatformskaDretvaJedan implements Runnable{
	  // Posao koji se obavlja u dretvi stavlja se u metodu run
	  public void run(){  
	     // dohvaća naziv trenutne dretve
	     String naziv = Thread.currentThread().getName();
	     System.out.println("Platformska dretva " + naziv + " radi.");  
	  } 

	  public static void main(String args[]){  
	    Runnable obj = new PlatformskaDretvaJedan();  
	    Thread t1 = new Thread(obj);  
	    // poziva metodu run() objekta obj kada dretva dođe na red
	    t1.start();
	  }  
	}
