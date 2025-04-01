package hr.unidu.oop.p06.funkcijskas;

import java.util.function.Predicate;

public class PotencijalnoAgresivni implements Predicate<Automobil> {
	@Override
	public boolean test(Automobil t) {
		return t.getBoja() == Boja.CRVENA;
	}
}
