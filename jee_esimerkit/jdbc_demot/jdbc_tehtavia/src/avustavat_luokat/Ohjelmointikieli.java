package avustavat_luokat;

import java.sql.Date;

public class Ohjelmointikieli {
	private Integer id ;
	private String nimi;
	private String versio;
	private String suunnittelija;
	private Date julkaistu;
	
	public void set_id(int _id){
		this.id = _id;
	}
	
	public int id(){
		return id;
	}
	
	public void set_nimi(String _nimi){
		this.nimi = _nimi;
	}
	
	public String nimi(){
		return nimi;
	}
	
	public void set_versio(String _version){
		this.versio = _version;
	}
	
	public String versio(){
		return versio;
	}
	
	public void set_suunnitelija(String _suunnittelija){
		this.suunnittelija = _suunnittelija;
	}
	
	public String suunnitelija(){
		return suunnittelija;
	}
	
	public void set_julkaistu(Date _julkaistu){
		this.julkaistu = _julkaistu;
	}
	
	public Date julkaistu(){
		return julkaistu;
	}
	
	@Override
	public String toString(){
		return (this.nimi() +" "+ this.versio() +" "+ this.suunnitelija() +" "+ this.julkaistu() );
	}
}
