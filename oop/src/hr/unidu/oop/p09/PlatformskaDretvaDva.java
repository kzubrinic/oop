package hr.unidu.oop.p09;
/**
 * Platformska dretva pomoću implementacije sučelja
 * Drugi način stvaranja: pomoću klase graditelja platformskih dretvi
 * Java min. verzije 21 
 * @author Krunoslav Žubrinić
 */
public class PlatformskaDretvaDva implements Runnable{
	  // Posao koji se obavlja u dretvi stavlja se u metodu run
	  public void run(){  
	     // dohvaća naziv trenutne dretve
	     String naziv = Thread.currentThread().getName();
	     System.out.println("Dretva " + naziv + " radi.");  
	  } 
	public static void main(String args[]){  
	    Runnable obj = new PlatformskaDretvaDva();  
	    // Stvara objekt tipa graditelj platformske dretve
	    Thread.Builder.OfPlatform graditelj = Thread.ofPlatform(); 
	    // Graditelj ima niz metoda za podešavanje dretve
	    graditelj.name("Druga platformska dretva");
	    graditelj.priority(2);
	    // Stvara dretvu, predaje objekt obrade i pokreće dretvu
	    Thread t2 = graditelj.start(obj);
	    // Sve to može i u jednoj liniji
	    Thread t3 = Thread.ofPlatform()
	    		.priority(2)
	    		.name("Treća dretva")
	    		.start(obj);
	  }  
	}
