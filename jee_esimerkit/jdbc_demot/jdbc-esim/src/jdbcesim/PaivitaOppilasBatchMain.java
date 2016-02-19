package jdbcesim;

import java.sql.*;

import jdbcconf.TietokantayhteysTehdas;

import java.util.*;

/* 
 * Update esimerkki
 * 
 * @author Juha Peltomäki.
 *
 * Esimerkissä esitellään transaktion käytän lisäksi myäs
 * eräajopäivitysten (batch update) käyttöä (addBatch(), executeBatch() metodit PreparedStatement luokasta)
 */

public class PaivitaOppilasBatchMain {

	public static void main(String args[]) throws java.sql.SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try { // 1. Create Connection to database

			conn = TietokantayhteysTehdas.getConnection();

			conn.setAutoCommit(false); // Aloitetaan transaktio
			// Tehdään esivalmisteltu kysely
			pstmt = conn.prepareStatement(
					"INSERT INTO oppilas (nimi,demopisteet,koepisteet, syntymaaika) VALUES (?,?,?,?)");
			
			// asetetaan arvot kyselylle
			pstmt.setString(1, "Musta-Pekka");
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 3);
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, 5);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.YEAR, 1925);
			java.sql.Date nowDate = new java.sql.Date(cal.getTime().getTime());
			pstmt.setDate(4, nowDate);
			pstmt.addBatch(); 
			// laitetaan työjonoon myöhempää suorittamista varten eräajona.

			// Päivämäärän muuttaminen merkkijonosta java.sql.Date tyyppiseksi
			//String sdate = "1939-05-20";
			String sdate = "1939-05-33";
			java.text.SimpleDateFormat inFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
			java.util.Date sqldate = new java.sql.Date(inFormat.parse(sdate).getTime());
			System.out.println("Lisättävä päivä: " + sqldate);

			pstmt.setString(1, "Musta-Kaapu");
			pstmt.setInt(2, 7);
			pstmt.setInt(3, 7);
			pstmt.setDate(4, (java.sql.Date)sqldate);
			pstmt.addBatch(); // laitetaan jonoon myähempää suorittamista varten

			// Lähetetään päivityslauseet tietokantaan
			// Huom! PreparedStatement.executeBatch() kutsuminen tyhjää jonossa
			// olleen listassa olleet lauseet
			int[] tulos = pstmt.executeBatch();
			int tulokset = 0;
			for (int t : tulos) {
				tulokset += t;
			}
			
			System.out.println("Päivityksiä tehtiin " + tulokset + " kappaletta. Jonossa oli " + tulos.length + " työtä");
			conn.commit(); // vasta tässä vaiheessa kanta päivittyy
		} catch (Exception e) {
			// virheiden tapauksessa perutaan koko transaktio eli mitään ei päivitetä tietokantaan
			e.printStackTrace();
			conn.rollback();
		}

	}

}
