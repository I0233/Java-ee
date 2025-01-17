package tehtavat;

import java.sql.*;

import jdbc_conf.Tietokannan_yhteys;

public class JDBC_H6 {

	final static String lauseet[] = {
	"DROP TABLE if exists Vaihtoehto",
	"DROP TABLE if exists Monivalinta",
	"CREATE TABLE Monivalinta (id int not null, kysymys varchar(255), primary key ( id ))",
	"CREATE TABLE Vaihtoehto (id int not null auto_increment, kys_id int, teksti varchar(255), oikein boolean, foreign key (kys_id) references Monivalinta(id), primary key ( id ))",
	"Insert into Monivalinta (id, kysymys) values (1, 'Ruotsin pääkaupunki')",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (1, 'Oslo', false)",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (1, 'Tukholma', true)",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (1, 'Göteborg', false)",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (1, 'Luulaja', false)",
	"Insert into Monivalinta (id, kysymys) values (2, 'Suosituin ohjelmointikieli')",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (2, 'C', false)",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (2, 'C#', false)",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (2, 'Java', true)",
	"Insert into Monivalinta (id, kysymys) values (3, 'Web selainten ohjelmointikieli')",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (3, 'TypeX', false)",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (3, 'perl', false)",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (3, 'JavaScript', true)",
	"Insert into Monivalinta (id, kysymys) values (4, 'Käytetyin merkintäkieli Webissä')",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (4, 'XML', false)",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (4, 'JavaScript', false)",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (4, 'HTML', true)",
	"Insert into Monivalinta (id, kysymys) values (5, 'JavaEE Framework?')",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (5, 'JSF', true)",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (5, 'JPA', true)",
	"Insert into Vaihtoehto (kys_id, teksti, oikein) values (5, 'EJB', true)"
	};
	
	public static void main(String args[]) {
		Connection conn = null;
		try {
			conn = Tietokannan_yhteys.getConnection();
			Statement stmt = conn.createStatement();
			
			int tulos = 0;
			for (String sql : lauseet) {
				tulos += stmt.executeUpdate(sql);
			}
			System.out.println("Päivityksiä yhteensä " + tulos + " kappaletta");
			stmt.close();
			conn.close();
		}
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
