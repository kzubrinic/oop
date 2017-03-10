package oop.projekt.apl; 
public class Sveuciliste {
    private String naziv;
    private Student[] studenti;
    private int rb;
    
    public Sveuciliste(String m){
        naziv = m;
        studenti = new Student[1000];
    }

    public String getNaziv(){
        return naziv;
    }

    public Student dodajStudenta(String i, String p, String e){
        if (rb == 999)
            return null;
        Student s = nadjiStudentaPoImenuPrezimenu(i, p);
        if (s == null){
            s = new Student(i, p, e, this);
            studenti[rb] = s;
            rb++;
            return s;
        }
        return null;
    }

    public Student citajStudenta(int id){
        return nadjiStudentaPoIdju(id);
    }

    public int getBrojStudenata(){
        return rb;
    }

    public String ispisiSveStudente(){
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < rb; ++i){
            sb.append(studenti[i].toString());
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
        return true;
    }
    
    private Student nadjiStudentaPoIdju(int id){
        int i;
        for (i = 0; i < rb; ++i){
            if (studenti[i].getId() == id)
                return studenti[i];
        }
        return null;
    }
    private Student nadjiStudentaPoImenuPrezimenu(String im, String pr){
        int i;
        for (i = 0; i < rb; ++i){
            if (studenti[i].getIme().equals(im) && studenti[i].getPrezime().equals(pr))
                return studenti[i];
        }
        return null;
    }

}