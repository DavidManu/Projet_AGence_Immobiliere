/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
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
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Table(name="habitations")
@DiscriminatorValue(value="habitations")

/**
 * @author INTI-0366
 *
 */
public class Habitation extends Bien {
	
	//-----Attributs-----//
	
	private String description;
	private String type;
	
	//-----Constructeurs-----//
	
	/**
	 * 
	 */
	public Habitation() {
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
	 */
	public Habitation(Date dateDispo, Date dateMEL, byte[] photo, String cadastre, double superficie, Adresse adresse,
			String description, String type) {
		super(dateDispo, dateMEL, photo, cadastre, superficie, adresse);
		this.description = description;
		this.type = type;
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
	 */
	public Habitation(int id, Date dateDispo, Date dateMEL, byte[] photo, String cadastre, double superficie,
			Adresse adresse, String description, String type) {
		super(id, dateDispo, dateMEL, photo, cadastre, superficie, adresse);
		this.description = description;
		this.type = type;
	}
	
	//-----Getters et Setters-----//

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	//-----Methode String-----//

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Habitation [description=" + description + ", type=" + type + "]";
	}

}