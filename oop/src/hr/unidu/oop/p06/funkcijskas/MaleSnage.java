package hr.unidu.oop.p06.funkcijskas;

import java.util.function.Predicate;

public class MaleSnage implements Predicate<Automobil> {
	@Override
	public boolean test(Automobil t) {
		return t.getKategorija() == Kategorija.DO_55;
	}
}
