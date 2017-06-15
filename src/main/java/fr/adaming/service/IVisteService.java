/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Visite;

/**
 * @author INTI-0360
 *
 */
public interface IVisteService {

	/**
	 * Declaration des methodes
	 */

	public Visite createVisite(Visite v);

	public List<Visite> getAllVisite();

	public Visite updateVisite(Visite v);

	public void deleteVisite(int id);

	public Visite getVisiteById(int id);

	
}
