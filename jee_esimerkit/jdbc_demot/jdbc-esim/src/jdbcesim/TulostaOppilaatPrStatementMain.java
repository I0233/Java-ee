package jdbcesim;

import java.sql.*;

import jdbcconf.TietokantayhteysTehdas;

/*
 * Kyselyesimerkki
 * Käytetään PreparedStatament tyyppisiä lausekkeita.
 * 
 **/
public class TulostaOppilaatPrStatementMain {

	public static void main(String args[]) {
		Connection conn = null;
		try {

			conn = TietokantayhteysTehdas.getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement("select *, demopisteet+koepisteet as yht from oppilas where nimi LIKE ?");
			String hakutaulu[] = { "Mik%", "%nni", "%ku%" };

			for (int i = 0; i < hakutaulu.length; i++) {
				pstmt.setString(1, hakutaulu[i]);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					String nimi = rs.getString("nimi");
					int demo = rs.getInt("demopisteet");
					int koe = rs.getInt("koepisteet");
					int yht = rs.getInt("yht");
					System.out.println(nimi + "\t" + demo + "\t" + koe + "\t" + yht);
				}
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
