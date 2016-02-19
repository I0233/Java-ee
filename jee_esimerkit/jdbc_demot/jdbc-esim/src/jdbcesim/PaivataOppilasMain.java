package jdbcesim;

import java.sql.*;
import jdbcconf.TietokantayhteysTehdas;


public class PaivataOppilasMain {
	
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

	public static void main(String args[]) {
		Connection conn = null;
		try {

			conn = TietokantayhteysTehdas.getConnection();

			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO oppilas (nimi,demopisteet,koepisteet, syntymaaika)" + " VALUES ('Teppo Testaaja',10,8, '1979-11-05')";
			int tulos = stmt.executeUpdate(sql);
			System.out.println("Päivityksiä " + tulos + " kappaletta");
			
			haeViimeinen(conn);

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
