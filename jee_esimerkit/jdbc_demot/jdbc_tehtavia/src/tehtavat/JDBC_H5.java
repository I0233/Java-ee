package tehtavat;

import java.sql.*;
import java.util.ArrayList;

import jdbc_conf.Tietokannan_yhteys;
import avustavat_luokat.HenkiloDTO;

public class JDBC_H5 {
	public static void main(String[] args) {
		
		try{
			Connection conn = Tietokannan_yhteys.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from henkilo where sukunimi = 'Ankka' or sukunimi = 'Hiiri'");
			ArrayList<HenkiloDTO> henkilot = new ArrayList<>();
			while(rs.next()){
				HenkiloDTO  henkilo = new HenkiloDTO();
				henkilo.set_Htiedot(rs.getObject("etunimi").toString(), rs.getObject("sukunimi").toString(), rs.getObject("sotu").toString());
				henkilo.set_Date(rs.getDate("syntymaaika"));
				henkilo.set_palkka(rs.getBigDecimal("palkka"));
				henkilot.add(henkilo);
			}
			
			System.out.println("********************* Tulostetaan kaikki Ankka ja Hiiri sukunimiset ************************************");
			for (Object persons : henkilot){
				System.out.println(persons);
			}
			System.out.println("********************************************************************************************************");
		}
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
