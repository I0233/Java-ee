package jdbcesim;

import java.sql.*;

import jdbcconf.TietokantayhteysTehdas;


/* 
 * Luodaan tuote -tietokanta.
 * Jos tietokanta on jo tehty sitä ei enää luoda uudelleen tällä ohjelmalla, vaan se on poistettava erikseen.
 * 
 * @author Juha Peltomäki
 */
public class LuoTuotteetTauluMain {
	// staattiset lausekkeet demotietokannan luontiin Javalla
	final static String lauseet[] = {
			"DROP TABLE IF exists tuotetaulu",
			"CREATE TABLE tuotetaulu ( TuoteId INTEGER AUTO_INCREMENT NOT NULL, nimi VARCHAR(50), koodi VARCHAR(20), hinta FLOAT, PRIMARY KEY(TuoteId)  )",
			"insert into tuotetaulu values (null, 'Microsoft Office 2010 Standard Open License', '021-05429', 736.90)",
			"insert into tuotetaulu values (null, 'HP Mini 5103 10.1', 'XM592AA#UUW', 398.90)",
			"insert into tuotetaulu values (null, 'Adobe Creative Suite 5 Design Premium', '65064508AF01A00', 2273.90)",
			"insert into tuotetaulu values (null, 'Adobe Acrobat Pro 7.0', '22020173', 623.90)",
			"insert into tuotetaulu values (null, 'Sony Bravia KDL-40EX402 40 Full HD', 'KDL40EX402', 699.90 )",
			"insert into tuotetaulu values (null, 'Archos 101 Internet Tablet 16 GB','501594', 408.90)",
			"insert into tuotetaulu values (null, 'Nokia Booklet 3G', '02717X8', 589.90)",
			"insert into tuotetaulu values (null, 'Apple Mac OS X v10.6.3 Snow Leopard', 'MC573', 27.90)",
			"insert into tuotetaulu values (null, 'F-Secure Internet Security 2010 Fin', 'FCI0OE1N001FI', 29.90)",
			"insert into tuotetaulu values (null, 'Nokia N900', '002M115', 449.90)"
	};

	public static void main(String args[]) {
		Connection conn = null;
		try {
			conn = TietokantayhteysTehdas.getConnection();
			System.out.println(conn);

			Statement stmt = conn.createStatement();

			int tulos = 0;
			for (String sql : lauseet) {
				tulos += stmt.executeUpdate(sql);
			}
			System.out.println("Päivityksiä yhteensä " + tulos + " kappaletta");

			// Kysely tietokantaan testaa, että data on lisätty sinne
			ResultSet rs = stmt.executeQuery("select TuoteId, nimi from tuotetaulu");
			while (rs.next()) {
				int id = rs.getInt("TuoteId");
				String nimi = rs.getString("nimi");
				System.out.println(id + "\t" + nimi);
			}

			
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
