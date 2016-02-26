package tuoteLuokat;

public class Tuote {

	private String nimi;
	
	private String koodi;
	
	private double hinta;
	 
	public Tuote() {
		this.nimi = null;
		this.koodi = null;
		this.hinta = 0;
	}
	public Tuote(String nimi, String koodi, double hinta){
		this.nimi = nimi;
		this.koodi = koodi;
		this.hinta = hinta;
	}
	
	public void setNimi(String n){
		this.nimi = n;
	}
	public void setHinta(double h){
		this.hinta = h;
	}
	public void setKoodi(String k){
		this.koodi = k;
	}
	
	public String getNimi(){
		return nimi;
	}
	public double getHinta(){
		return hinta;
	}
	public String getKoodi(){
		return koodi;
	}
	@Override
	public String toString(){
		return "Tuote[nimi="+this.nimi
				+", koodi="+this.koodi
				+", hinta="+this.hinta
				+"]";
	}
}
