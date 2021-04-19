package hr.unidu.oop.razniprimjeri.guianagram;
/*
 * Pomoćna POJO klasa koja čuva podatke jednog pojma
 */
public class Anagram {
	private String anagram;
	private String rijec;
	public Anagram(String r, String a) {
		anagram = a;
		rijec = r;
	}
	public String getAnagram() {
		return anagram;
	}
	public String getRijec() {
		return rijec;
	}
}
