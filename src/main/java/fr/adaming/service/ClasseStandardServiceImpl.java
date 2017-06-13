/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseStandardDao;
import fr.adaming.model.ClasseStandard;

/**
 * @author INTI-0360
 *
 */

@Service
@Transactional
public class ClasseStandardServiceImpl implements IClasseStandardService {

	/**
	 *  Injection de dependance
	 */
	
	@Autowired
	private IClasseStandardDao csDao;
		
	/**
	 * @param csDao the csDao to set
	 */
	public void setCsDao(IClasseStandardDao csDao) {
		this.csDao = csDao;
	}

	/**
	 * Methodes
	 */
		@Override
	public List<ClasseStandard> getAllClasseStandard() {
		return csDao.getAllClasseStandard();
	}

	@Override
	public ClasseStandard getClasseStandardById(int id) {
		return csDao.getClasseStandardById(id);
	}

}
