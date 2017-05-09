package oop.projekt.apl; 
import java.util.*;
import oop.projekt.baza.Baza;
public class Sveuciliste {
    private String naziv;
    private Map<Integer,Student> studenti;
    private Baza b;
    // promjena konstruktora kako bi se predala referenca na bazu
    public Sveuciliste(String m, Baza b){
        naziv = m;
        this.b = b;
        studenti = b.citaj();
    }

    public String getNaziv(){
        return naziv;
    }

    public Student dodajStudenta(String i, String e){
        Student s = nadjiStudentaPoImenuPrezimenu(i);
        if (s == null){
            s = new Student(i, e);
            studenti.put(s.getId(),s);
            b.dodaj(s.getId(),s);
            return s;
        }
        return null;
    }

    public Student citajStudenta(int id){
        return nadjiStudentaPoIdju(id);
    }

    public int getBrojStudenata(){
        return studenti.size();
    }

    public String ispisiSveStudente(){
        StringBuilder sb = new StringBuilder();
        for (Student s : studenti.values()){
            sb.append(s.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String ispisiSveStudente(int id){
        Student s = nadjiStudentaPoIdju(id);
        if (s == null)
            return null;
        return s.toString();    
    }

    public boolean promjeniEmail(int id, String em){
        Student s = nadjiStudentaPoIdju(id);
        if (s == null)
            return false;
        s.setEmail(em);
        studenti.replace(id,s);
        b.izmjeni(id,s);
        return true;
    }
    
    private Student nadjiStudentaPoIdju(int id){
        if (studenti.containsKey(id))
            return studenti.get(id);
        return null;
    }
    private Student nadjiStudentaPoImenuPrezimenu(String im){
        for (Student s : studenti.values()){
            if (s.getImePrezime().equals(im))
                return s;
        }
        return null;
    }
}