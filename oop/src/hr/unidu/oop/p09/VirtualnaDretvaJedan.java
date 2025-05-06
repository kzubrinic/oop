package hr.unidu.oop.p09;

/**
 * Virtualna dretva pomoću implementacije sučelja Prvi način stvaranja Java min.
 * verzije 21
 * 
 * @author Krunoslav Žubrinić
 */
public class VirtualnaDretvaJedan implements Runnable {
	// Posao koji se obavlja u dretvi stavlja se u metodu run
	public void run() {
		// dohvaća naziv trenutne dretve
		String naziv = Thread.currentThread().getName();
		System.out.println("Virtualna dretva (implem) " + naziv + " radi.");
	}

	public static void main(String args[]) throws InterruptedException {
		VirtualnaDretvaJedan obj = new VirtualnaDretvaJedan();
		obj.virtualna();
		obj.virtualnaAnonimna();
		obj.virtualnaLambda();
	}

	private void virtualna() throws InterruptedException {
		Runnable obj = new VirtualnaDretvaJedan();
		// Stvara neimenovanu virtualnu dretvu, zadaje posao koji
		// treba odraditi i pokreće dretvu
		Thread t1 = Thread.startVirtualThread(obj);
		// Čekamo da dretva završi za nastavak obrade.
		// Bez ove naredbe program biu se često završio prije dretve i
		// na zaslonu ne bismo vidjeli rezultat izvođenja.
		// Metoda join izbacuje provjeravanu iznimku InterruptedException
		t1.join();
	}

	private void virtualnaAnonimna() throws InterruptedException {
		Thread t1 = Thread.startVirtualThread(new Runnable() {
			@Override
			public void run() {
				// Posao koji se obavlja u dretvi stavlja se u metodu run funkcijskog sučelja
				String naziv = Thread.currentThread().getName();
				System.out.println("Virtualna dretva (anon) " + naziv + " radi.");
			}
		});
		// izvodi programski kod metode run() kada dretva dođe na red
		t1.join();
	}

	private void virtualnaLambda() throws InterruptedException {
		Thread t1 = Thread.startVirtualThread(() -> {
			// Posao koji se obavlja u dretvi stavlja se u metodu run funkcijskog sučelja
			String naziv = Thread.currentThread().getName();
			System.out.println("Virtualna dretva (lambda)" + naziv + " radi.");
		});
		// izvodi programski kod lambda izraza kada dretva dođe na red
		t1.join();
	}

}
