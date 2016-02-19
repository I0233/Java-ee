package jdbcesim;

import java.sql.*;
import java.util.Calendar;

import jdbcconf.TietokantayhteysTehdas;

/* Update esimerkki 2
 *  Esitellään JDBC:n päivitettävä tulosjoukko 
 *  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE -luontivaiheessa
 *  Tällöin kyselyn perusteella saatua tulosta voidaan päivittää 
 * Päivitettävä tulosjoukko. Updatable resultset
 */

public class PaivitaOppilasRsMain {
	public static void haeViimeinen(Connection conn) {
		// tehdään kysely
		String sqlHaku = "SELECT * FROM oppilas order by id desc limit 1";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlHaku);
			if (rs.next()) {
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

	// Lisää parametrinä annettuun Date olioon yhden vuoden ja palauttaa
	// muutetun päivämäärä uutena Date-oliona
	private static java.sql.Date lisaaYhdellaVuodella(Date muutettava) {
		Calendar tmpAika = Calendar.getInstance();
		tmpAika.setTimeInMillis(muutettava.getTime());
		tmpAika.add(Calendar.YEAR, 1);
		return new Date(tmpAika.getTimeInMillis());
	}

	public static void main(String args[]) {
		String sql = "SELECT id, nimi, demopisteet, koepisteet, syntymaaika FROM oppilas";

		Connection conn = null;
		try {

			conn = TietokantayhteysTehdas.getConnection();

			// Päivitetään tietokannan riviä
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			// mennään tulosjoukon viimeiseen alkioon
			rs.last();
			// muutetaan nimi, lisätään pisteitä yhdellä sekä lisätään
			// syntymäaikaa yhdellä vuodella
			rs.updateString(2, "Nimi Päivitetty!");
			rs.updateInt(3, rs.getInt(3) + 1);
			rs.updateInt(4, rs.getInt(4) + 1);
			Date uusiSyntymaaika = lisaaYhdellaVuodella(rs.getDate(5));
			rs.updateDate(5, uusiSyntymaaika);
			rs.updateRow();

			// haetaan viimeksi muokattu rivi ja tulostetaan sen nykyiset tiedot
			haeViimeinen(conn);

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
