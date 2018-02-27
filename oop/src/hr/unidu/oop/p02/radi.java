package hr.unidu.oop.p02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class radi {

	public static void main(String[] args) throws IOException {
		String p1 = "/home/kruno/git/oop/oop/src/v02";
		String p2 = "/home/kruno/git/oop/oop/src/hr/unidu/oop/p03";
		Path novip = Paths.get(p2);
		Path starip = Paths.get(p1);
		File novi = new File(p2);
		File folder = new File(p1);
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isFile() && fileEntry.getName().endsWith(".java")) {
	        	starip = Paths.get(p2+"/"+fileEntry.getName());
	        	novip = Paths.get(p1+"/"+fileEntry.getName());
	            Files.copy(novip, starip, StandardCopyOption.REPLACE_EXISTING);
	            //String content = new String(Files.readAllBytes(Paths.get(p2+"/"+fileEntry.getName())));
	            //content = "package hr.unidu.oop.p03;\n" + content;
	            //Files.write(Paths.get(p2+"/"+fileEntry.getName()), content.getBytes(), StandardOpenOption.CREATE_NEW);
	        } else {
	            System.out.println(fileEntry.getName());
	        }
    }

	}

}
