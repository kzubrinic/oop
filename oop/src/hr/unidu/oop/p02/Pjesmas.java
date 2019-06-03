package hr.unidu.oop.p02;
public class Pjesmas {
	private static String autor;
	public static void sviranje(String novi) {
		Pjesmas.autor = novi;
		System.out.println("Svira " + Pjesmas.autor);
	}
}
