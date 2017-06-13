/**
 * 
 */
package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="clients")

/**
 * @author INTI-0366
 *
 */
public class Client extends Personne {
	
	//-----Attributs-----//
	
	private String typeDeBien;
	
	//-----Constructeurs-----//

	/**
	 * 
	 */
	public Client() {
		super();
	}
	
	/**
	 * @param prenom
	 * @param nom
	 * @param numTravail
	 * @param numPrive
	 * @param adresse
	 * @param typeDeBien
	 */
	public Client(String prenom, String nom, String numTravail, String numPrive, Adresse adresse, String typeDeBien) {
		super(prenom, nom, numTravail, numPrive, adresse);
		this.typeDeBien = typeDeBien;
	}

	/**
	 * @param id
	 * @param prenom
	 * @param nom
	 * @param numTravail
	 * @param numPrive
	 * @param adresse
	 * @param typeDeBien
	 */
	public Client(int id, String prenom, String nom, String numTravail, String numPrive, Adresse adresse,
			String typeDeBien) {
		super(id, prenom, nom, numTravail, numPrive, adresse);
		this.typeDeBien = typeDeBien;
	}
	
	//-----Associations-----//

	@ManyToOne
	@JoinColumn(name="conseiller_id", referencedColumnName="id_conseiller")
	private Conseiller conseiller;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="client_visite",
		joinColumns=@JoinColumn(name="id_client"),
		inverseJoinColumns=@JoinColumn(name="id_visite"))
	private List<Visite> listeVisites;
	
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Contrat> listeContrats;
	
	//-----Getters et Setters-----//

	/**
	 * @return the typeDeBien
	 */
	public String getTypeDeBien() {
		return typeDeBien;
	}

	/**
	 * @param typeDeBien the typeDeBien to set
	 */
	public void setTypeDeBien(String typeDeBien) {
		this.typeDeBien = typeDeBien;
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
	 * @return the conseiller
	 */
//	public Conseiller getConseiller() {
//		return conseiller;
//	}

	/**
	 * @param conseiller the conseiller to set
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
	//-----Methode String-----//

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Client [typeDeBien=" + typeDeBien + "]";
	}

}