package tuoteLuokat;


import java.util.ArrayList;
import java.util.List;

public class Tuotteet {
	
	List<Tuote> tuotteet;

	
	public Tuotteet(){
		this.tuotteet = new ArrayList<>();
	}
	
	public void setTuote(Tuote t){
		tuotteet.add(t);
	}

	public List<Tuote> getTuotteet(){
		return tuotteet;
	}

	@Override
	 public String toString(){
		return (tuotteet.toString());
	}
}
