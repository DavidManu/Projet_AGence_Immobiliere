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
@Table(name="achatLocs")
@DiscriminatorValue(value="achat")
/**
 * @author INTI-0366
 *
 */
public class AchatLoc extends Locaux {
	
	//-----Attributs-----//
	
	private double prix;
	
	//-----Constructeurs-----//
	
	/**
	 * 
	 */
	public AchatLoc() {
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
	 * @param prix
	 */
	public AchatLoc(Date dateDispo, Date dateMEL, byte[] photo, String cadastre, double superficie, Adresse adresse,
			String description, String type, double prix) {
		super(dateDispo, dateMEL, photo, cadastre, superficie, adresse, description, type);
		this.prix = prix;
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
	 * @param prix
	 */
	public AchatLoc(int id, Date dateDispo, Date dateMEL, byte[] photo, String cadastre, double superficie,
			Adresse adresse, String description, String type, double prix) {
		super(id, dateDispo, dateMEL, photo, cadastre, superficie, adresse, description, type);
		this.prix = prix;
	}
	
	//-----Getters et Setters-----//

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	//-----Methode String-----//

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AchatHab [prix=" + prix + "]";
	}

}