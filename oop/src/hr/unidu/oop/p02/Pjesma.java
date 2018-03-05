package hr.unidu.oop.p02;
public class Pjesma {
	private String autor;
	public void sviranje(String novi) {
		autor = novi;
		System.out.println("Svira " + autor);
	}
	public static void main(String[] args) {
     	Pjesma p1 = new Pjesma();
     	p1.sviranje("Mozart");
     	Pjesma p2 = new Pjesma();
     	p1.sviranje("Bach");
    }
}
