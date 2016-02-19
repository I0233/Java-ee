package jdbcesim;

import java.sql.*;
import java.util.Arrays;

import jdbcconf.TietokantayhteysTehdas;

/* Update esimerkki 3.
 * 
 * @author Juha Peltomäki.
 * 
 * Esimerkissä esitellään transaktion käyttöä, muuten tämä ei poikkea mitenkään miusta päivitystavoista 
 * Huomaa, että tietokannan on tuettava transaktiota. 
 
 */

public class PaivitaOppilasTransaktioMain {

	public static void haeViimeiset(Connection conn) {
		// tehdään kysely
		String sqlHaku = "SELECT * FROM oppilas order by id desc limit 3";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlHaku);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nimi = rs.getString("nimi");
				int demo = rs.getInt("demopisteet");
				int koe = rs.getInt("koepisteet");
				Date syntaika = rs.getDate("syntymaaika");
				System.out.println(id + "\t" + nimi + "\t" + demo + "\t" + koe + "\t" + syntaika);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		Connection conn = null;
		try { // 1. Create Connection to database

			conn = TietokantayhteysTehdas.getConnection();

			conn.setAutoCommit(false); // Aloitetaan transaktio
			java.sql.Statement stmt = conn.createStatement();
			int tulos = 0;
			tulos += stmt.executeUpdate(
					"INSERT INTO oppilas (nimi,demopisteet,koepisteet, syntymaaika) VALUES ('Musta-Kaapu',12,0,'1939-05-30')");
			tulos += stmt.executeUpdate(
					"INSERT INTO oppilas (nimi,demopisteet,koepisteet, syntymaaika) VALUES ('Musta-Kaapo',5, 6,'1939-05-30')");
			tulos += stmt.executeUpdate(
					"INSERT INTO oppilas (nimi,demopisteet,koepisteet, syntymaaika) VALUES ('Musta-Pekka',5,6,'1926-06-01')");
			conn.commit(); // Päätetään transaktio
			System.out.println("Päivityksiä yhteensä " + tulos + " kappaletta");
			
			// haetaan kolme viimeistä päivitustä
			haeViimeiset(conn);

			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Perutaan kaikki päivitykset! " + e + "\ntarkemmin: " + Arrays.toString(e.getStackTrace()));
			try {
				// Aikaisempia päivityksia ei ajeta lainkaan kantaan.
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

}
