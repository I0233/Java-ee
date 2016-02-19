package jdbcesim;

import java.sql.*;

import jdbcconf.TietokantayhteysTehdas;

public class TulostaOppilaatMain {

	public static void main(String args[]) {

		Connection conn = null;

		try {
			conn = TietokantayhteysTehdas.getConnection();

			// Kysely tietokantaan
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("select *, demopisteet+koepisteet from oppilas");

			System.out.println("*************************** kaikki ****************************************");
			while (rs.next()) {
				// haetaan tulostetana arvot jokaiselta tietokannan riviltä
				int id = rs.getInt("id");
				String nimi = rs.getString("nimi");
				int demo = rs.getInt("demopisteet");
				int koe = rs.getInt("koepisteet");
				System.out.println(id + "\t" + nimi + "\t" + demo + "\t" + koe);
			}

			System.out.println("*************************** rivilta 5 eteenpain ****************************************");
			rs.absolute(5); // Kursorin absoluuttinen paikka
			while (rs.previous()) {
				int id = rs.getInt("id");
				String nimi = rs.getString("nimi");
				int demo = rs.getInt("demopisteet");
				int koe = rs.getInt("koepisteet");
				System.out.println(id + "\t" + nimi + "\t" + demo + "\t" + koe + "\t");
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println(sqle.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
