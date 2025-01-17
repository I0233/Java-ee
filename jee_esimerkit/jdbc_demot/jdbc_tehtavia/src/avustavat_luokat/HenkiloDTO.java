package avustavat_luokat;

import java.math.BigDecimal;
import java.sql.Date;


public class HenkiloDTO {
	private String etunimi,sukunimi,sotu;
	private BigDecimal palkka;
	private Date syntymaaika;
	
	public HenkiloDTO() {
		// Konstrokturi
		this.etunimi = null;
		this.sukunimi = null;
		this.sotu = null;
		this.palkka = null;
		this.syntymaaika = null;
	}
	public void set_Htiedot(String _etunimi, String _sukunimi, String _sotu) {
		this.etunimi = _etunimi;
		this.sukunimi = _sukunimi;
		this.sotu = _sotu;

	}
	public void set_palkka(BigDecimal _palkka){
		this.palkka = _palkka;
	}
	public void set_Date(Date _syntymaaika){
		this.syntymaaika = _syntymaaika;
	}
	public String get_Htiedot(){
		return etunimi +" "+ sukunimi +" ("+sotu+")" ;
	}
	public BigDecimal get_palkka(){
		return palkka;
	}
	public Date get_Date(){
		return syntymaaika;
	}
	@Override
	public String toString(){
		return (this.get_Htiedot() +" syntyi "+ this.get_Date() +" ja saa palkkaa "+ this.get_palkka()+" euroa");
		
	}
}