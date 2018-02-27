package hr.unidu.oop.p04.primjer1;
public class Pacijent {
	public static void main(String[] args) {
		Pedijatar prvi=new Pedijatar();
		Kirurg drugi=new Kirurg();
		prvi.piseRecepte();
		prvi.lijeciPacijente();
		drugi.lijeciPacijente();
	}
}
