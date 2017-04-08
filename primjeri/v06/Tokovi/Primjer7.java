package Tokovi;
/**
 * Èitanje podataka iz datoteke pomoæu metoda BufferedReader klase
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Primjer7 {

    public void citajRetke() {
        String c = "";
        String ime = "README.TXT";
        try(BufferedReader dat = new BufferedReader(new FileReader(ime))) {
            while ((c = dat.readLine()) != null) {
                // readLine() skida znak za novi red pa ga treba dodati za prikaz na ekranu
                System.out.println(c);
            }
        } catch (IOException e) {
            System.out.println("Greška èitanja datoteke " + ime + " !");
            e.printStackTrace();
        }
    }

    public void citajTokene() {
        String c = "";
        String ime = "README.TXT";
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(ime)))) {
            s.useDelimiter("o"); // razbijamo na slovu 'o'
            while ((s.hasNext())) {
                // metoda hasNext() provjerava da li postoji sljedeæi token
                // metoda next() pristupa nizu znakova
                System.out.println(s.next());
            }
        } catch (IOException e) {
            System.out.println("Greška èitanja datoteke " + ime + " !");
            e.printStackTrace();
        }
    }


}
