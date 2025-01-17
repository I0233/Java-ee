package tehtavat;

import java.sql.*;
import jdbc_conf.Tietokannan_yhteys;

public class JDBC_H2 {
	
	static Statement stmt;
	
	public static void main(String args[]) {
		Connection conn = null;
		try {
			conn = Tietokannan_yhteys.getConnection();
			System.out.println(conn);
			
			 stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("select * from henkilo");
			System.out.println("********************************Kaikki***************************");
			while (rs.next()) {
				
				System.out.println(rs.getObject("id") + "\t" + rs.getObject("etunimi")
						+" "+ rs.getObject("sukunimi")+"\t"+ rs.getObject("sotu")
						+"\t"+ rs.getObject("palkka")+"\t"+ rs.getObject("syntymaaika"));
			}
			System.out.println("******************Tulostus lopusta alkuun************************");
			ResultSet rs1 = stmt.executeQuery("select * from henkilo order by id Desc");
			while (rs1.next()) {
				
				System.out.println(rs1.getObject("id") + "\t" + rs1.getObject("etunimi")
						+" "+ rs1.getObject("sukunimi")+"\t"+ rs1.getObject("sotu")
						+"\t"+ rs1.getObject("palkka")+"\t"+ rs1.getObject("syntymaaika"));
			}
			System.out.println("*******************Rivejä tietokannassa**************************");
			ResultSet rs2 = stmt.executeQuery("select count(*) AS total from henkilo");
			while(rs2.next()){
				
				int rows = rs2.getInt("total");
				System.out.println("Tietokannassa on yhteensä "+ rows +" rivejä");
			}
			ResultSet rs3 = stmt.executeQuery("select * from henkilo where id >= 5");
			System.out.println("********************Tulostus puolivälistä************************");
			while (rs3.next()) {
				
				System.out.println(rs3.getObject("id") + "\t" + rs3.getObject("etunimi")
						+" "+ rs3.getObject("sukunimi")+"\t"+ rs3.getObject("sotu")
						+"\t"+ rs3.getObject("palkka")+"\t"+ rs3.getObject("syntymaaika"));
			}
			System.out.println("********************************Kaikki***************************");
			stmt.close();
			conn.close();
		}
		
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
