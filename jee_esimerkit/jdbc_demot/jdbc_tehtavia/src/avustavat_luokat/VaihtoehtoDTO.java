package avustavat_luokat;

public class VaihtoehtoDTO {
	private int id;
	private int kysymysId;
	private String teksti;
	private Boolean oikein;
	
	public VaihtoehtoDTO(){
		this.id = 0;
		this.kysymysId = 0;
		this.teksti = null;
		this.oikein = null;
	}
	
	public int get_id(int id){
		return this.id = id;
	}
	
	public int get_kysymys_id(int kysymysId){
		return this.kysymysId = kysymysId;
	}
	
	public String get_teksti(String teksti){
		return this.teksti = teksti;
	}
	
	public Boolean get_oikein(Boolean oikein){
		return this.oikein = oikein;
	}
	
}
