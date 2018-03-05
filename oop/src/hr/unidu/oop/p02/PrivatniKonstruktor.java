package hr.unidu.oop.p02;

public class PrivatniKonstruktor {
		   private static PrivatniKonstruktor objekt;
		   private PrivatniKonstruktor() {} 
		   public static PrivatniKonstruktor stvoriObjekt() {
		      if(objekt == null) {
		         objekt = new PrivatniKonstruktor();
		      }
		      return objekt;
		   }
		   public String toString() {
			   return "Objekt stvoren iz klase s privatnim konstruktorom.";
		   }
}
