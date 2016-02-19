package avustavat_luokat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MonivalintaDTO {
	private int id;
	private String kysymys;
	private List<VaihtoehtoDTO> vaihtoehdot;
	
	public MonivalintaDTO(){
		this.id = 0;
		this.kysymys = null;
		this.vaihtoehdot = null;
	}

	public int get_id(int _id){
		return this.id = _id;
	}
	
	public String get_kysymys(String _kysymys){
		return this.kysymys = _kysymys;
	}

	public List<VaihtoehtoDTO>get_vaihtoehdot(List<VaihtoehtoDTO> _vaihtoehdot){
		this.vaihtoehdot.add((VaihtoehtoDTO) _vaihtoehdot);
		return _vaihtoehdot;
	}
	
	
	@Override
	public String toString(){
		return(this.id +"\t"+ this.kysymys +"\t" + this.vaihtoehdot);
	}

}
