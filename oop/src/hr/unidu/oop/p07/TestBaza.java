package hr.unidu.oop.p07;
/**
 * Primjer rada s JDBC-om
 * baza sqlite
 */
// Sučelja koja sadrže opise apstraktnih metoda koje se koriste pri radu
// s konkretnom bazom opisana su u paketu java.sql.
import java.sql.* ;
public class TestBaza	{
	private Connection conn;

    private void citanjeSvih() {
		// Pripremi upit
		String upit = "SELECT ID, NAZIV, AUTOR FROM KNJIGE";
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery( upit )){
			// Izvedi upit - napuni skup rezultata u objekt tipa ResultSet. Svaki redak tablice
			// je jedan element skupa rezultata.
			System.out.println("----------------------------------------------------------------") ;
			// Prođi kroz sve retke tablice koje je vratio sql - jedan po jedan
			while(rs.next()){
				// getter metoda koja dohvaća podatke može kao konstruktor primati ili NAZIV stupca
				// u tablici iz koje se čita (vidi id i autora!) ili REDNI BROJ (prvi stupac ima
				// indeks 1, drugi 2, treći 3,... -> vidi NAZIV knjige). Za svaki tip podatka
				// postoji posebna getter metoda.
				System.out.println( rs.getInt("ID") + ", " + rs.getString(2)+ ", " + rs.getString("AUTOR") ) ;
			}
			System.out.println("----------------------------------------------------------------") ;
		}catch(SQLException se) {
			prikaziSqlIznimke(se);
		}
	}

	private void unos(int id, String naziv, String autor){
		// Ako zapis sa zadanim ID-jem već postoji ne smije se dodavati
		if (trazi(id)){
			System.out.println("Podatak s IDjem "+id+ " već postoji u bazi!");
			return;
		}
		String upit = "insert into KNJIGE (ID, NAZIV, AUTOR) values (?, ?, ?)";
		// Priprema upit za izvođenje. Kod izvođenja se samo na odgovarajuća mjesta
		// zapisuju konkretne vrijednosti (konkretan id, naziv, autor).
		try (PreparedStatement pstmt = conn.prepareStatement(upit)){
			// Postavljaju se konkretne vrijednosti naziva, autora i id-ja.
			pstmt.setInt(1, id);
			pstmt.setString(2, naziv);
			pstmt.setString(3, autor);
			// Upit koji mijenja tablicu se izvodi pomoću metode executeUpdate
			pstmt.executeUpdate();
			System.out.println("Dodavanje zapisa s rednim brojem "+id+" je uspješno!");
		}catch(SQLException se) {
			prikaziSqlIznimke(se);
		} 
	}

	private void izmjena(int id, String naziv, String autor) {
		// Ako zapis sa zadanim ID-jem ne postoji ne smije se ažurirati
		if (!trazi(id)){
			System.out.println("Podatak s IDjem "+id+ " ne postoji u bazi!");
			return;
		}
		String upit = "update KNJIGE set NAZIV=?,AUTOR=? where ID=?";
		// Priprema upit za izvođenje. Kod izvođnja se samo na odgovarajuća mjesta
		// zapisuju konkretne vrijednosti (konkretan id, naziv, autor).
		try (PreparedStatement pstmt = conn.prepareStatement(upit)){
			// Postavljaju se konkretne vrijednosti naziva, autora i id-ja.
			pstmt.setString(1, naziv);
			pstmt.setString(2, autor);
			pstmt.setInt(3, id);
			// Upit se izvodi
			pstmt.executeUpdate();
			System.out.println("Izmjena zapisa s rednim brojem "+id+" je uspješna!");
		}catch(SQLException se) {
			prikaziSqlIznimke(se);
		} 	
	}

	private void brisanje(int id) {
		// Ako zapis sa zadanim ID-jem ne postoji ne smije se brisati
		if (!trazi(id)){
			System.out.println("Podatak s IDjem "+id+ " ne postoji u bazi!");
			return;
		}
		String upit = "delete from KNJIGE where ID=?";
		// Priprema upit za izvođenje. Kod izvođenja se samo na odgovarajuća mjesta
		// zapisuje konkretna vrijednost id-ja.
		try (PreparedStatement pstmt = conn.prepareStatement(upit)){
			// Postavljaju se konkretna vrijednost id-ja
			pstmt.setInt(1, id);
			// Upit koji mijenja tablicu se izvodi pomoću metode executeUpdate
			pstmt.executeUpdate();	
			System.out.println("Brisanje zapisa s rednim brojem "+id+" je uspješno!");
		}catch(SQLException se) {
			prikaziSqlIznimke(se);
		} 
	}

	private boolean trazi(int id) {
		// ? će se kod izvođenja zamijeniti konkretnom vrijednošću.
		// Na ovakav način se štitimo od napada umetanjem sql-a
		String upit = "select ID from KNJIGE where ID = ?";
		// Priprema upit za izvođenje. Kod izvođenja se samo na odgovarajuća mjesta
		// zapisuje konkretna vrijednost id-ja.
		try (PreparedStatement pstmt = conn.prepareStatement(upit)){
			// Postavlja se konkretna vrijednost id-ja
			pstmt.setInt(1, id);
			// Upit koji čita iz tablica (vraća retke) se izvodi pomoću executeQuery
			try(ResultSet res = pstmt.executeQuery()){
				// 	Ako je upit vratio barem jedan slog, već postoji takav zapis
				if (res.next()) {
					return true;
				}
			}
			return false;
		} catch(SQLException se) {
			prikaziSqlIznimke(se);
			return false;
		}
		
	}
	
	private void provjeriTablicu() throws SQLException{
		// Provjera postoji li tablica KNJIGE u bazi
		DatabaseMetaData metadata = conn.getMetaData();
		try(ResultSet resultSet = metadata.getTables(null, null, "KNJIGE", null)){
			if(resultSet.next())
			    return; // tablica KNJIGE postoji
			
			String upit = "create table KNJIGE (ID INTEGER PRIMARY KEY, NAZIV TEXT, AUTOR TEKST)";
			Statement stmt = conn.createStatement();
			// Postavljaju se konkretna vrijednost id-ja
			stmt.executeUpdate(upit);	
			stmt.close();
			System.out.println("Tablica KNJIGE je stvorena!");	
		}catch(SQLException se) {
			prikaziSqlIznimke(se);
		}
	}
	
	// Može biti više SQL iznimaka - proći kroz sve!
	private void prikaziSqlIznimke(SQLException se) {
		while(se != null) {
			System.out.println( "Stanje: " + se.getSQLState()  ) ;
			System.out.println( "Poruka: " + se.getMessage()   ) ;
			System.out.println( "Greška: " + se.getErrorCode() ) ;
			se = se.getNextException() ;
		}
	}

	public static void main(String[] args){
		TestBaza t = new TestBaza();
		// Spaja se na bazu
        // URL za spajanje na "embedded" bazu knjiznica.db koja je stvorena u mapi baza/
        // U projekt mora biti uključen JAR koji sadrži konkretnu implementaciju programa
        // za rad s konkretnom bazom (u ovoj verziji korišten je sqlite-jdbc-3.21.0.jar ).
        String spojniURL = "jdbc:sqlite:baza/knjiznica.db";
        try(Connection co = DriverManager.getConnection(spojniURL)) {
			t.conn = co;
			t.provjeriTablicu();
			// čita sve iz tablice knjige i prikazuje na zaslonu
			t.citanjeSvih();
			// Dodaje novi zapis s id-jem 200
			t.unos(200,"Nova knjiga", "Novi autor");
			t.unos(201,"Druga knjiga", "Novi autor");
			t.unos(202,"Treća knjiga", "Treći autor");
			// čita sve iz tablice knjige i prikazuje na zaslonu. 
			// sada se prikazuje i novo dodani zapis s id-jem 200
			t.citanjeSvih();
			// Mijenja se naziv knjige s id-jem 200
			t.izmjena(200,"Najnovija izmjenjena knjiga", "Novi autor");
			// čita sve iz tablice knjige i prikazuje na zaslonu.
			t.citanjeSvih();
			// Briše se redak s id-jem 200
			t.brisanje(200);
			// čita sve iz tablice knjige i prikazuje na zaslonu.
			// Stanje bi trebalo biti jednako početnom.
			t.citanjeSvih();
			// Veza na bazu se zatvara automatski jer je konekcija stvorena unutar try bloka.
		} catch(SQLException se ) {
			// Može biti više SQL iznimaka - proći kroz sve!
			t.prikaziSqlIznimke(se);
		}
		catch(Exception e) {
			System.out.println(e.getMessage()) ;
			e.getStackTrace();
		}
	}
}