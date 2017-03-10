package oop.projekt.apl;
public class Student {
    private int id;
    private static int idBrojac = 0;
    private String ime;
    private String prezime;
    private String email;
    private Sveuciliste sveuciliste;

    public Student(String i, String p, String e, Sveuciliste s){
        ime = i;
        prezime = p;
        email = e;
        sveuciliste = s;
        idBrojac = idBrojac + 10;
        id = idBrojac;

    }

    public int getId(){
        return id;
    }

    public String getIme(){
        return ime;
    }

    public String getPrezime(){
        return prezime;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String e){
        email = e;
    }

    public Sveuciliste getSveuciliste(){
        return sveuciliste;
    }

    public String toString(){
        return id+ " " + ime + " " + prezime + " " + email;
    }

    public boolean equals(Object obj){
        if (this == obj) {
			return true;
		}
		if ((obj == null) || !(obj instanceof Student)){
			return false;
		}
		Student drugi = (Student) obj;
		return ((ime != null && ime.equals(drugi.ime)) && (prezime != null && prezime.equals(drugi.prezime)));
    }

    public int hashCode(){
        final int prim = 31;
		int hash = 1;
		hash = prim * hash + (null == ime ? 0 : ime.hashCode());
		hash = prim * hash + (null == prezime ? 0 : prezime.hashCode());
		return hash;
    }
}