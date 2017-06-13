/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVisteDao;
import fr.adaming.model.Visite;

/**
 * @author INTI-0360
 *
 */

@Service
@Transactional
public class VisiteServiceImpl implements IVisteService {

	/**
	 * Injection de dependance
	 */
	
	@Autowired
	private IVisteDao visiteDao;
		
	/**
	 * @return the visiteDao
	 */
	public IVisteDao getVisiteDao() {
		return visiteDao;
	}

	/**
	 * @param visiteDao the visiteDao to set
	 */
	public void setVisiteDao(IVisteDao visiteDao) {
		this.visiteDao = visiteDao;
	}

	@Override
	public Visite createVisite(Visite v) {
		return visiteDao.createVisite(v);
	}

	@Override
	public List<Visite> getAllVisite() {
		return visiteDao.getAllVisite();
	}

	@Override
	public Visite updateVisite(Visite v) {
		return visiteDao.updateVisite(v);
	}

	@Override
	public void deleteVisite(int id) {
		visiteDao.deleteVisite(id);
		
	}

	@Override
	public Visite getVisiteById(int id) {
		visiteDao.getVisiteById(id);
		return null;
	}

}
