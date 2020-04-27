package hr.unidu.oop.p09;

public class KomunikacijaMedjuDretvama {
	public static void main(String args[]){  
		final Klijent c = new Klijent();  
		new Thread(){  
			public void run(){
				c.skini(15000);
			}  
		}.start();  
		new Thread(){  
			public void run(){
				c.stavi(10000);
			}  
		}.start();  
	} 
}

class Klijent{  
	int iznos = 10000;  
	synchronized void skini(int iznos){  
		System.out.println("Isplata s računa...");  
		if(this.iznos < iznos){  
				System.out.println("Nedovoljno novca na stanju. Čeka se uplata...");  
				try{
					wait(); // čekaj jer nema dovoljno na stanju
				}catch(Exception e){
					e.printStackTrace();
				}  
		}  
		this.iznos -= iznos;  
		System.out.println("Isplata izvršena...");  
	}  
	  
	synchronized void stavi(int iznos){  
		System.out.println("Uplata na račun...");  
		this.iznos += iznos;  
		System.out.println("Iznos uplaćen na račun... ");  
		notify();  // obavijesti o uplati zaintersirane dretve
	}  
}  
