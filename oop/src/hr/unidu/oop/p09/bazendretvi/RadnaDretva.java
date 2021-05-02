package hr.unidu.oop.p09.bazendretvi;

public class RadnaDretva implements Runnable {
    private int nazivDretve;
    private boolean brza;
    public RadnaDretva(int s, boolean b){
        nazivDretve=s;
        brza = b;
    }
 
    public void run() {
        System.out.println(Thread.currentThread().getName()+" (Start) dretva = "+nazivDretve);
        obrada();
        System.out.println(Thread.currentThread().getName()+" (End)");
    }
 
    private void obrada() {
    	try {
    		System.out.println(Thread.currentThread().getName() + " (Radi) dretva = "+nazivDretve);
    		if (!brza)
    			Thread.sleep(5000);  
    		else
    			Thread.sleep(1);
		} catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
    }
}

