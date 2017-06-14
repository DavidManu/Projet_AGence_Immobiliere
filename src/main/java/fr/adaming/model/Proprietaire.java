/**
 * 
 */
package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "proprietaires")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Proprietaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proprietaire")
	private int id;

	private String prenom;
	private String nom;
	private String numTravail;
	private String numPrive;

	// -----Associations-----//

	@Embedded
	private Adresse adresse;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conseiller_id", referencedColumnName = "id_conseiller")
	private Conseiller conseiller;

	@OneToMany(mappedBy = "proprietaire", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Bien> listeBiens;

	public Proprietaire() {
		super();
	}

	public Proprietaire(String prenom, String nom, String numTravail, String numPrive, Adresse adresse) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.numTravail = numTravail;
		this.numPrive = numPrive;
		this.adresse = adresse;
	}

	public Proprietaire(int id, String prenom, String nom, String numTravail, String numPrive, Adresse adresse) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.numTravail = numTravail;
		this.numPrive = numPrive;
		this.adresse = adresse;
	}

	// -----Getters & Setters -----//
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param prenom
	 *            the prenom to set
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
	 * @param nom
	 *            the nom to set
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
	 * @param numTravail
	 *            the numTravail to set
	 */
	public void setNumTravail(String numTravail) {
		this.numTravail = numTravail;
	}

	/**
	 * @return the numPrive
	 */
	public String getNumPrive() {
		return numPrive;
	}

	/**
	 * @param numPrive
	 *            the numPrive to set
	 */
	public void setNumPrive(String numPrive) {
		this.numPrive = numPrive;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the conseiller
	 */
	public int getConseiller() {
		return conseiller.getId();
	}

	/**
	 * @param conseiller
	 *            the conseiller to set
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	/**
	 * @return the listeBiens
	 */
	public List<Bien> getListeBiens() {
		return listeBiens;
	}

	/**
	 * @param listeBiens
	 *            the listeBiens to set
	 */
	public void setListeBiens(List<Bien> listeBiens) {
		this.listeBiens = listeBiens;
	}

}