/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="conseillers")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Conseiller implements Serializable {
	
	//-----Attributs-----//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_conseiller")
	private int id;
	
	private String identifiant;
	private String mdp;
	private String mail;
	
	//-----Constructeurs-----//
	/**
	 * 
	 */
	public Conseiller() {
		super();
	}

	/**
	 * @param identifiant
	 * @param mdp
	 * @param mail
	 */
	public Conseiller(String identifiant, String mdp, String mail) {
		super();
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.mail = mail;
	}

	/**
	 * @param id
	 * @param identifiant
	 * @param mdp
	 * @param mail
	 * @param listeClients
	 * @param listeProprietaires
	 */
	public Conseiller(int id, String identifiant, String mdp, String mail, List<Client> listeClients,
			List<Proprietaire> listeProprietaires) {
		super();
		this.id = id;
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.mail = mail;
		this.listeClients = listeClients;
		this.listeProprietaires = listeProprietaires;
	}
	
	//-----Associations-----//
	
	
	@OneToMany(mappedBy="conseiller", cascade=CascadeType.ALL)
	private List<Client> listeClients;
	
	
	@OneToMany(mappedBy="conseiller", cascade=CascadeType.ALL)
	private List<Proprietaire> listeProprietaires;
	
	
	@OneToMany(mappedBy="conseiller", cascade=CascadeType.ALL)
	private List<Bien> listeBiens;

	
	@OneToMany(mappedBy="conseiller", cascade=CascadeType.ALL)
	private List<Visite> listeVisites;
	
	
	@OneToMany(mappedBy="conseiller", cascade=CascadeType.ALL)
	private List<Contrat> listeContrats;
	
	//-----Getters & Setters-----//

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
	 * @return the identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant the identifiant to set
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the listeClients
	 */
	public List<Client> getListeClients() {
		return listeClients;
	}

	/**
	 * @param listeClients the listeClients to set
	 */
	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	/**
	 * @return the listeBiens
	 */
	public List<Bien> getListeBiens() {
		return listeBiens;
	}

	/**
	 * @param listeBiens the listeBiens to set
	 */
	public void setListeBiens(List<Bien> listeBiens) {
		this.listeBiens = listeBiens;
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
	 * @return the listeContrats
	 */
	public List<Contrat> getListeContrats() {
		return listeContrats;
	}

	/**
	 * @param listeContrats the listeContrats to set
	 */
	public void setListeContrats(List<Contrat> listeContrats) {
		this.listeContrats = listeContrats;
	}

	/**
	 * @return the listeProprietaires
	 */
	public List<Proprietaire> getListeProprietaires() {
		return listeProprietaires;
	}

	/**
	 * @param listeProprietaires the listeProprietaires to set
	 */
	public void setListeProprietaires(List<Proprietaire> listeProprietaires) {
		this.listeProprietaires = listeProprietaires;
	}
	
	

}