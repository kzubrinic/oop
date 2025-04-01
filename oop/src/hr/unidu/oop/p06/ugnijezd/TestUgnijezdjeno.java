package hr.unidu.oop.p06.ugnijezd;

public class TestUgnijezdjeno {

	public static void main(String[] args) {
		// Objekt tipa vanjske klase - potreban je kod stvaranja objekta tipa unutarnje klase 
		VanjskaKlasa vk = new VanjskaKlasa();
		
		// Stvara se objekt tipa ugniježđene statičke klase
		VanjskaKlasa.StatickaUgnijezdjenaKlasa ins = new VanjskaKlasa.StatickaUgnijezdjenaKlasa();
		// Kako bi ugniježđena statička klasa mogla raditi s varijablama vanjske klase koje 
		//   nisu static, treba im referenca na vanjsku klasu.
		ins.radi(vk);
		
		
		// Stvara se objekt tipa unutarnje klase korištenjem operatora new na objektu tipa vanjske klase
		VanjskaKlasa.UnutarnjaKlasa uk = vk.new UnutarnjaKlasa();
		uk.radi();
	}

}
