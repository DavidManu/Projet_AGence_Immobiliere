/**
 * 
 */
package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="locationLocs")
@DiscriminatorValue(value="location")
/**
 * @author INTI-0366
 *
 */
public class LocationLoc extends Locaux {
	
	//-----Attributs-----//
	
	private double caution;
	private double loyer;
	private double charge;
	private boolean guarniture;
	
	//-----Constructeurs-----//
	
	/**
	 * 
	 */
	public LocationLoc() {
		super();
	}

	/**
	 * @param caution
	 * @param loyer
	 * @param charge
	 * @param guarniture
	 */
	public LocationLoc(double caution, double loyer, double charge, boolean guarniture) {
		super();
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.guarniture = guarniture;
	}
	
	//-----Getters et Setters-----//

	/**
	 * @return the caution
	 */
	public double getCaution() {
		return caution;
	}

	/**
	 * @param caution the caution to set
	 */
	public void setCaution(double caution) {
		this.caution = caution;
	}

	/**
	 * @return the loyer
	 */
	public double getLoyer() {
		return loyer;
	}

	/**
	 * @param loyer the loyer to set
	 */
	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}

	/**
	 * @return the charge
	 */
	public double getCharge() {
		return charge;
	}

	/**
	 * @param charge the charge to set
	 */
	public void setCharge(double charge) {
		this.charge = charge;
	}

	/**
	 * @return the guarniture
	 */
	public boolean isGuarniture() {
		return guarniture;
	}

	/**
	 * @param guarniture the guarniture to set
	 */
	public void setGuarniture(boolean guarniture) {
		this.guarniture = guarniture;
	}
	
	//-----Methode String-----//

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Location [caution=" + caution + ", loyer=" + loyer + ", charge=" + charge
				+ ", guarniture=" + guarniture + "]";
	}

}