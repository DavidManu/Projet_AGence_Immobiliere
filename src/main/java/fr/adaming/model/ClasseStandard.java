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
public class ClasseStandard implements Serializable {
	
	//-----Attributs-----//
	
	private int prixMin;
	private int minSurfaceMin;
	private int dateConstructionMin;
	
	//-----Constructeurs-----//
	
	/**
	 * 
	 */
	public ClasseStandard() {
		super();
	}


	/**
	 * @param prixMin
	 * @param minSurfaceMin
	 * @param dateConstructionMin
	 */
	public ClasseStandard(int prixMin, int minSurfaceMin, int dateConstructionMin) {
		super();
		this.prixMin = prixMin;
		this.minSurfaceMin = minSurfaceMin;
		this.dateConstructionMin = dateConstructionMin;
	}
	
	//-----Getters et Setters-----//

	/**
	 * @return the prixMin
	 */
	public int getPrixMin() {
		return prixMin;
	}

	/**
	 * @param prixMin the prixMin to set
	 */
	public void setPrixMin(int prixMin) {
		this.prixMin = prixMin;
	}

	/**
	 * @return the minSurfaceMin
	 */
	public int getMinSurfaceMin() {
		return minSurfaceMin;
	}

	/**
	 * @param minSurfaceMin the minSurfaceMin to set
	 */
	public void setMinSurfaceMin(int minSurfaceMin) {
		this.minSurfaceMin = minSurfaceMin;
	}

	/**
	 * @return the dateConstructionMin
	 */
	public int getDateConstructionMin() {
		return dateConstructionMin;
	}

	/**
	 * @param dateConstructionMin the dateConstructionMin to set
	 */
	public void setDateConstructionMin(int dateConstructionMin) {
		this.dateConstructionMin = dateConstructionMin;
	}

}