package tuoteLuokat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import databasePackage.TietokantayhteysTehdas;

public class JDBC_asiakasohjelma_h3b {
	
	 public void getOppilaat() throws SQLException, IOException {
		 Connection conn = TietokantayhteysTehdas.getConnection();
		 Statement stmt = conn.createStatement();
	     ResultSet rs = stmt.executeQuery("select * from tuotetaulu");
	        while (rs.next()) {
	            // retrieve and print the values for the current database row
	            int id = rs.getInt("TuoteId");
	            String nimi = rs.getString("nimi");
	            String koodi = rs.getString("koodi");
	            double hinta = rs.getDouble("hinta");
	           System.out.println(id+ "\t" +koodi+ "\t" +nimi+ "\t" +hinta);
	        }
	        rs.close();
	    }
	 public static void main(String[] args) throws IOException, ClassNotFoundException {
		try {
			JDBC_asiakasohjelma_h3b h3 = new JDBC_asiakasohjelma_h3b();
			h3.getOppilaat();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 

}
