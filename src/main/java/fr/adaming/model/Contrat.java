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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@DiscriminatorValue(value="contrats")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Contrat implements Serializable {
	
	//-----Attributs-----//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contrat")
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date dateSignature;
	
	private String refContrat;
	
	//-----Associations-----//

	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="id_client")
	private Client client;
	
	@OneToOne
	@JoinColumn(name="bien_id", referencedColumnName="id_bien")
	private Bien bien;
	
	@ManyToOne
	@JoinColumn(name="conseiller_id", referencedColumnName="id_conseiller")
	private Conseiller conseiller;
	
	//-----Constructeurs-----//

	
	public Contrat() {
		super();
	}

	/**
	 * @param dateSignature
	 * @param refContrat
	 */
	public Contrat(Date dateSignature, String refContrat) {
		super();
		this.dateSignature = dateSignature;
		this.refContrat = refContrat;
	}

	/**
	 * @param id
	 * @param dateSignature
	 * @param refContrat
	 */
	public Contrat(int id, Date dateSignature, String refContrat) {
		super();
		this.id = id;
		this.dateSignature = dateSignature;
		this.refContrat = refContrat;
	}
	
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
	 * @return the dateSignature
	 */
	public Date getDateSignature() {
		return dateSignature;
	}

	/**
	 * @param dateSignature the dateSignature to set
	 */
	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
	}

	/**
	 * @return the refContrat
	 */
	public String getRefContrat() {
		return refContrat;
	}

	/**
	 * @param refContrat the refContrat to set
	 */
	public void setRefContrat(String refContrat) {
		this.refContrat = refContrat;
	}

	/**
	 * @return the client
	 */
	public int getClient() {
		return client.getId();
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
	public int getBien() {
		return bien.getId();
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
	 * @param conseiller the conseiller to set
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	


}