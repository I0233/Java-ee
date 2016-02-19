package avustavat_luokat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

		public class OhjelmointikieliDAO {
			final static private String KYSELY = "SELECT * FROM ohjkieli";
			private static Connection yhteys;
			private static java.sql.Statement lause;
			private static String jatkokysely;
			// KYSELY perään liitettävä jatkokysely
			
			public enum Database{
				MySQL
			}
			
			private static final Enum<?> TIETOKANTA = Database.MySQL; 
			private static OhjelmointikieliDAO instance = new OhjelmointikieliDAO();
			public static final String MYSQL_URL = "jdbc:mysql://localhost/jdbcesim";
			public static final String MYSQL_KAYTTAJA = "root";
			public static final String MYSQL_SALASANA = "root66";

			private Connection luoYhteys() {
				 yhteys = null;
				try {
					System.out.println("Tietokanta: " + TIETOKANTA);
					if (TIETOKANTA == Database.MySQL)
						yhteys = DriverManager.getConnection(MYSQL_URL, MYSQL_KAYTTAJA, MYSQL_SALASANA);
				} catch (SQLException e) {
					System.out.println("VIRHE: Kytkeytyminen kantaan ei onnistunut.");
				}
				return yhteys;
			}
			// Avaa sen tietokantaan yhteyden
			public static Connection getConnection() {
				return instance.luoYhteys();
			}
			
			// Sulkee tietokannan yhteys
			public static void close() {
				if (yhteys != null) {
					try {
						yhteys.close();
						System.out.print("Yhteys on suljettu onnistuneesti");
					} catch (SQLException e) {
						System.out.println("VIRHE: Kannan sulkeminen ei onnistunut.");
					}
				}
				
			}
			
			public static void SQL_Query(String sql[]){
				try {
					 yhteys = getConnection();
					lause = yhteys.createStatement();
					
					int tulos = 0;
					for (String _sql : sql) {
						tulos += lause.executeUpdate(_sql);
					}
					System.out.println("Päivityksiä yhteensä " + tulos + " kappaletta");
					lause.close();
					yhteys.close();
					
				} catch (SQLException e) {
					System.out.println(e);
					e.printStackTrace();
				}
			}
			
			// palauttaa listan tietokannasta kyselyn perusteella saaduista ohjelmointikielistä
			public List<Ohjelmointikieli> getOhjelmointikielet() throws SQLException {
				yhteys = getConnection();
				lause = yhteys.createStatement();
				ResultSet rs = lause.executeQuery(KYSELY);
				List<Ohjelmointikieli> kielet =  new ArrayList<>();
				Ohjelmointikieli ohjkieli = new Ohjelmointikieli();
				while(rs.next()){
					ohjkieli.set_id(rs.getInt("id"));
					ohjkieli.set_nimi(rs.getString("nimi"));
					ohjkieli.set_versio(rs.getString("viimversio"));
					ohjkieli.set_suunnitelija(rs.getString("suunnittelija"));
					ohjkieli.set_julkaistu(rs.getDate("julkaistu"));
					kielet.add(ohjkieli);
					System.out.println(kielet);
				}
				return null;
			}
			
			// palauttaa yhden ohjelmointikielen
			public Ohjelmointikieli getOhjelmointikieli(int kieliId) throws SQLException {
				yhteys = getConnection();
				lause = yhteys.createStatement();
				ResultSet rs = lause.executeQuery("SELECT * FROM jdbcesim.ohjkieli where id = '"+kieliId+"'" );
				Ohjelmointikieli ohjkieli = new Ohjelmointikieli();
				while(rs.next()){
					ohjkieli.set_id(rs.getInt("id"));
					ohjkieli.set_nimi(rs.getString("nimi"));
					ohjkieli.set_versio(rs.getString("viimversio"));
					ohjkieli.set_suunnitelija(rs.getString("suunnittelija"));
					ohjkieli.set_julkaistu(rs.getDate("julkaistu"));
				}
					System.out.println(ohjkieli);
					return ohjkieli;
					

				
			}
			public void setJatkokysely(String string) {
				// TODO Auto-generated method stub
				
			}
			
	}
