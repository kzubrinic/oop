package hr.unidu.oop.p02;
public class Osobe{
  public void radi() {
    Osoba p1, p2, p3; 
    p1 = new Osoba();
    p1.ime = "Pero Peri�";
    p2 = new Osoba();
    p2.ime = "Ana Ani�";
    p3 = p2; 
    System.out.println("Moj prvi prijatelj je "+p1.ime);
    System.out.println("Moj drugi prijatelj je "+p2.ime);
    System.out.println("Moj tre�i prijatelj je isti kao i drugi "+p3.ime);        
    p3.ime = "Ivo Ivi�";
    System.out.println("Moj tre�i prijatelj je "+p3.ime);
  }    
}
