public class Macka
{
    private String vrsta;
    private String ime;
    
    public void referenca() {
        Macka kucna = new Macka();
        kucna.ime = "Tom";
        kucna.vrsta = "sijamska ma�ka";
        System.out.println(kucna.ime+ " je " + kucna.vrsta);
    }  
    public void glasanje(){
        System.out.println("Mijau!");
    }
}
