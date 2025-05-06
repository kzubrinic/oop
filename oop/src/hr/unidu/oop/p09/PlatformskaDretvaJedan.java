package hr.unidu.oop.p09;

/**
 * Platformska dretva pomoću implementacije sučelja Prvi način stvaranja
 * 
 * @author Krunoslav Žubrinić
 */
public class PlatformskaDretvaJedan implements Runnable {
	// Posao koji se obavlja u dretvi stavlja se u metodu run
	public void run() {
		// dohvaća naziv trenutne dretve
		String naziv = Thread.currentThread().getName();
		System.out.println("Platformska dretva (implem) " + naziv + " radi.");
	}

	public static void main(String args[]) throws InterruptedException {
		PlatformskaDretvaJedan obj = new PlatformskaDretvaJedan();
		obj.platformska();
		obj.platformskaAnonimna();
		obj.platformskaLambda();
	}

	private void platformska() throws InterruptedException {
		Runnable obj = new PlatformskaDretvaJedan();
		// Stvara neimenovanu virtualnu dretvu, zadaje posao koji
		// treba odraditi i pokreće dretvu
		Thread t1 = new Thread(obj);
		// izvodi programski kod metode run() kada dretva dođe na red
		t1.start();
		// Čekamo da dretva završi za nastavak obrade.
		// Bez ove naredbe program biu se često završio prije dretve i
		// na zaslonu ne bismo vidjeli rezultat izvođenja.
		// Metoda join izbacuje provjeravanu iznimku InterruptedException
		t1.join();
	}

	private void platformskaAnonimna() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// Posao koji se obavlja u dretvi stavlja se u metodu run funkcijskog sučelja
				String naziv = Thread.currentThread().getName();
				System.out.println("Platformska dretva (anon) " + naziv + " radi.");
			}
		});
		// izvodi programski kod metode run() kada dretva dođe na red
		t1.start();
		// Čekamo da dretva završi za nastavak obrade.
		// Bez ove naredbe program biu se često završio prije dretve i
		// na zaslonu ne bismo vidjeli rezultat izvođenja.
		// Metoda join izbacuje provjeravanu iznimku InterruptedException
		t1.join();
	}

	private void platformskaLambda() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			// Posao koji se obavlja u dretvi stavlja se u metodu run funkcijskog sučelja
			String naziv = Thread.currentThread().getName();
			System.out.println("Platformska dretva (lambda) " + naziv + " radi.");
		});
		// izvodi programski kod lambda izraza kada dretva dođe na red
		t1.start();
		// Čekamo da dretva završi za nastavak obrade.
		// Bez ove naredbe program biu se često završio prije dretve i
		// na zaslonu ne bismo vidjeli rezultat izvođenja.
		// Metoda join izbacuje provjeravanu iznimku InterruptedException
		t1.join();
	}

}
