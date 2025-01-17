package tehtavat;

import java.sql.*;

import jdbc_conf.Tietokannan_yhteys;

public class JDBC_H4 {
	
	final static String lauseet[] = {
		"INSERT INTO henkilo (etunimi,sukunimi,sotu,palkka,syntymaaika) VALUES ('Musta', 'Pekka', '010626', 1200.00, '1926-06-01')",
		"INSERT INTO henkilo (etunimi,sukunimi,sotu,palkka,syntymaaika) VALUES ('Musta', 'Kaapu', '300539', 12900.90,'1939-05-30')"
	};
	
	public static void main(String[] args) {

		
		Connection conn = null;
		try {
			conn = Tietokannan_yhteys.getConnection();
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
			conn.commit();
			int tulos = 0;
			for (String sql : lauseet) {
				tulos += stmt.executeUpdate(sql);
			}
			System.out.println("Päivityksiä yhteensä " + tulos + " kappaletta");
			ResultSet rs = stmt.executeQuery("select * from henkilo where id > 8");
			while(rs.next()){
				System.out.println(rs.getObject("id") + "\t" + rs.getObject("etunimi")
						+" "+ rs.getObject("sukunimi")+"\t"+ rs.getObject("sotu")
						+"\t"+ rs.getObject("palkka")+"\t"+ rs.getObject("syntymaaika"));
			}
			stmt.close();
			conn.close();
		}
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
