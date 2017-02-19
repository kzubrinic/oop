public class Pas
{
    private String pasmina;
    private String ime;
    
    public void referenca() {
        Pas reks = new Pas();
        reks.ime = "Rex";
        reks.pasmina = "njemaèki ovèar";
        System.out.println(reks.ime+ " je " + reks.pasmina);
        Pas cuvar;
        cuvar = reks;
        cuvar.pasmina = "labrador";
        System.out.println(reks.ime+ " je " + reks.pasmina);
    }  
    public void glasanje(){
        System.out.println("Vau vau!");
    }
}
