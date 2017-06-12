/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;

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
@Table(name="locaux")
@DiscriminatorValue(value="locaux")

/**
 * @author INTI-0366
 *
 */
public class Locaux extends Bien {
	
	//-----Attributs-----//
	
	private String description;
	private String type;
	
	//-----Constructeurs-----//
	
	/**
	 * 
	 */
	public Locaux() {
		super();
	}

	/**
	 * @param description
	 * @param type
	 */
	public Locaux(String description, String type) {
		super();
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