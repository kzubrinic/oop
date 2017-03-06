class Macka {
    private int visina;
    public void setVisina(int visina) {
        if (visina < 1 || visina > 100) {
            System.out.println("Greška! visina mora biti između 1 i 100!");
        }
        else {
            this.visina=visina;
         }
    }
}
