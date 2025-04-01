package hr.unidu.oop.p06.ugnijezd;

public class VanjskaKlasa {
	private int i = 0;
	private static int si = 0;
	
	// statička ugniježđena klasa
	static class StatickaUgnijezdjenaKlasa { 
		void radi(VanjskaKlasa vk) {
			// Varijablama koje nisu static pristupa preko reference
			vk.i++;
			// Static varijablama pristupa izravno
			si++;
			System.out.println("Statička ugniježđena: " + vk.i + " : " + si);
		}
	}
	
	// Unutarnja klasa
	class UnutarnjaKlasa{ 
		void radi() {
			// Svim varijablama pristupa izravno
			i++;
			si++;
			System.out.println("Unutarnja: " + i + " : " + si);
		}
	}
}

