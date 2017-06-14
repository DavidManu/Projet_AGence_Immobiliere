/**
 * 
 */
package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



/**
 * @author INTI-0366
 *
 */

@Entity
@Table(name = "clients")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Client {

	// -----Attributs-----//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private int id;

	private String prenom;
	private String nom;
	private String numPrive;

	// -----Associations-----//

	@Embedded
	private Adresse adresse;
	
	
	@ManyToOne
	@JoinColumn(name = "classeSt_id", referencedColumnName = "id_classeSt")
	private ClasseStandard classeStandard;

	
	@ManyToOne
	@JoinColumn(name = "conseiller_id", referencedColumnName = "id_conseiller")
	private Conseiller conseiller;


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "client_visite", joinColumns = @JoinColumn(name = "id_client"), inverseJoinColumns = @JoinColumn(name = "id_visite"))
	private List<Visite> listeVisites;

	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Contrat> listeContrats;

	// -----Constructeurs-----//

	/**
	 * 
	 */
	public Client() {
		super();
	}

	public Client(String prenom, String nom, String numPrive, Adresse adresse) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.numPrive = numPrive;
		this.adresse = adresse;
	}

	public Client(int id, String prenom, String nom, String numPrive, Adresse adresse) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.numPrive = numPrive;
		this.adresse = adresse;
	}

	// -----Getters & Setters-----//

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
	 * @return the classeStandard
	 */
	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	/**
	 * @return the conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	/**
	 * @return the listeVisites
	 */
	public List<Visite> getListeVisites() {
		return listeVisites;
	}

	/**
	 * @return the listeContrats
	 */
	public List<Contrat> getListeContrats() {
		return listeContrats;
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
	 * @param classeStandard
	 *            the classeStandard to set
	 */
	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	/**
	 * @param conseiller
	 *            the conseiller to set
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	/**
	 * @param listeVisites
	 *            the listeVisites to set
	 */
	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}

	/**
	 * @param listeContrats
	 *            the listeContrats to set
	 */
	public void setListeContrats(List<Contrat> listeContrats) {
		this.listeContrats = listeContrats;
	}

}