package hr.unidu.oop.p09;
/**
 * @author Krunoslav Žubrinić
 * 19. svi 2015.
 */
public class VisestrukeDretve implements Runnable{
	// Posao koji se obavlja u dretvi stavlja se u metodu run
	public void run(){  

		try {
			// Dretva pauzira 2 sekunde
			Thread.sleep(2000);
		}
		catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		for (int i = 0; i<10; i++){
			// dohvaća naziv trenutne dretve
			String naziv = Thread.currentThread().getName();
			System.out.println("Dretva " + naziv + " radi.");  
		}
	}   
	public static void main(String args[]){  
		VisestrukeDretve obj = new VisestrukeDretve();  
		Thread t1 = new Thread(obj, "PRVA");  
		Thread t2 = new Thread(obj);
		t2.setName("DRUGA");
		Thread t3 = new Thread(obj);
		t3.setName("TREĆA");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(5);
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.start();  
		t2.start();
		t3.start();
	}  
}