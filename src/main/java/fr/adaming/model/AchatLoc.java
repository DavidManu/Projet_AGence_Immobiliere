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

@Entity
@DiscriminatorValue(value="achat")
/**
 * @author INTI-0366
 *
 */
public class AchatLoc extends Locaux {
	
	//-----Attributs-----//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_achat")
	private int id;
	
	private double prix;
	
	//-----Constructeurs-----//
	
	/**
	 * 
	 */
	public AchatLoc() {
		super();
	}

	/**
	 * @param prix
	 */
	public AchatLoc(double prix) {
		super();
		this.prix = prix;
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
		return "AchatHab [id=" + id + ", prix=" + prix + "]";
	}

}