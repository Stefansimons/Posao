package rs;

//vazni importi 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ArrayList;
public class DAOradnik {
   private DataSource ds;

//DEFINICIJA KONEKCIONIH STRINGOVA
	private static String SELECTALLRADNIK = "SELECT * FROM radnik";
	private static String INSERTRADNIK="INSERT INTO radnik(ime,prezime,zeljena_plata,godina_iskustva) VALUES (?,?,?,?)";
	private static String GETRADNIKBYID=" SELECT * FROM radnik WHERE idradnik=?";
	private static String SORTBYPLATA="SELECT * FROM radnik ORDER BY zeljena_plata ";
	private static String DELETEBYID="DELETE FROM radnik WHERE idradnik=?";
	private static String RADNICIKOJINISUSETOVALIPLATU="SELECT * FROM radnik WHERE zeljena_plata IS NULL";
	private static String SORTPOPRIJAVI="SELECT * FROM radnik WHERE zeljena_plata=? ORDER BY datum_prijave";
	private static String DELETEBYGODINEISKUSTVA="DELETE FROM radnik WHERE godina_iskustva <=3";
	private static String UPDATERADNIKBYID="UPDATE radnik SET ime=?,prezime=?,godina_iskustva=?,zeljena_plata=? WHERE idradnik=?";
	private static String GETRADNIKBYPLATANULL="SELECT * FROM radnik WHERE zeljena_plata IS NULL";
	// DEFINICIJA KONSTRUKTORA ZA PODESAVNJE KONEKCIJE – UVEK ISTO
	public DAOradnik(){
	try {
		InitialContext cxt = new InitialContext();
		if ( cxt == null ) { 
		} 
		ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/mysql" ); 
		if ( ds == null ) { 
		} 		
		} catch (NamingException e) {
		}
	}
	// DEFINICIJA METODE 
	
	public ArrayList<PrijavaZaPosao> ispisPodatakaZaSveRadnike(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<PrijavaZaPosao> lp = new ArrayList<PrijavaZaPosao>();
		PrijavaZaPosao pom = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTALLRADNIK);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new PrijavaZaPosao();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setRadnikID(rs.getInt("idradnik"));
				pom.setIme(rs.getString("ime"));
				pom.setPrezime(rs.getString("prezime"));
				pom.setZeljena_plata(rs.getInt("zeljena_plata"));
				pom.setGodine_iskustva(rs.getInt("godina_iskustva"));
				pom.setDatum_prijave(rs.getTimestamp("datum_prijave"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lp.add(pom);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lp; 
	}
	public ArrayList<PrijavaZaPosao> orderPoDatumuPrijave(int plata){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<PrijavaZaPosao> lp = new ArrayList<PrijavaZaPosao>();
		PrijavaZaPosao pom = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SORTPOPRIJAVI);

			pstm.setInt(1, plata);
			pstm.execute();


			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new PrijavaZaPosao();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setRadnikID(rs.getInt("idradnik"));
				pom.setIme(rs.getString("ime"));
				pom.setPrezime(rs.getString("prezime"));
				pom.setZeljena_plata(rs.getInt("zeljena_plata"));
				pom.setGodine_iskustva(rs.getInt("godina_iskustva"));
				pom.setDatum_prijave(rs.getTimestamp("datum_prijave"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lp.add(pom);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lp; 
	}
	public ArrayList<PrijavaZaPosao> getRadnikByPlataisNull(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<PrijavaZaPosao> lp = new ArrayList<PrijavaZaPosao>();
		PrijavaZaPosao pom = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETRADNIKBYPLATANULL);

			//pstm.setInt(1, plata);
			pstm.execute();


			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new PrijavaZaPosao();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setRadnikID(rs.getInt("idradnik"));
				pom.setIme(rs.getString("ime"));
				pom.setPrezime(rs.getString("prezime"));
				pom.setZeljena_plata(rs.getInt("zeljena_plata"));
				pom.setGodine_iskustva(rs.getInt("godina_iskustva"));
				pom.setDatum_prijave(rs.getTimestamp("datum_prijave"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lp.add(pom);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lp; 
	}
	public ArrayList<PrijavaZaPosao> sortByPlata(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<PrijavaZaPosao> lp = new ArrayList<PrijavaZaPosao>();
		PrijavaZaPosao pom = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SORTBYPLATA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new PrijavaZaPosao();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setRadnikID(rs.getInt("idradnik"));
				pom.setIme(rs.getString("ime"));
				pom.setPrezime(rs.getString("prezime"));
				pom.setZeljena_plata(rs.getInt("zeljena_plata"));
				pom.setGodine_iskustva(rs.getInt("godina_iskustva"));
				pom.setDatum_prijave(rs.getTimestamp("datum_prijave"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lp.add(pom);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lp; 
	}
	public PrijavaZaPosao getRadnikByID(int radnikid){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		PrijavaZaPosao pom = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETRADNIKBYID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, radnikid);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new PrijavaZaPosao();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setRadnikID(rs.getInt("idradnik"));
				pom.setIme(rs.getString("ime"));
				pom.setPrezime(rs.getString("prezime"));
				pom.setZeljena_plata(rs.getInt("zeljena_plata"));
				pom.setGodine_iskustva(rs.getInt("godina_iskustva"));
				pom.setDatum_prijave(rs.getTimestamp("datum_prijave"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return pom; 
	}
	public void insertRadnika(PrijavaZaPosao r){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		//ArrayList<Osoba> lo = new ArrayList<Osoba>();
		PrijavaZaPosao pom = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(INSERTRADNIK);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, r.getIme());
			pstm.setString(2, r.getPrezime());
			pstm.setInt(3, r.getZeljena_plata());
			pstm.setInt(4, r.getGodine_iskustva());
			
			pstm.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void deleteRadnikbyID(int ID){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(DELETEBYID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, ID);
			
			pstm.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void deleteRadnikbygodineIskustva(int god){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(DELETEBYGODINEISKUSTVA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, god);
			
			pstm.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void updateRadnikbyID(PrijavaZaPosao r,int id){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(UPDATERADNIKBYID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, r.getIme());
			pstm.setString(2, r.getPrezime());
			pstm.setInt(3, r.getGodine_iskustva());
			pstm.setInt(4, r.getZeljena_plata());
			pstm.setInt(5, id);
			
			pstm.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<PrijavaZaPosao> RadniciBezPLATE(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<PrijavaZaPosao> lp = new ArrayList<PrijavaZaPosao>();
		PrijavaZaPosao pom = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(RADNICIKOJINISUSETOVALIPLATU);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pom = new PrijavaZaPosao();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pom.setRadnikID(rs.getInt("idradnik"));
				pom.setIme(rs.getString("ime"));
				pom.setPrezime(rs.getString("prezime"));
				pom.setZeljena_plata(rs.getInt("zeljena_plata"));
				pom.setGodine_iskustva(rs.getInt("godina_iskustva"));
				pom.setDatum_prijave(rs.getTimestamp("datum_prijave"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lp.add(pom);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lp; 
	}
	// DEFINICIJA OSTALIH METODA ... 
}