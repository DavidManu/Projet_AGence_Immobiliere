/**
 * 
 */
package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@DiscriminatorValue(value = "visites")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Visite implements Serializable {

	// -----Attributs-----//

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visite")
	private int id;

	@Temporal(TemporalType.DATE)
	private Date dateVisite;
	private boolean clientAccepte;
	private boolean conseillerAccepte;
	private String chemin;

	// -----Associations-----//

	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="id_client")
	private Client client;

	@ManyToOne
	@JoinColumn(name="bien_id", referencedColumnName="id_bien")
	private Bien bien;

	@ManyToOne
	@JoinColumn(name = "conseiller_id", referencedColumnName = "id_conseiller")
	private Conseiller conseiller;

	// -----Constructeurs-----//

	public Visite() {
		super();
	}

	/**
	 * @param dateVisite
	 * @param clientAccepte
	 * @param conseillerAccepte
	 */
	public Visite(Date dateVisite, boolean clientAccepte, boolean conseillerAccepte, String chemin) {
		super();
		this.dateVisite = dateVisite;
		this.clientAccepte = clientAccepte;
		this.conseillerAccepte = conseillerAccepte;
		this.chemin=chemin;
	}

	/**
	 * @param id
	 * @param dateVisite
	 * @param clientAccepte
	 * @param conseillerAccepte
	 */
	public Visite(int id, Date dateVisite, boolean clientAccepte, boolean conseillerAccepte, String chemin) {
		super();
		this.id = id;
		this.dateVisite = dateVisite;
		this.clientAccepte = clientAccepte;
		this.conseillerAccepte = conseillerAccepte;
		this.chemin=chemin;
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
	 * @return the clientAccepte
	 */
	public boolean isClientAccepte() {
		return clientAccepte;
	}

	/**
	 * @param clientAccepte
	 *            the clientAccepte to set
	 */
	public void setClientAccepte(boolean clientAccepte) {
		this.clientAccepte = clientAccepte;
	}

	/**
	 * @return the conseillerAccepte
	 */
	public boolean isConseillerAccepte() {
		return conseillerAccepte;
	}

	/**
	 * @param conseillerAccepte
	 *            the conseillerAccepte to set
	 */
	public void setConseillerAccepte(boolean conseillerAccepte) {
		this.conseillerAccepte = conseillerAccepte;
	}

	/**
	 * @return the dateVisite
	 */
	public Date getDateVisite() {
		return dateVisite;
	}

	/**
	 * @param dateVisite
	 *            the dateVisite to set
	 */
	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	

	/**
	 * @return the bien
	 */
	public Bien getBien() {
		return bien;
	}

	/**
	 * @param bien the bien to set
	 */
	public void setBien(Bien bien) {
		this.bien = bien;
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
	 * @return the chemin
	 */
	public String getChemin() {
		return chemin;
	}

	/**
	 * @param chemin the chemin to set
	 */
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	

}