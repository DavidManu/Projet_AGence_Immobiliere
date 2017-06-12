/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable

/**
 * @author INTI-0366
 *
 */
public class Adresse implements Serializable {
	
	//-----Attributs-----//
	
	private String rue;
	private String codePostal;
	private String ville;
	
	//-----Constructeurs-----//
	
	/**
	 * 
	 */
	public Adresse() {
		super();
	}

	/**
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	//-----Getters et Setters-----//

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

}