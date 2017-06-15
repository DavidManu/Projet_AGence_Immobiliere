/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStandard;

/**
 * @author INTI-0360
 *
 */
public interface IClasseStandardService {

	/**
	 *  Declaration des methodes
	 */
	
	public List<ClasseStandard> getAllClasseStandard();
	public ClasseStandard getClasseStandardById(int id);
	public void createClasseStandard(ClasseStandard c);
	public void updateClasseStandard(ClasseStandard c);
	public void deleteCLasseStandard(int id);
}
