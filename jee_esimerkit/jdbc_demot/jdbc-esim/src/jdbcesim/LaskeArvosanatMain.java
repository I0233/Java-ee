package jdbcesim;

import java.sql.*;

import jdbcconf.TietokantayhteysTehdas;


/*
 Lasketaan Oppilaan saama arvosana. Oppilas haetaan tietokannasta id:n perusteella.
 
* Arvosana lasketaan: demopisteet + koepisteet
* Pisterajat: 
*  18-23: 1; 
*  23-28:2; 
*  28-33: 3; 
*  33-36: 4; 
*  >36 5
*  
*  @author Juha Peltomäki
*/
public class LaskeArvosanatMain {
	static int grades[][] = { { 18, 1 }, { 23, 2 }, { 28, 3 }, { 33, 4 }, { 36, 5 } };

	public static void main(String args[]) {
		Connection conn = null;

		try {
			conn = TietokantayhteysTehdas.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select *, demopisteet+koepisteet as yht from oppilas");

			while (rs.next()) {
				int id = rs.getInt("id");
				String nimi = rs.getString("nimi");
				int demo = rs.getInt("demopisteet");
				int koe = rs.getInt("koepisteet");
				int yht = rs.getInt("yht");

				System.out.print(id + ".\t" + nimi + "\t" + demo + "\t" + koe + "\t" + yht + "\t");
				int grade = countGrade(demo, koe);
				System.out.println(" => " + grade);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	// @return arvosana
	public static int countGrade(int demo, int koe) {
		int total = demo + koe;

		for (int i = 0; i < grades.length; i++) {
			if (grades[i][0] > total)
				return grades[i][1];
		}
		if (total > grades[4][0])
			return 5;
		return -1;

	}

}
