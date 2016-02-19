package jdbcesim;

import java.sql.*;

import jdbcconf.TietokantayhteysTehdas;


/* 
 * Luodaan oppilas -tietokanta.
 * Jos tietokanta on jo tehty sitä ei enää luoda uudelleen tällä ohjelmalla, vaan se on poistettava erikseen.
 * 
 * @author Juha Peltomäki
 */
public class LuoOppilasTauluMain {
	/*
	final static List<Worker> disneyWorkers = Arrays.asList(
	        new Worker("Duck, Donald", "1934-05-21"),
	        new Worker("Mouse, Mickey", "1928-11-18"),
	        new Worker("Goofy", "1932-06-01"),
	        new Worker("Black, Pete", "1925-06-01"),
	        new Worker("McDuck, Scrooge", "1947-12-01"),
	        new Worker("Duck, Louie", "1937-06-01"),
	        new Worker("Duck, Huey", "1937-06-01"),
	        new Worker("Duck, Dewey", "1937-06-01"),
	        new Worker("Duck, Daisy", "1940-06-01"),
	        new Worker("Duck, Grandma", "1943-06-01"),
	        new Worker("Gander, Gladstone", "1948-01-01"),
	        new Worker("Goose, Gus", "1939-05-03"),
	        new Worker("Pluto", "1930-06-01"),
	        new Worker("Mouse, Minnie", "1928-11-18"),
	        new Worker("Horsecollar, Horace", "1929-06-01"),
	        new Worker("Gearloose, Gyro", "1952-05-01"),
	        new Worker("Helper, Little", "1956-06-01"),
	        new Worker("Beeva, Eega", "1947-05-01"),
	        new Worker("O'Hara, Chief", "1935-06-01"),
	        new Worker("Blot, Phantom", "1939-05-20")
	        );
	*/

	// staattiset lausekkeet demotietokannan luontiin Javalla
	final static String lauseet[] = {
			"DROP TABLE if exists oppilas",
			"CREATE TABLE oppilas (id int NOT NULL auto_increment, nimi varchar(64), demopisteet int NOT NULL, koepisteet int NOT NULL, syntymaaika date, primary key (id))",
			"INSERT INTO oppilas (nimi,demopisteet,koepisteet,syntymaaika) VALUES ('Aku',10,20,'1934-05-21')",
			"INSERT INTO oppilas (nimi,demopisteet,koepisteet,syntymaaika) VALUES ('Hessu',12,22, '1932-06-01')",
			"INSERT INTO oppilas (nimi,demopisteet,koepisteet,syntymaaika) VALUES ('Mikki',4,19,'1928-11-18')",
			"INSERT INTO oppilas (nimi,demopisteet,koepisteet,syntymaaika) VALUES ('Iines',11,22,'1940-06-01')",
			"INSERT INTO oppilas (nimi,demopisteet,koepisteet,syntymaaika) VALUES ('Heluna',13,22,'1929-06-01')",
			"INSERT INTO oppilas (nimi,demopisteet,koepisteet,syntymaaika) VALUES ('Minni',8,19,'1928-11-18')",
			"INSERT INTO oppilas (nimi,demopisteet,koepisteet,syntymaaika) VALUES ('Tupu',12,21,'1937-06-01')",
			"INSERT INTO oppilas (nimi,demopisteet,koepisteet,syntymaaika) VALUES ('Eka',15,22,'1947-05-01')",
			"INSERT INTO oppilas (nimi,demopisteet,koepisteet,syntymaaika) VALUES ('Pluto',5,6,'1930-06-01')",
			"INSERT INTO oppilas (nimi,demopisteet,koepisteet,syntymaaika) VALUES ('Hannu',20,20,'1948-01-01')"

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
			ResultSet rs = stmt.executeQuery("select id, nimi from oppilas");
			while (rs.next()) {
				int id = rs.getInt("id");
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
