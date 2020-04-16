package hr.unidu.oop.p08.simplemvc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MvcModel {
	private List<String> podaci;
	public MvcModel() {
		podaci = napuniModel();
	}
	public List<String> getPodaci(){
		return podaci;
	}
	private List<String> napuniModel() {
		Path path=Paths.get("baza/mvc-ulaz.txt");
	    try {
			return Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<String>();
		}
	}
}
