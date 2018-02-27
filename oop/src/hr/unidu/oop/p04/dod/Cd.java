package hr.unidu.oop.p04.dod;

public class Cd extends Medij {
    private String tip;
    public String getTip() {
        return tip;
    }
    public void setTip(String t) {
        this.tip=t;
    }
    public String info(){
        return "Ovo je CD medij!";
    }
    public boolean pecenjeDiska() {
        System.out.println(info());
        if (isPrazan() || isRw()){
            System.out.println("Pe�e CD!");
            return true;
        }
        else {
            System.out.println("CD nije prazan niti RW!");
            return false;
        }
        
    }
}