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

@Entity
@DiscriminatorValue(value="habitations")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")

/**
 * @author INTI-0366
 *
 */
public class Habitation extends Bien {
	
	//-----Attributs-----//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_habitation")
	private int id;
	
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
	 * @param description
	 * @param type
	 */
	public Habitation(String description, String type) {
		super();
		this.description = description;
		this.type = type;
	}

	/**
	 * @param id
	 * @param description
	 * @param type
	 */
	public Habitation(int id, String description, String type) {
		super();
		this.id = id;
		this.description = description;
		this.type = type;
	}
	
	//-----Getters et Setters-----//

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

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
		return "Habitation [id=" + id + ", description=" + description + ", type=" + type + "]";
	}

}