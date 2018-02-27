package hr.unidu.oop.p08;
/**
 * @author Krunoslav �ubrini�
 * 26. svi 2015.
 */
// Su�elja koja sadr�e opise apstraktnih metoda koje se koriste pri radu
// s konkretnom bazom opisana su u paketu java.sql.
import java.sql.* ;
public class TestDerby	{
	private Connection conn;
	// URL za spajanje na "embedded" bazu knjige koja je stvorena u mapi D:/projekt-baza
	// U projekt mora biti uklju�en JAR koji sadr�i konkretnu implementaciju programa
	// za rad s konkretnom bazom (primjerice derby. jar i derbyclient.jar za rad s
	// Derby relacijskom bazom).
	private static String spojniURL = "jdbc:derby:knjige";
	// �elite li u programu stvoriti novu bazu, na kraj spojnog URL-a dodajte ;create=true
	// tada �e URL izgledati: "jdbc:derby:D:/projekt-baza/knjige;create=true"

	public TestDerby() throws SQLException, ClassNotFoundException{
		// U�itaj konkretan driver (za rad s Derby embedded bazom)
		Class.forName( "org.apache.derby.jdbc.ClientDriver" ) ;
		// spajanje na bazu knjige
		conn = DriverManager.getConnection(spojniURL) ;
	}
	private void zavrsi() throws SQLException{
		conn.close();
	}

	private void citanjeSvih() throws SQLException{
		// Pripremi upit
		Statement stmt = conn.createStatement() ;

		// Izvedi upit - napuni skup rezultata u objekt tipa ResultSet. Svaki redak tablice
		// je jedan element skupa rezultata.
		ResultSet rs = stmt.executeQuery( "SELECT ID, NAZIV, AUTOR FROM KNJIGE" ) ;
		System.out.println("----------------------------------------------------------------") ;
		// Pro�i kroz sve retke tablice koje je vratio sql - jedan po jedan
		while(rs.next()){
			// getter metoda koja dohva�a podatke mo�e kao konstruktor primati ili NAZIV stupca
			// u tablici iz koje se �ita (vidi id i autora!) ili REDNI BROJ (prvi stupac ima
			// indeks 1, drugi 2, tre�i 3,... -> vidi NAZIV knjige). Za svaki tip podatka
			// postoji posebna getter metoda.
			System.out.println( rs.getInt("ID") + ", " + rs.getString(2)+ ", " + rs.getString("AUTOR") ) ;
		}
		System.out.println("----------------------------------------------------------------") ;
		// O�isti skup rezultata i upit
		rs.close() ;
		stmt.close() ;
	}

	private void unos(int id, String naziv, String autor) throws SQLException{
		// Ako zapis sa zadanim ID-jem ve� postoji ne smije se dodavati
		if (trazi(id)){
			System.out.println("Podatak s IDjem "+id+ " ve� postoji u bazi!");
			return;
		}
		String upit = "insert into KNJIGE (ID, NAZIV, AUTOR) values (?, ?, ?)";
		// Priprema upit za izvo�enje. Kod izvo�enja se samo na odgovaraju�a mjesta
		// zapisuju konkretne vrijednosti (konkretan id, naziv, autor).
		PreparedStatement pstmt = conn.prepareStatement(upit);
		// Postavljaju se konkretne vrijednosti naziva, autora i id-ja.
		pstmt.setInt(1, id);
		pstmt.setString(2, naziv);
		pstmt.setString(3, autor);
		// Upit koji mijenja tablicu se izvodi pomo�u metode executeUpdate
		int i = pstmt.executeUpdate();
		System.out.println("Dodavanje zapisa s rednim brojem "+id+" je uspje�no!");
		pstmt.close();
	}

	private void izmjena(int id, String naziv, String autor) throws SQLException{
		// Ako zapis sa zadanim ID-jem ne postoji ne smije se a�urirati
		if (!trazi(id)){
			System.out.println("Podatak s IDjem "+id+ " ne postoji u bazi!");
			return;
		}
		String upit = "update KNJIGE set NAZIV=?,AUTOR=? where ID=?";
		// Priprema upit za izvo�enje. Kod izvo�enja se samo na odgovaraju�a mjesta
				// zapisuju konkretne vrijednosti (konkretan id, naziv, autor).
		PreparedStatement pstmt = conn.prepareStatement(upit);
		// Postavljaju se konkretne vrijednosti naziva, autora i id-ja.
		pstmt.setString(1, naziv);
		pstmt.setString(2, autor);
		pstmt.setInt(3, id);
		// Upit se izvodi
		int i = pstmt.executeUpdate();
		pstmt.close();
		System.out.println("Izmjena zapisa s rednim brojem "+id+" je uspje�na!");		 
	}

	private void brisanje(int id) throws SQLException{
		// Ako zapis sa zadanim ID-jem ne postoji ne smije se brisati
		if (!trazi(id)){
			System.out.println("Podatak s IDjem "+id+ " ne postoji u bazi!");
			return;
		}
		String upit = "delete from KNJIGE where ID=?";
		// Priprema upit za izvo�enje. Kod izvo�enja se samo na odgovaraju�a mjesta
		// zapisuje konkretna vrijednost id-ja.
		PreparedStatement pstmt = conn.prepareStatement(upit);
		// Postavljaju se konkretna vrijednost id-ja
		pstmt.setInt(1, id);
		// Upit koji mijenja tablicu se izvodi pomo�u metode executeUpdate
		int i = pstmt.executeUpdate();	
		pstmt.close();
		System.out.println("Brisanje zapisa s rednim brojem "+id+" je uspje�no!");		 
	}

	private boolean trazi(int id) throws SQLException{
		// ? �e se kod izvo�enja zamijeniti konkretnom vrijedno��u.
		// Na ovakav na�in se �titimo od napada umetanjem sql-a
		String upit = "select ID from KNJIGE where ID = ?";
		// Priprema upit za izvo�enje. Kod izvo�enja se samo na odgovaraju�a mjesta
		// zapisuje konkretna vrijednost id-ja.
		PreparedStatement pstmt = conn.prepareStatement(upit);
		// Postavlja se konkretna vrijednost id-ja
		pstmt.setInt(1, id);
		// Upit koji �ita iz tablica (vra�a retke) se izvodi pomo�u executeQuery
		ResultSet res = pstmt.executeQuery();
		// Ako je upit vratio barem jedan slog, ve� postoji takav zapis
		if (res.next()) {
			pstmt.close();
			return true;
		}
		pstmt.close();
		return false;
	}

	public static void main(String[] args){
		TestDerby t = null;
		try {
			// Spaja se na bazu
			t = new TestDerby();
			// �ita sve iz tablice knjige i prikazuje na zaslonu
			t.citanjeSvih();
			// Dodaje novi zapis s id-jem 200
			t.unos(200,"Nova knjiga", "Novi autor");
			// �ita sve iz tablice knjige i prikazuje na zaslonu. 
			// sada se prikazuje i novo dodani zapis s id-jem 200
			t.citanjeSvih();
			// Mijenja se naziv knjige s id-jem 200
			t.izmjena(200,"Najnovija izmjenjena knjiga", "Novi autor");
			// �ita sve iz tablice knjige i prikazuje na zaslonu.
			t.citanjeSvih();
			// Bri�e se redak s id-jem 200
			t.brisanje(200);
			// �ita sve iz tablice knjige i prikazuje na zaslonu.
			// Stanje bi trebalo biti jednako po�etnom.
			t.citanjeSvih();
			// Zatvara se veza na bazu.
			t.zavrsi();
		} catch(SQLException se ) {
			System.out.println( "Gre�ka SQL-a:" ) ;
			// Mo�e biti vi�e SQL iznimaka - pro�i kroz sve!
			while(se != null) {
				System.out.println( "Stanje  : " + se.getSQLState()  ) ;
				System.out.println( "Poruka: " + se.getMessage()   ) ;
				System.out.println( "Gre�ka  : " + se.getErrorCode() ) ;
				se = se.getNextException() ;
			}
		}
		catch(Exception e) {
			System.out.println(e) ;
			e.getStackTrace();
		}
	}
}