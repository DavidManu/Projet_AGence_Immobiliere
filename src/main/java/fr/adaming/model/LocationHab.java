/**
 * 
 */
package fr.adaming.model;

import java.util.Date;

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
@Table(name="locationsHabs")
@DiscriminatorValue(value="location")
/**
 * @author INTI-0366
 *
 */
public class LocationHab extends Habitation {
	
	//-----Attributs-----//
	
	private double caution;
	private double loyer;
	private double charge;
	private boolean guarniture;
	
	//-----Constructeurs-----//
	
	/**
	 * 
	 */
	public LocationHab() {
		super();
	}

	/**
	 * @param dateDispo
	 * @param dateMEL
	 * @param photo
	 * @param cadastre
	 * @param superficie
	 * @param adresse
	 * @param description
	 * @param type
	 * @param caution
	 * @param loyer
	 * @param charge
	 * @param guarniture
	 */
	public LocationHab(Date dateDispo, Date dateMEL, byte[] photo, String cadastre, double superficie, Adresse adresse,
			String description, String type, double caution, double loyer, double charge, boolean guarniture) {
		super(dateDispo, dateMEL, photo, cadastre, superficie, adresse, description, type);
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.guarniture = guarniture;
	}

	/**
	 * @param id
	 * @param dateDispo
	 * @param dateMEL
	 * @param photo
	 * @param cadastre
	 * @param superficie
	 * @param adresse
	 * @param description
	 * @param type
	 * @param caution
	 * @param loyer
	 * @param charge
	 * @param guarniture
	 */
	public LocationHab(int id, Date dateDispo, Date dateMEL, byte[] photo, String cadastre, double superficie,
			Adresse adresse, String description, String type, double caution, double loyer, double charge,
			boolean guarniture) {
		super(id, dateDispo, dateMEL, photo, cadastre, superficie, adresse, description, type);
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