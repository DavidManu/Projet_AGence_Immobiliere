package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;
import fr.adaming.model.Contrat;

/**
 *
 */

@Service
@Transactional
public class ContratServiceImpl implements IContratService {

	/**
	 *  Injection de dependance
	 */
	
	@Autowired
	private IContratDao contratDao;
	
	
	
	/**
	 * @return the contratDao
	 */
	public IContratDao getContratDao() {
		return contratDao;
	}

	/**
	 * @param contratDao the contratDao to set
	 */
	public void setContratDao(IContratDao contratDao) {
		this.contratDao = contratDao;
	}

	/**
	 * Methode Creer un Contrat
	 */
	
	@Override
	public Contrat createContrat(Contrat c) {
		return contratDao.createContrat(c);
	}

	@Override
	public List<Contrat> getAllContrat() {
		return contratDao.getAllContrat();
	}

	@Override
	public Contrat updateContrat(Contrat c) {
		return contratDao.updateContrat(c);
	}

	@Override
	public void deleteContrat(int id) {
		contratDao.deleteContrat(id);
		
	}

	@Override
	public Contrat getContratById(int id) {
		return contratDao.getContratById(id);
	}

}
