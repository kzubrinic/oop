package hr.unidu.oop.p02;
import hr.unidu.oop.p01.Osoba;
public class Osobe{
  public void radi() {
    Osoba p1, p2, p3; 
    p1 = new Osoba();
    p1.ime = "Pero Perić";
    p2 = new Osoba();
    p2.ime = "Ana Anić";
    p3 = p2; 
    System.out.println("Moj prvi prijatelj je "+p1.ime);
    System.out.println("Moj drugi prijatelj je "+p2.ime);
    System.out.println("Moj treći prijatelj je isti kao i drugi "+p3.ime);        
    p3.ime = "Ivo Ivić";
    System.out.println("Moj treći prijatelj je "+p3.ime);
  }    
}
