package hr.unidu.oop.p09;
/**
 * Virtualna dretva pomoću implementacije sučelja
 * Prvi način stvaranja
 * Java min. verzije 21 
 * @author Krunoslav Žubrinić
 */
public class VirtualnaDretvaJedan implements Runnable{
	  // Posao koji se obavlja u dretvi stavlja se u metodu run
	  public void run(){  
	     // dohvaća naziv trenutne dretve
	     String naziv = Thread.currentThread().getName();
	     System.out.println("Dretva " + naziv + " radi.");  
	  } 

	  public static void main(String args[]) throws InterruptedException{  
	    Runnable obj = new VirtualnaDretvaJedan();  
	    // Stvara neimenovanu virtualnu dretvu, zadaje posao koji
	    //  treba odraditi i pokreće dretvu    
	    Thread t1 = Thread.startVirtualThread(obj);  
	    // Čekamo da dretva završi za nastavak obrade.
	    // Bez ove naredbe program biu se često završio prije dretve i
	    //  na zaslonu ne bismo vidjeli rezultat izvođenja.
	    // Meroda join izbacuje provjeravanu iznimku InterruptedException
	    t1.join();
	  }  
	}
