package hr.unidu.oop.p07;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * Primjer rada s JDBC-om
 * baza sqlite
 */
// Sučelja koja sadrže opise apstraktnih metoda koje se koriste pri radu
// s konkretnom bazom opisana su u paketu java.sql.
import java.sql.* ;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class TestBazaNapredno	{
	private Connection conn;

    private List<Korisnik> citanjeSvih() {
		// Pripremi upit
		String upit = "SELECT ID, NAZIV, AUTOR FROM KNJIGE";
		List<Korisnik> l = new ArrayList<>();
		try (Statement stmt = conn.createStatement();
			// Izvedi upit - napuni skup rezultata u objekt tipa ResultSet. Svaki redak tablice
			// je jedan element skupa rezultata.
			ResultSet rs = stmt.executeQuery( upit )){
			// Prođi kroz sve retke tablice koje je vratio sql - jedan po jedan
			while(rs.next()){
				// getter metoda koja dohvaća podatke može kao konstruktor primati ili NAZIV stupca
				// u tablici iz koje se čita (vidi id i autora!) ili REDNI BROJ (prvi stupac ima
				// indeks 1, drugi 2, treći 3,... -> vidi NAZIV knjige). Za svaki tip podatka
				// postoji posebna getter metoda.
				l.add(new Korisnik(rs.getInt("ID"), rs.getString(2), rs.getString("AUTOR")));
			}
			return l;
		}catch(SQLException se) {
			prikaziSqlIznimke(se);
			return null;
		}
	}
    
    // SQLite ne podržava višestruko kretanje kroz ResultSet i njihovo ažuriranje, pa ovaj primjer
    //   testiramo na MySQL bazi
    private List<Korisnik> naprednoCitanje() {
		// Pripremi upit
		String upit = "SELECT ID, NAZIV, AUTOR FROM KNJIGE";
		List<Korisnik> l = new ArrayList<>();
		// SQLite podržava samo TYPE_FORWARD_ONLY
		try (Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
			// Izvedi upit - napuni skup rezultata u objekt tipa ResultSet. Svaki redak tablice
			// je jedan element skupa rezultata.
			ResultSet rs = stmt.executeQuery( upit )){
			// dodaj na kraj novi redak
			rs.moveToInsertRow(); 
			rs.updateInt(1, 89); // ažurira ID novog retka
			rs.updateString(2, "Novo dodani zapis"); // ažurira naziv nove knjige
			rs.updateString(3, "Autor novo dodanog zapisa"); // ažurira autore nove knjige
			rs.insertRow(); // sprema novi redak u bazu
			rs.moveToInsertRow(); 
			rs.updateInt(1, 99); // ažurira ID novog retka
			rs.updateString(2, "Drugi novo dodani zapis"); // ažurira naziv druge nove knjige
			rs.updateString(3, "Autor drugog novo dodanog zapisa"); // ažurira autore druge nove knjige
			rs.insertRow(); // sprema novi redak u bazu
			
			rs.moveToCurrentRow(); // pomiče se na zapamćeni redak prije inserta
			// Prođi kroz sve retke tablice koje je vratio sql - jedan po jedan
			while(rs.next()){
				// getter metoda koja dohvaća podatke može kao konstruktor primati ili NAZIV stupca
				// u tablici iz koje se čita (vidi id i autora!) ili REDNI BROJ (prvi stupac ima
				// indeks 1, drugi 2, treći 3,... -> vidi NAZIV knjige). Za svaki tip podatka
				// postoji posebna getter metoda.
				l.add(new Korisnik(rs.getInt("ID"), rs.getString(2), rs.getString("AUTOR")));
			}
			
			return l;
		}catch(SQLException se) {
			prikaziSqlIznimke(se);
			return null;
		}
	}
    
    private List<Korisnik> naprednoCitanje2() {
		// Pripremi upit
		String upit = "SELECT ID, NAZIV, AUTOR FROM KNJIGE";
		List<Korisnik> l = new ArrayList<>();
		// SQLite podržava samo TYPE_FORWARD_ONLY
		try (Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
			// Izvedi upit - napuni skup rezultata u objekt tipa ResultSet. Svaki redak tablice
			// je jedan element skupa rezultata.
			ResultSet rs = stmt.executeQuery( upit )){
			
			rs.absolute(2); // pozicioniraj se na 2. redak
			rs.updateString("AUTOR", "PROMIJEnjeni autor");
			rs.updateRow(); // izmijenjeni podaci se spremaju u bazu

			
			rs.beforeFirst(); // pomiče se na početak da bi next() dohvatio prvi redak
			// Prođi kroz sve retke tablice koje je vratio sql - jedan po jedan
			while(rs.next()){
				// getter metoda koja dohvaća podatke može kao konstruktor primati ili NAZIV stupca
				// u tablici iz koje se čita (vidi id i autora!) ili REDNI BROJ (prvi stupac ima
				// indeks 1, drugi 2, treći 3,... -> vidi NAZIV knjige). Za svaki tip podatka
				// postoji posebna getter metoda.
				l.add(new Korisnik(rs.getInt("ID"), rs.getString(2), rs.getString("AUTOR")));
			}
			
			return l;
		}catch(SQLException se) {
			prikaziSqlIznimke(se);
			return null;
		}
	}


	private void unos(Korisnik k){
		// Ako zapis sa zadanim ID-jem već postoji ne smije se dodavati
		if (trazi(k.getId())){
			System.out.println("Podatak s IDjem "+k.getId()+ " već postoji u bazi!");
			return;
		}
		String upit = "insert into KNJIGE (ID, NAZIV, AUTOR) values (?, ?, ?)";
		// Priprema upit za izvođenje. Kod izvođenja se samo na odgovarajuća mjesta
		// zapisuju konkretne vrijednosti (konkretan id, naziv, autor).
		try (PreparedStatement pstmt = conn.prepareStatement(upit)){
			// Postavljaju se konkretne vrijednosti naziva, autora i id-ja.
			pstmt.setInt(1, k.getId());
			pstmt.setString(2, k.getNaziv());
			pstmt.setString(3, k.getAutor());
			// Upit koji mijenja tablicu se izvodi pomoću metode executeUpdate
			pstmt.executeUpdate();
			System.out.println("Dodavanje zapisa s rednim brojem "+k.getId()+" je uspješno!");
		}catch(SQLException se) {
			prikaziSqlIznimke(se);
		} 
	}

	private void izmjena(Korisnik k) {
		// Ako zapis sa zadanim ID-jem ne postoji ne smije se ažurirati
		if (!trazi(k.getId())){
			System.out.println("Podatak s IDjem "+k.getId()+ " ne postoji u bazi!");
			return;
		}
		String upit = "update KNJIGE set NAZIV=?,AUTOR=? where ID=?";
		// Priprema upit za izvođenje. Kod izvođnja se samo na odgovarajuća mjesta
		// zapisuju konkretne vrijednosti (konkretan id, naziv, autor).
		try (PreparedStatement pstmt = conn.prepareStatement(upit)){
			// Postavljaju se konkretne vrijednosti naziva, autora i id-ja.
			pstmt.setString(1, k.getNaziv());
			pstmt.setString(2, k.getAutor());
			pstmt.setInt(3, k.getId());
			// Upit se izvodi
			pstmt.executeUpdate();
			System.out.println("Izmjena zapisa s rednim brojem "+k.getId()+" je uspješna!");
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
			
			String upit = "create table KNJIGE (ID INTEGER PRIMARY KEY, NAZIV TEXT, AUTOR TEXT)";
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
	private void obrada() {
		// Spaja se na bazu
        // URL za spajanje na "embedded" bazu knjiznica.db koja je stvorena u mapi baza/
        // U projekt mora biti uključen JAR koji sadrži konkretnu implementaciju programa
        // za rad s konkretnom bazom (u ovoj verziji korišten je sqlite-jdbc-3.21.0.jar ).
		
	    // SQLite ne podržava višestruko kretanje kroz ResultSet i njihovo ažuriranje, pa ovaj primjer
	    //   radi na MySQL bazi
		String spojniURL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7774666";
		String[] userPass = usernamePassword();
		if (userPass == null) {
			return;
		}
        try(Connection co = DriverManager.getConnection(spojniURL, userPass[0], userPass[1])) {
			conn = co;
			provjeriTablicu();
			// čita sve iz tablice knjige i prikazuje na zaslonu
			List<Korisnik> l = citanjeSvih();
			if(l!=null) {
				System.out.println("DOHVAĆENE KNJIGE:");
				for(Korisnik k : l)
					System.out.println(k);
				System.out.println("---------------------------------");
			}
			// Dodaje novi zapis s id-jem 200
			unos(new Korisnik(101, "Head First Java", "Kathy Sierra"));
			unos(new Korisnik(102, "JAVA in 8 Hours", "Ray Yao"));
			unos(new Korisnik(103, "Java: A Beginner's Guide", "Herbert Schildt"));
			unos(new Korisnik(104, "Effective Java", "Joshua Block"));
			// čita sve iz tablice knjige i prikazuje na zaslonu. 
			// sada se prikazuje i novo dodani zapis s id-jem 200
			l = citanjeSvih();
			if(l!=null) {
				System.out.println("DOHVAĆENE KNJIGE NAKON INSERTA:");
				for(Korisnik k : l)
					System.out.println(k);
				System.out.println("---------------------------------");
			}
			// Mijenja se naziv knjige s id-jem 102
			izmjena(new Korisnik(102, "JAVA in 8 Hours 2nd updated ed", "Ray Yao"));
			// čita sve iz tablice knjige i prikazuje na zaslonu.
			l = citanjeSvih();
			if(l!=null) {
				System.out.println("DOHVAĆENE KNJIGE NAKON IZMJENA:");
				for(Korisnik k : l)
					System.out.println(k);
				System.out.println("---------------------------------");
			}
			// Briše se redak s id-jem 102
			brisanje(102);
			// čita sve iz tablice knjige i prikazuje na zaslonu.
			// Stanje bi trebalo biti jednako početnom.
			l = citanjeSvih();
			if(l!=null) {
				System.out.println("DOHVAĆENE KNJIGE:");
				for(Korisnik k : l)
					System.out.println(k);
				System.out.println("---------------------------------");
			}
			// prije čitanja se kroz kursor dodaju 2 nova zapisa
			l = naprednoCitanje();
			if(l!=null) {
				System.out.println("NOVO DOHVAĆENE KNJIGE:");
				for(Korisnik k : l)
					System.out.println(k);
				System.out.println("---------------------------------");
			}
			// Brišu se novo dodani redci
			brisanje(89);
			brisanje(99);
			l = naprednoCitanje2();
			if(l!=null) {
				System.out.println("DOHVAĆENE KNJIGE:");
				for(Korisnik k : l)
					System.out.println(k);
				System.out.println("---------------------------------");
			}
			// Veza na bazu se zatvara automatski jer je konekcija stvorena unutar try bloka.
		} catch(SQLException se ) {
			// Može biti više SQL iznimaka - proći kroz sve!
			prikaziSqlIznimke(se);
		}
		catch(Exception e) {
			System.out.println(e.getMessage()) ;
			e.getStackTrace();
		}
	}
	
	private String[] usernamePassword(){
		Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream("baza/config.properties")) {
            prop.load(input);
            String[] uP = new String[2];
            uP[0] = prop.getProperty("username");
            uP[1] = prop.getProperty("password");
            return uP;
        } catch (IOException e) {
            System.out.println("Greška prilikom čitanja konfiguracijske datoteke: " + e.getMessage());
        }
        return null;
	}
	public static void main(String[] args){
		TestBazaNapredno t = new TestBazaNapredno();
		t.obrada();
	}
}