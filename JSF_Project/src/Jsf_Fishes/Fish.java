package Jsf_Fishes;

import javax.faces.bean.*;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class Fish implements java.io.Serializable {
	private String species;  // kalalaji
    private String name;     // lempinimi
    private int weight;      // paino
    private int length;      // pituus
    private boolean editable; 

	public Fish() {
		this.species = null;
		this.name = null;
		this.weight = 0;
		this.length = 0;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the editable
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * @param editable the editable to set
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	/* 
	 * Muuttaa luokan entiteetit stringksi
	 */
	@Override
	public String toString() {
		return "Fish [kalalaji=" + species + ", lempinimi=" + name + ", paino=" + weight + ", pituus=" + length
				+  "]";
	}

}
