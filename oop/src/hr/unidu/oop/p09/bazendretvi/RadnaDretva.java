package hr.unidu.oop.p09.bazendretvi;

import java.util.concurrent.Callable;

// Klasa implementira oba sučelja za rad s dretvama
public class RadnaDretva implements Runnable, Callable<String> {
    private int nazivDretve;
    public RadnaDretva(int s){
        nazivDretve=s;
    }
 
    // Obrada kada se ne vraća nikaka vrijednost 
    public void run() {
        System.out.println(Thread.currentThread().getName()+" (Start) dretva = "+nazivDretve);
        obrada();
        System.out.println(Thread.currentThread().getName()+" (End)");
    }
 
    // Obrada kada se vraća podatak tipa string
	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+" (Start) dretva = "+nazivDretve);
        obrada();
        System.out.println(Thread.currentThread().getName()+" (End)");
		return "Vraća: " + Thread.currentThread().getName() + " " + nazivDretve;
	}
	
    private void obrada() {
    	try {
    		System.out.println(Thread.currentThread().getName() + " (Radi) dretva = "+nazivDretve);
    		// obrada traje 2 s
    		Thread.sleep(2000);  
		} catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
    }


}

