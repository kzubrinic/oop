package hr.unidu.oop.p09.bazendretvi;

public class RadnaDretva implements Runnable {
    private int nazivDretve;
    public RadnaDretva(int s){
        nazivDretve=s;
    }
 
    public void run() {
        System.out.println(Thread.currentThread().getName()+" (Start) dretva = "+nazivDretve);
        obrada();
        System.out.println(Thread.currentThread().getName()+" (End)");
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

