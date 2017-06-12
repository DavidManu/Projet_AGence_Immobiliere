/**
 * 
 */
package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="proprietaires")

/**
 * @author INTI-0366
 *
 */
public class Proprietaire extends Personne {
	
	//-----Attributs-----//
	
	private String typeDeBien;
	
	//-----Constructeurs-----//

	/**
	 * @param typeDeBien
	 */
	public Proprietaire(String typeDeBien) {
		super();
		this.typeDeBien = typeDeBien;
	}
	
	/**
	 * @param prenom
	 * @param nom
	 * @param numTravail
	 * @param numPrive
	 * @param adresse
	 * @param typeDeBien
	 */
	public Proprietaire(String prenom, String nom, String numTravail, String numPrive, Adresse adresse,
			String typeDeBien) {
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
	public Proprietaire(int id, String prenom, String nom, String numTravail, String numPrive, Adresse adresse,
			String typeDeBien) {
		super(id, prenom, nom, numTravail, numPrive, adresse);
		this.typeDeBien = typeDeBien;
	}
	
	//-----Associations-----//

	@ManyToOne
	@JoinColumn(name="conseiller_id", referencedColumnName="id_conseiller")
	private Conseiller conseiller;
	
	@OneToMany(mappedBy="proprietaire", cascade=CascadeType.ALL)
	private List<Bien> listeBiens;
	
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
	 * @return the conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
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
		return "Proprietaire [typeDeBien=" + typeDeBien + "]";
	}

}