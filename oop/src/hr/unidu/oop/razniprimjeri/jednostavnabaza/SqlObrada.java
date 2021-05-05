package hr.unidu.oop.razniprimjeri.jednostavnabaza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlObrada implements Obrada{
	private Connection conn;
	private String spojniURL = "jdbc:sqlite:baza/korisnici.db";

	public SqlObrada() {
		Connection co;
		try {
			co = DriverManager.getConnection(spojniURL);
			conn = co;
			provjeriTablicu();
		} catch (SQLException se) {
			prikaziSqlIznimke(se);
		}
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			prikaziSqlIznimke(e);
		}
	}

	public List<Korisnik> citanjeKorisnika() {
		// Pripremi upit
		String upit = "SELECT KORISNIK, IME FROM KORISNIK";
		List<Korisnik> l = new ArrayList<>();
		try (Statement stmt = conn.createStatement();
				// Izvedi upit - napuni skup rezultata u objekt tipa ResultSet. Svaki redak
				// tablice
				// je jedan element skupa rezultata.
				ResultSet rs = stmt.executeQuery(upit)) {
			// Prođi kroz sve retke tablice koje je vratio sql - jedan po jedan
			while (rs.next()) {
				// getter metoda koja dohvaća podatke može kao konstruktor primati ili NAZIV
				// stupca
				// u tablici iz koje se čita (vidi id i autora!) ili REDNI BROJ (prvi stupac ima
				// indeks 1, drugi 2, treći 3,... -> vidi NAZIV knjige). Za svaki tip podatka
				// postoji posebna getter metoda.
				l.add(new Korisnik(rs.getString("KORISNIK"), rs.getString("IME")));
			}
			return l;
		} catch (SQLException se) {
			prikaziSqlIznimke(se);
			return null;
		}
	}

	public Korisnik citanjeKorisnika(String kor) {
		// Pripremi upit
		String upit = "SELECT KORISNIK, IME FROM KORISNIK WHERE KORISNIK = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(upit)) {
			pstmt.setString(1, kor);
			try (ResultSet res = pstmt.executeQuery()) {
				// Ako je upit vratio barem jedan slog, već postoji takav zapis
				if (res.next()) {
					return new Korisnik(res.getString("KORISNIK"), res.getString("IME"));
				}
			}
		} catch (SQLException se) {
			prikaziSqlIznimke(se);
			return null;
		}
		return null;
	}

	public Rezultat unos(Korisnik k) {
		String upit = "INSERT INTO KORISNIK (KORISNIK, IME) values (?, ?)";
		if (citanjeKorisnika(k.getKorisnik()) != null) {
			return new Rezultat("Podatak s korisničkim imenom " + k.getKorisnik() + " već postoji u bazi!", true);
		}
		// Priprema upit za izvođenje. Kod izvođenja se samo na odgovarajuća mjesta
		// zapisuju konkretne vrijednosti (konkretan id, naziv, autor).
		try (PreparedStatement pstmt = conn.prepareStatement(upit)) {
			// Postavljaju se konkretne vrijednosti naziva, autora i id-ja.
			pstmt.setString(1, k.getKorisnik());
			pstmt.setString(2, k.getIme());
			// Upit koji mijenja tablicu se izvodi pomoću metode executeUpdate
			pstmt.executeUpdate();
			return new Rezultat("Dodavanje korisnika " + k.getKorisnik() + " je uspješno!", false);
		} catch (SQLException se) {
			return new Rezultat(prikaziSqlIznimke(se), true);
		} catch (Exception e) {
			e.getStackTrace();
			return new Rezultat(e.getMessage(), true);
		}
	}

	public Rezultat izmjena(Korisnik k) {
		if (citanjeKorisnika(k.getKorisnik()) == null) {
			return new Rezultat("Podatak s korisničkim imenom " + k.getKorisnik() + " ne postoji u bazi!", true);
		}
		String upit = "UPDATE KORISNIK SET IME=? WHERE  KORISNIK = ?";
		// Priprema upit za izvođenje. Kod izvođnja se samo na odgovarajuća mjesta
		// zapisuju konkretne vrijednosti (konkretan id, naziv, autor).
		try (PreparedStatement pstmt = conn.prepareStatement(upit)) {
			// Postavljaju se konkretne vrijednosti naziva, autora i id-ja.
			pstmt.setString(1, k.getIme());
			pstmt.setString(2, k.getKorisnik());
			// Upit se izvodi
			pstmt.executeUpdate();
			System.out.println("Izmjena korisnika " + k.getKorisnik() + " je uspješna!");
			return new Rezultat("Izmjena korisnika " + k.getKorisnik() + " je uspješna!", false);
		} catch (SQLException se) {
			return new Rezultat(prikaziSqlIznimke(se), true);
		} catch (Exception e) {
			e.getStackTrace();
			return new Rezultat(e.getMessage(), true);
		}
	}

	public Rezultat brisanje(String kor) {
		if (citanjeKorisnika(kor) == null) {
			System.out.println("Korisnik " + kor + " ne postoji u bazi!");
			return new Rezultat("Podatak s korisničkim imenom " + kor + " ne postoji u bazi!", true);
		}
		String upit = "DELETE FROM KORISNIK WHERE KORISNIK = ?";
		// Priprema upit za izvođenje. Kod izvođenja se samo na odgovarajuća mjesta
		// zapisuje konkretna vrijednost id-ja.
		try (PreparedStatement pstmt = conn.prepareStatement(upit)) {
			// Postavljaju se konkretna vrijednost id-ja
			pstmt.setString(1, kor);
			// Upit koji mijenja tablicu se izvodi pomoću metode executeUpdate
			pstmt.executeUpdate();
			System.out.println("Brisanje korisnika " + kor + " je uspješno!");
			return new Rezultat("Brisanje korisnika " + kor + " je uspješno!", false);
		} catch (SQLException se) {
			return new Rezultat(prikaziSqlIznimke(se), true);
		} catch (Exception e) {
			e.getStackTrace();
			return new Rezultat(e.getMessage(), true);
		}
	}


	private void provjeriTablicu() throws SQLException {
		// Provjera postoji li tablica u bazi
		DatabaseMetaData metadata = conn.getMetaData();
		try (ResultSet resultSet = metadata.getTables(null, null, "KORISNIK", null)) {
			if (resultSet.next())
				return; // tablica KORISNIK ne postoji

			String upit = "CREATE TABLE KORISNIK(KORISNIK TEXT PRIMARY KEY, IME TEXT)";
			Statement stmt = conn.createStatement();
			// Postavljaju se konkretna vrijednost id-ja
			stmt.executeUpdate(upit);
			stmt.close();
			System.out.println("Tablica KORISNIK je stvorena!");
		} catch (SQLException se) {
			prikaziSqlIznimke(se);
		}
	}

	// Može biti više SQL iznimaka - proći kroz sve!
	private String prikaziSqlIznimke(SQLException se) {
		StringBuilder sb = new StringBuilder();
		while (se != null) {
			sb.append("Stanje: " + se.getSQLState());
			sb.append("Poruka: " + se.getMessage());
			sb.append("Greška: " + se.getErrorCode());
			System.out.println("Stanje: " + se.getSQLState());
			System.out.println("Poruka: " + se.getMessage());
			System.out.println("Greška: " + se.getErrorCode());
			se = se.getNextException();
		}
		return sb.toString();
	}
	
}
