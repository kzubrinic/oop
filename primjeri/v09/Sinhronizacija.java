/**
 * @author Krunoslav Žubrinić
 */
public class Sinhronizacija implements Runnable{
	private int iznos = 100;
	// Posao koji se obavlja u dretvi stavlja se u metodu run
	public void run(){  
		for (int i = 0; i<5; i++){
			//smanjiNesinhronizirano();
			smanjiSinhronizirano();
			String naziv = Thread.currentThread().getName();
			//System.out.print("Dretva " + naziv + " radi. "); 
			System.out.println("Iznos je "+iznos);
		}
	}
	
	private synchronized void smanjiSinhronizirano(){
		if (iznos>=10){
			String naziv = Thread.currentThread().getName();
			System.out.println("Dretva " + naziv + " skida 10 "); 
			iznos = iznos - 10;
		}
	}
	
	private void smanjiNesinhronizirano(){
		if (iznos>=10){
			String naziv = Thread.currentThread().getName();
			System.out.println("Dretva " + naziv + " skida 10 "); 
			iznos = iznos - 10;
		}
	}
	public static void main(String args[]){  
		Sinhronizacija obj = new Sinhronizacija();  
		Thread t1 = new Thread(obj, "PRVA");  
		Thread t2 = new Thread(obj, "DRUGA");
		Thread t3 = new Thread(obj, "TREĆA");
		System.out.println("Početni iznos je "+obj.iznos);
		t1.start();  
		t2.start();
		t3.start();
	}  
}