package hr.unidu.oop.p04.dod;

public class Dvd extends Medij {
	private String brojSlojeva;

	public String getBrojSlojeva() {
		return brojSlojeva;
	}

	public void setBrojSlojeva(String n) {
		brojSlojeva = n;
	}
	public String info (){
        return "Ovo je DVD medij!";
    }
	public boolean pecenjeDiska() {
        System.out.println(info());
        if (isPrazan() || isRw()){
            System.out.println("Pe�e DVD!");
            return true;
        }
        else {
            System.out.println("DVD nije prazan niti RW!");
            return false;
        }
    }
}