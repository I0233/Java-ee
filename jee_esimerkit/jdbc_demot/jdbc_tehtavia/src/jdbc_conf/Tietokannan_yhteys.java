package jdbc_conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* @author Ali Nadhum
 * 27 Jan, 2016 
 */

public class Tietokannan_yhteys {
	public enum Database{
		MySQL
	}

	// Valitse mitä tietokantaa käytetään.
	private static final Enum<?> TIETOKANTA = Database.MySQL; // käytetään MySQL:ää

	// Tietoyhteyksien alustamiseen käytettävät staattiset muuttujat
	private static Tietokannan_yhteys instance = new Tietokannan_yhteys();

	// pitää olla jdbcesim tietokanta olemassa
	public static final String MYSQL_URL = "jdbc:mysql://localhost/jdbcesim";
	public static final String MYSQL_KAYTTAJA = "root";
	public static final String MYSQL_SALASANA = "root66";

	// Mysql tietokannan asetukset

	private Connection luoYhteys() {
		Connection yhteys = null;
		try {
			System.out.println("Tietokanta: " + TIETOKANTA);
			if (TIETOKANTA == Database.MySQL)
				yhteys = DriverManager.getConnection(MYSQL_URL, MYSQL_KAYTTAJA, MYSQL_SALASANA);
		} catch (SQLException e) {
			System.out.println("VIRHE: Kytkeytyminen kantaan ei onnistunut.");
		}
		return yhteys;
	}

	public static Connection getConnection() {
		// kutsuu privaattia konstruktoria luoden olion ja palauttaa luoYhteys()
		// metodilla luodun yhteyden
		return instance.luoYhteys();
	}
	
	public static void close(Connection yhteys) {
		if (yhteys != null) {
			try {
				yhteys.close();
			} catch (SQLException e) {
				System.out.println("VIRHE: Kannan sulkeminen ei onnistunut.");
			}
		}
	}
}
