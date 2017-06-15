/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Bien;

/**
 * @author INTI-0366
 *
 */
public interface IBienService {
	
	public List<Bien> getAllProperty();
	public List<Bien> getAllPropertyByCategory(int id_ca);
	public List<Bien> getAllPropertyByOwnerAndAdviser(int id_pr, int id_co);
	public List<Bien> getAllPropertyByCustomerAndAdviser(int id_pr, int id_cl);
	
	public Bien getPropertyByID(int id_bi);
	
	public void createProperty(Bien bien);
	public void updateProperty(Bien bien);
	public void deleteProperty(int id_bi);

}