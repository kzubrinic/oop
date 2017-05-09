package oop.projekt.apl;
public class Student {
    private int id;
    private static int idBrojac = 0;
    private String imePrezime;
    private String email;

    public Student(String i, String e){
        imePrezime = i;
        email = e;
        idBrojac = idBrojac + 10;
        id = idBrojac;
    }

    public Student(int id, String i, String e){
        this.id = id;
        imePrezime = i;
        email = e;
    }
    
    public int getId(){
        return id;
    }

    public String getImePrezime(){
        return imePrezime;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String e){
        email = e;
    }

    public String toString(){
        return id+ " " + imePrezime + " " + email;
    }

    public boolean equals(Object obj){
        if (this == obj) {
			return true;
		}
		if ((obj == null) || !(obj instanceof Student)){
			return false;
		}
		Student drugi = (Student) obj;
		return (imePrezime != null && imePrezime.equals(drugi.imePrezime)) ;
    }

    public int hashCode(){
        final int prim = 31;
		int hash = 1;
		hash = prim * hash + (null == imePrezime ? 0 : imePrezime.hashCode());
		return hash;
    }
}