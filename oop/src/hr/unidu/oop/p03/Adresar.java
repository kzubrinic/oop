package hr.unidu.oop.p03;
 
/**
 * Razred Adresar
 * Osnovni podaci kontakata
 * @version velja�a 2016.
 */
public class Adresar
{
  private String imePrezime;
  private String adresa;
  private String telefon;
  private String eMail;
  public void noviKontakt(String imePrezime, String adresa, String telefon, String eMail) {
    this.imePrezime = imePrezime;
    this.adresa = adresa;
    this.telefon = telefon;
    this.eMail = eMail;
  }
  public void ispisiKontakt(){
    System.out.println("Ime i prezime/naziv: " + imePrezime);
    System.out.println("Adresa: " + adresa);
    System.out.println("Telefon: " + telefon);
    System.out.println("E-mail: " + eMail);
  }
}
