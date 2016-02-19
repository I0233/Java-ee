package tehtavat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jdbc_conf.Tietokannan_yhteys;
import avustavat_luokat.*;

public class JDBC_H7 {

	public static void main(String[] args) {
		try {
			Connection conn = Tietokannan_yhteys.getConnection();
			PreparedStatement prp_stmt = conn.prepareStatement("select * from Monivalinta");
			PreparedStatement prp_stmt2 = conn.prepareStatement("select * from Vaihtoehto");
			ResultSet rs = prp_stmt.executeQuery();
			ResultSet rs2 = prp_stmt2.executeQuery();
			VaihtoehtoDTO ve = new VaihtoehtoDTO();
			MonivalintaDTO mv = new MonivalintaDTO();
			List <VaihtoehtoDTO> vaihtoehdot= new ArrayList<VaihtoehtoDTO>();
			while(rs2.next()){
				ve.get_id(rs2.getInt("id"));
				ve.get_kysymys_id(rs2.getInt("kys_id"));
				ve.get_oikein(rs2.getBoolean("oikein"));
				ve.get_teksti(rs2.getString("teksti"));
				vaihtoehdot.add(ve);
			}
			while (rs.next()){
				mv.get_id(rs.getInt("id"));
				mv.get_kysymys(rs.getString("kysymys"));
				mv.get_vaihtoehdot(vaihtoehdot);
				System.out.print(mv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
