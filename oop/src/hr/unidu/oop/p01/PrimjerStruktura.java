package hr.unidu.oop.p01;
 


/**
 * Primjer programskih struktura (grananja i petlje)
 * 
 * @author Kruno 
 * @version velja�a 2015.
 */
public class PrimjerStruktura{
    public void grananje(int starost){
        if (starost < 13)
            System.out.println("Dijete");
        else if ((starost > 12) && (starost < 20))
            System.out.println("Tinejdžer");
        else if ((starost > 19) && (starost < 41))
            System.out.println("Mlada osoba");
        else if ((starost > 40) && (starost < 61))
            System.out.println("Srednje stara osoba");
        else
            System.out.println("Stara osoba");
    }
    public void forPetlja(int n){
        for (int i=0; i<n; i++){
            if (i % 2 == 0)
                System.out.println(i + " je paran broj.");
            else 
                System.out.println(i + " je neparan broj.");
        }
    }
    public void forEachPetlja(){
        int[] brojevi = {2, 7, 3, 8, 6, 4, 1, 5, 9, 12, 11};
        for (int broj : brojevi){
            if (broj % 2 == 0)
                System.out.println(broj + " je paran broj.");
            else 
                System.out.println(broj + " je neparan broj.");
        }

    }
    public void whilePetlja(){
        int[] brojevi = {2, 7, 3, 8, 6, 4, 1, 5, 9, 12, 11};
        int i = 0;
        while (i < brojevi.length){
            if (brojevi[i] % 2 == 0)
                System.out.println(brojevi[i] + " je paran broj.");
            else 
                System.out.println(brojevi[i] + " je neparan broj.");
            i++;
        }
    }
    public void doWhilePetlja(){
        int[] brojevi = {2, 7, 3, 8, 6, 4, 1, 5, 9, 12, 11};
        int i = 0;
        do {
            if (brojevi[i] % 2 == 0)
                System.out.println(brojevi[i] + " je paran broj.");
            else 
                System.out.println(brojevi[i] + " je neparan broj.");
            i++;
        } while (i < brojevi.length);
    }
    public void breakContinue(){
        int[] brojevi = {2, 7, 3, 8, 6, 0, 1, 5, 9, 12, 11};
        int i = 0;
        while (i < brojevi.length){
            // ako je broj nula, prekini izvo�enje while petlje
            if (brojevi[i] == 0)
                break;
            // ako je broj troznamenkasti ili ve�i, presko�i ga
            else if (brojevi[i] > 99)
                continue;
            else
            // ina�e, ispi�i broj
                System.out.println(brojevi[i]);
            i++;
        }
    }
    public void switchCase(int mjesec){
        switch (mjesec) {
        case 3:  
        	System.out.print("Ožujak");
        	break;    
        case 4:  
        	System.out.print("Travanj");
        	break;
        case 5:  
        	System.out.print("Svibanj");
        	break;
        default:  
        	System.out.print("Nije proljetni mjesec!");
        }
    }
    public static void main(String[] args){
        PrimjerStruktura p = new PrimjerStruktura();
        p.grananje(17);
        p.forPetlja(10);
        p.forEachPetlja();
        p.whilePetlja();
        p.doWhilePetlja();
        p.breakContinue();
        p.switchCase(4);
    }
}


