public class Osobe{
  public void radi() {
    Osoba p1, p2, p3; 
    p1 = new Osoba();
    p1.ime = "Pero Periæ";
    p2 = new Osoba();
    p2.ime = "Ana Aniæ";
    p3 = p2; 
    System.out.println("Moj prvi prijatelj je "+p1.ime);
    System.out.println("Moj drugi prijatelj je "+p2.ime);
    System.out.println("Moj treæi prijatelj je isti kao i drugi "+p3.ime);        
    p3.ime = "Ivo Iviæ";
    System.out.println("Moj treæi prijatelj je "+p3.ime);
  }    
}
