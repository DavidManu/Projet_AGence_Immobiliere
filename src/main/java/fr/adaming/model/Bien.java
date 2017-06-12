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
import javax.persistence.Embedded;
import javax.persistence.Entity;
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

@Entity
@Table(name="biens")
@DiscriminatorValue(value="biens")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="genre")

/**
 * @author INTI-0366
 *
 */
public class Bien implements Serializable {
	
	//-----Attributs-----//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bien")
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date dateDispo;
	
	@Temporal(TemporalType.DATE)
	private Date dateMEL;
	
	@Lob
	private byte[] photo;
	
	private String cadastre;
	private double superficie;
	
	//-----Associations-----//
	
	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name="classeSt_id", referencedColumnName="id_classeSt")
	private ClasseStandard classeStandard;
	
	@ManyToOne
	@JoinColumn(name="conseiller_id", referencedColumnName="id_conseiller")
	private Conseiller conseiller;
	
	@ManyToOne
	@JoinColumn(name="personne_id", referencedColumnName="id_personne")
	private Proprietaire proprietaire;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="visite_bien",
		joinColumns=@JoinColumn(name="id_bien"),
		inverseJoinColumns=@JoinColumn(name="id_visite"))
	private List<Visite> listeVisites;
	
	@OneToOne(mappedBy="bien")
	private Contrat contrat;
	
	//-----Constructeurs-----//

	/**
	 * 
	 */
	public Bien() {
		super();
	}

	/**
	 * @param dateDispo
	 * @param dateMEL
	 * @param photo
	 * @param cadastre
	 * @param superficie
	 * @param adresse
	 */
	public Bien(Date dateDispo, Date dateMEL, byte[] photo, String cadastre, double superficie, Adresse adresse) {
		super();
		this.dateDispo = dateDispo;
		this.dateMEL = dateMEL;
		this.photo = photo;
		this.cadastre = cadastre;
		this.superficie = superficie;
		this.adresse = adresse;
	}

	/**
	 * @param id
	 * @param dateDispo
	 * @param dateMEL
	 * @param photo
	 * @param cadastre
	 * @param superficie
	 * @param adresse
	 */
	public Bien(int id, Date dateDispo, Date dateMEL, byte[] photo, String cadastre, double superficie,
			Adresse adresse) {
		super();
		this.id = id;
		this.dateDispo = dateDispo;
		this.dateMEL = dateMEL;
		this.photo = photo;
		this.cadastre = cadastre;
		this.superficie = superficie;
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
	 * @return the dateDispo
	 */
	public Date getDateDispo() {
		return dateDispo;
	}

	/**
	 * @param dateDispo the dateDispo to set
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
	 * @param dateMEL the dateMEL to set
	 */
	public void setDateMEL(Date dateMEL) {
		this.dateMEL = dateMEL;
	}

	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	/**
	 * @return the cadastre
	 */
	public String getCadastre() {
		return cadastre;
	}

	/**
	 * @param cadastre the cadastre to set
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
	 * @param superficie the superficie to set
	 */
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
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
	 * @return the conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller the conseiller to set
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	/**
	 * @return the proprietaire
	 */
	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	/**
	 * @param proprietaire the proprietaire to set
	 */
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	/**
	 * @return the listeVisites
	 */
	public List<Visite> getListeVisites() {
		return listeVisites;
	}

	/**
	 * @param listeVisites the listeVisites to set
	 */
	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}

	/**
	 * @return the classeStandard
	 */
	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	/**
	 * @param classeStandard the classeStandard to set
	 */
	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	/**
	 * @return the contrat
	 */
	public Contrat getContrat() {
		return contrat;
	}

	/**
	 * @param contrat the contrat to set
	 */
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	
	//-----Methode String-----//

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bien [id=" + id + ", dateDispo=" + dateDispo + ", dateMEL=" + dateMEL + ", photo="
				+ Arrays.toString(photo) + ", cadastre=" + cadastre + ", superficie=" + superficie + "]";
	}

}