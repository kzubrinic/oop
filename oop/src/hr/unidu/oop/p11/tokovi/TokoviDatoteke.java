package hr.unidu.oop.p11.tokovi;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Stream;

public class TokoviDatoteke {

	public static void main(String[] args) {
		new TokoviDatoteke().kreni();

	}

	private void kreni()  {
		Comparator<String> usp = (o1, o2) -> Collator.getInstance(Locale.forLanguageTag("hr")).compare(o1, o2);

		try(Stream<String> tok1 = 	Files.lines(Paths.get("baza/ulaz1.txt"));
				Stream<String> tok2 = 	Files.lines(Paths.get("baza/ulaz2.txt"), Charset.forName("ISO-8859-2"));){

		tok2.distinct()
	    	.sorted(usp)
	    	.forEach(System.out::println);
		
		System.out.println("-------------------------------------------------------");
	    
		tok1.distinct()
		  .filter(element -> element.contains("začarana"))
		  .map(element -> element.toUpperCase())
		  .sorted(usp)
		  .forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
