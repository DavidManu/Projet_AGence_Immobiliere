/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Table(name="personnes")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="type")

/**
 * @author INTI-0366
 *
 */
public class Personne implements Serializable {
	
	//-----Attributs-----//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personne")
	private int id;
	
	private String prenom;
	private String nom;
	private String numTravail;
	private String numPrive;
	
	//-----Associations-----//
	
	@Embedded
	private Adresse adresse;
	
	//-----Constructeurs-----//
	
	/**
	 * 
	 */
	public Personne() {
		super();
	}

	/**
	 * @param prenom
	 * @param nom
	 * @param numTravail
	 * @param numPrive
	 */
	public Personne(String prenom, String nom, String numTravail, String numPrive) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.numTravail = numTravail;
		this.numPrive = numPrive;
	}

	/**
	 * @param id
	 * @param prenom
	 * @param nom
	 * @param numTravail
	 * @param numPrive
	 */
	public Personne(int id, String prenom, String nom, String numTravail, String numPrive) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.numTravail = numTravail;
		this.numPrive = numPrive;
	}
	
	/**
	 * @param prenom
	 * @param nom
	 * @param numTravail
	 * @param numPrive
	 * @param adresse
	 */
	public Personne(String prenom, String nom, String numTravail, String numPrive, Adresse adresse) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.numTravail = numTravail;
		this.numPrive = numPrive;
		this.adresse = adresse;
	}

	/**
	 * @param id
	 * @param prenom
	 * @param nom
	 * @param numTravail
	 * @param numPrive
	 * @param adresse
	 */
	public Personne(int id, String prenom, String nom, String numTravail, String numPrive, Adresse adresse) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.numTravail = numTravail;
		this.numPrive = numPrive;
		this.adresse = adresse;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the numTravail
	 */
	public String getNumTravail() {
		return numTravail;
	}

	/**
	 * @param numTravail the numTravail to set
	 */
	public void setNumTravail(String numTravail) {
		this.numTravail = numTravail;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the numPrive
	 */
	public String getNumPrive() {
		return numPrive;
	}

	/**
	 * @param numPrive the numPrive to set
	 */
	public void setNumPrive(String numPrive) {
		this.numPrive = numPrive;
	}
	
	//-----Methode String-----//

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personne [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", numTravail=" + numTravail
				+ ", numPrive=" + numPrive + "]";
	}

}