/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "biens")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Bien implements Serializable {

	// -----Attributs-----//

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bien")
	private int id;

	@Temporal(TemporalType.DATE)
	private Date dateDispo;

	@Temporal(TemporalType.DATE)
	private Date dateMEL;

	private String statut;

	@Lob
	private byte[] photo;

	private String image;

	private String video;

	// Maison Appartement ......
	private String type;

	// Disocier si location ou achat
	private boolean genre;

	private String cadastre;

	private double superficie;

	// Attributs pour location

	private double caution;

	private double loyer;

	private double charges;

	private String garniture;

	private String typeBail;

	// Attribut pour achat

	private double prix;

	private String etat;

	// -----Associations-----//

	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "classeSt_id", referencedColumnName = "id_classeSt")
	private ClasseStandard classeStandard;

	// @ManyToOne
	// @JoinColumn(name = "conseiller_id", referencedColumnName =
	// "id_conseiller")
	// private Conseiller conseiller;

	@ManyToOne
	@JoinColumn(name = "proprietaire_id", referencedColumnName = "id_proprietaire")
	private Proprietaire proprietaire;

	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id_client")
	private Client client;

	@ManyToMany
	@JoinTable(name = "visite_bien", joinColumns = @JoinColumn(name = "id_bien"), inverseJoinColumns = @JoinColumn(name = "id_visite"))
	private List<Visite> listeVisites;

	@OneToOne(mappedBy = "bien")
	private Contrat contrat;

	// -----Constructeurs-----//

	/**
	 * 
	 */
	public Bien() {
		super();
	}

	public Bien(Date dateDispo, Date dateMEL, String statut, byte[] photo, String type, boolean genre, String cadastre,
			double superficie, double caution, double loyer, double charges, String garniture, String typeBail,
			double prix, String etat, Adresse adresse, String image, String video) {
		super();
		this.dateDispo = dateDispo;
		this.dateMEL = dateMEL;
		this.statut = statut;
		this.photo = photo;
		this.type = type;
		this.genre = genre;
		this.cadastre = cadastre;
		this.superficie = superficie;
		this.caution = caution;
		this.loyer = loyer;
		this.charges = charges;
		this.garniture = garniture;
		this.typeBail = typeBail;
		this.prix = prix;
		this.etat = etat;
		this.adresse = adresse;
		this.image = image;
		this.video = video;
	}

	public Bien(int id, Date dateDispo, Date dateMEL, String statut, byte[] photo, String type, boolean genre,
			String cadastre, double superficie, double caution, double loyer, double charges, String garniture,
			String typeBail, double prix, String etat, Adresse adresse, String image, String video) {
		super();
		this.id = id;
		this.dateDispo = dateDispo;
		this.dateMEL = dateMEL;
		this.statut = statut;
		this.photo = photo;
		this.type = type;
		this.genre = genre;
		this.cadastre = cadastre;
		this.superficie = superficie;
		this.caution = caution;
		this.loyer = loyer;
		this.charges = charges;
		this.garniture = garniture;
		this.typeBail = typeBail;
		this.prix = prix;
		this.etat = etat;
		this.adresse = adresse;
		this.image = image;
		this.video = video;
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
	 * @return the video
	 */
	public String getVideo() {
		return video;
	}

	/**
	 * @param video
	 *            the video to set
	 */
	public void setVideo(String video) {
		this.video = video;
	}

	/**
	 * @return the dateDispo
	 */
	public Date getDateDispo() {
		return dateDispo;
	}

	/**
	 * @param dateDispo
	 *            the dateDispo to set
	 */
	public void setDateDispo(Date dateDispo) {
		this.dateDispo = dateDispo;
	}

	/**
	 * @return the dateMEL
	 */
	public Date getDateMEL() {
		return dateMEL;
	}

	/**
	 * @param dateMEL
	 *            the dateMEL to set
	 */
	public void setDateMEL(Date dateMEL) {
		this.dateMEL = dateMEL;
	}

	/**
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * @param statut
	 *            the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the genre
	 */
	public boolean isGenre() {
		return genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(boolean genre) {
		this.genre = genre;
	}

	/**
	 * @return the cadastre
	 */
	public String getCadastre() {
		return cadastre;
	}

	/**
	 * @param cadastre
	 *            the cadastre to set
	 */
	public void setCadastre(String cadastre) {
		this.cadastre = cadastre;
	}

	/**
	 * @return the superficie
	 */
	public double getSuperficie() {
		return superficie;
	}

	/**
	 * @param superficie
	 *            the superficie to set
	 */
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	/**
	 * @return the caution
	 */
	public double getCaution() {
		return caution;
	}

	/**
	 * @param caution
	 *            the caution to set
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
	 * @param loyer
	 *            the loyer to set
	 */
	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}

	/**
	 * @return the charges
	 */
	public double getCharges() {
		return charges;
	}

	/**
	 * @param charges
	 *            the charges to set
	 */
	public void setCharges(double charges) {
		this.charges = charges;
	}

	/**
	 * @return the garniture
	 */
	public String getGarniture() {
		return garniture;
	}

	/**
	 * @param garniture
	 *            the garniture to set
	 */
	public void setGarniture(String garniture) {
		this.garniture = garniture;
	}

	/**
	 * @return the typeBail
	 */
	public String getTypeBail() {
		return typeBail;
	}

	/**
	 * @param typeBail
	 *            the typeBail to set
	 */
	public void setTypeBail(String typeBail) {
		this.typeBail = typeBail;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * @param etat
	 *            the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
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
	 * @return the classeStandard
	 */
	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	/**
	 * @param classeStandard
	 *            the classeStandard to set
	 */
	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	// /**
	// * @return the conseiller
	// */
	// public Conseiller getConseiller() {
	// return conseiller;
	// }
	//
	// /**
	// * @param conseiller
	// * the conseiller to set
	// */
	// public void setConseiller(Conseiller conseiller) {
	// this.conseiller = conseiller;
	// }

	/**
	 * @return the proprietaire
	 */
	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	/**
	 * @param proprietaire
	 *            the proprietaire to set
	 */
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the listeVisites
	 */
	public List<Visite> getListeVisites() {
		return listeVisites;
	}

	/**
	 * @param listeVisites
	 *            the listeVisites to set
	 */
	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}

	/**
	 * @return the contrat
	 */
	public Contrat getContrat() {
		return contrat;
	}

	/**
	 * @param contrat
	 *            the contrat to set
	 */
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

}