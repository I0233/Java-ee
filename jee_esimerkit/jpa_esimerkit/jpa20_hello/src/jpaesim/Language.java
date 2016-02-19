package jpaesim;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Language
 *
 */
@javax.persistence.Entity
@NamedQuery(name = "selectAll", query = "SELECT lang from Language lang")
public class Language implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String code;
	private static final long serialVersionUID = 1L;

	public Language() {
		super();
	}   


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
