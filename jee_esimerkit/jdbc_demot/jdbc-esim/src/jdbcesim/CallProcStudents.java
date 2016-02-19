package jdbcesim;

import java.sql.*;

import jdbcconf.TietokantayhteysTehdas;


/*
 * Tallennettujen proseduurien (Stored Procedures) kutsuminen.
 * 
 * Javasta voi kutsua tietokantapalvelimella luotua ja tallennettua funktiona eli
 * ns. stored procedure -aliohjelmaa. Nämä ovat kuitenkin tietokantariippuvaisia eli
 * vähentävät mahdollisuutta siirtää ohjelmaa eri tietokantojen välillä.
 *  
 * Tähän JDBC käyttää CallableStatement luokkaa.
 * Huom! Tämä esimerkki toimii MySQL:n 5-versiossa.
 * 
 
 Alla Stored Procedure -aliohjelma ja sen kutsuminen MySQL 5-tietokannassa:
 
 delimiter //
 CREATE PROCEDURE laskeRivitMaxid (OUT rivit INT, OUT maxid INT)
  BEGIN
    SELECT COUNT(*) INTO rivit FROM oppilas;
    SELECT MAX(id) INTO maxid FROM oppilas;
  END;
 //

 delimiter ;
 CALL laskeRivitMaxid(@a, @b);
 SELECT @a, @b;
 
 Lisätietoa:
 http://dev.mysql.com/doc/refman/5.0/en/create-procedure.html
 **/

public class CallProcStudents {

	public static void main(String args[]) {
		Connection conn = null;
		try {

			conn = TietokantayhteysTehdas.getConnection();

			CallableStatement cstmt = conn.prepareCall("CALL laskeRivitMaxid(?,?)");
			// rekisteräidään parametrit
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
			// suoritetaan kutsu
			cstmt.execute();
			// int lkm = cstmt.getInt(1);
			// int maxid = cstmt.getInt(2);
			// System.out.println("Tietueessa on " + lkm + " kenttää ja Max ID
			// on " + maxid);
			System.out.println("Tietueessa on " + cstmt.getString(1) + " kenttää ja Max ID on " + cstmt.getString(2));
			cstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
 * Esimerkkitulostus:
 * 
 * Tietueessa on 25 kenttää ja Max ID on 42
 */
