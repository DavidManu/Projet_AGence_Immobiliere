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
@Table(name = "classesStandards")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class ClasseStandard implements Serializable {

	// -----Attributs-----//

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_classeSt")
	private int id;

	private int prixMin;
	private int minSurfaceMin;
	private int dateConstructionMin;

	
	@OneToMany(mappedBy = "classeStandard",fetch=FetchType.EAGER)
	private List<Client> listeClients;

	@OneToMany(mappedBy = "classeStandard", cascade = CascadeType.ALL)
	private List<Bien> listeBiens;

	// -----Constructeurs-----//

	/**
	 * 
	 */
	public ClasseStandard() {
		super();
	}

	/**
	 * @param prixMin
	 * @param minSurfaceMin
	 * @param dateConstructionMin
	 */
	public ClasseStandard(int prixMin, int minSurfaceMin, int dateConstructionMin) {
		super();
		this.prixMin = prixMin;
		this.minSurfaceMin = minSurfaceMin;
		this.dateConstructionMin = dateConstructionMin;
	}

	// -----Associations-----//

	// -----Getters & Setters-----//

	/**
	 * @return the prixMin
	 */
	public int getPrixMin() {
		return prixMin;
	}

	/**
	 * @param prixMin
	 *            the prixMin to set
	 */
	public void setPrixMin(int prixMin) {
		this.prixMin = prixMin;
	}

	/**
	 * @return the minSurfaceMin
	 */
	public int getMinSurfaceMin() {
		return minSurfaceMin;
	}

	/**
	 * @param minSurfaceMin
	 *            the minSurfaceMin to set
	 */
	public void setMinSurfaceMin(int minSurfaceMin) {
		this.minSurfaceMin = minSurfaceMin;
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

	/**
	 * @return the dateConstructionMin
	 */
	public int getDateConstructionMin() {
		return dateConstructionMin;
	}

	/**
	 * @param dateConstructionMin
	 *            the dateConstructionMin to set
	 */
	public void setDateConstructionMin(int dateConstructionMin) {
		this.dateConstructionMin = dateConstructionMin;
	}

}