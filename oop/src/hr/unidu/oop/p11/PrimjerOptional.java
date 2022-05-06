package hr.unidu.oop.p11;

import java.util.Optional;
/*
 * Primjer prilagođen s javaTPoint, Java Optional Class
 * Izvornik dostupan na adresi: https://www.javatpoint.com/java-8-optional
 */
public class PrimjerOptional {

	public static void main(String[] args) {
	        String[] str = new String[3];        
	        str[0] = "TESTNI PRIMJER";  
	        // Stvara prazan objekt tipa Optional i ispisuje ga
	        Optional<String> empty = Optional.empty();  
	        System.out.println(empty);  
	        // Stvara objekt tipa Optional koji nije prazan
	        Optional<String> value = Optional.of(str[0]);
	        // Ako vrijednost za spremanje u objekt tipa optional nije null, vraća 
	        // neprazan objekt tipa Optional, inače vraća prazan objekt tipa Optional  
	        System.out.println("Nullable Optional: "+Optional.ofNullable(str[1]));  
	        // Ako zadana vrijednost postoji, vraća objekt tipa Optional koji nije prazan, a
	        //	inače vraća prazan objekt tipa Optional  
	        System.out.println("Filtrirana vrijednost: "+value.filter((s)->s.equals("Abc")));  
	        System.out.println("Filtrirana value: "+value.filter((s)->s.equals("TESTNI PRIMJER")));  
	        // Ako je vrijednost u objektu tipa Optional spremljena, vraća tu vrijednost, a
	        // 	inače izbacuje iznimku tipa NoSuchElementException    
	        System.out.println("Dohvaća vrijednost: "+value.get());  
	        // Vraća hashCode vrijednosti spremljene u objekt tipa Optional
	        System.out.println("Dohvaća hashCode: "+value.hashCode());  
	        System.out.println("Dohvaća hashCode vrijednosti: "+value.get().hashCode());  
	        // Vraća true ako je vrijednost spremljena u objekt tipa Optional (inače vraća false)  
	        System.out.println("Vrijednost je spremljena? "+value.isPresent());  
	        // Ako je vrijednost u objektu tipa Optional spremljena, vraća tu vrijednost,
	        //	inače vraća vrijednost predanu kao parametar.  
	        System.out.println("orElse: "+value.orElse("Vrijednost nije spremljena"));  
	        System.out.println("orElse: "+empty.orElse("Vrijednost nije spremljena"));
	        // Ispisuje vrijednost spremljenu u objekt tipa Optional  
	        value.ifPresent(e->System.out.println(e));     
	}

}
