/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienDao;
import fr.adaming.model.Bien;

@Transactional
@Service

/**
 * @author INTI-0366
 *
 */
public class BienServiceImpl implements IBienService {
	
	@Autowired
	private IBienDao biDAO;

	/**
	 * @return the biDAO
	 */
	public IBienDao getBiDAO() {
		return biDAO;
	}

	/**
	 * @param biDAO the biDAO to set
	 */
	public void setBiDAO(IBienDao biDAO) {
		this.biDAO = biDAO;
	}

	@Override
	public List<Bien> getAllProperty() {
		return biDAO.getAllProperty();
	}

	@Override
	public List<Bien> getAllPropertyByCategory(int id_ca) {
		return biDAO.getAllPropertyByCategory(id_ca);
	}

	@Override
	public List<Bien> getAllPropertyByOwnerAndAdviser(int id_pr, int id_co) {
		return biDAO.getAllPropertyByOwnerAndAdviser(id_pr, id_co);
	}

	@Override
	public List<Bien> getAllPropertyByCustomerAndAdviser(int id_pr, int id_cl) {
		return biDAO.getAllPropertyByCustomerAndAdviser(id_pr, id_cl);
	}

	@Override
	public Bien getPropertyByID(int id_bi) {
		return biDAO.getPropertyByID(id_bi);
	}

	@Override
	public void createProperty(Bien bien) {
		biDAO.createProperty(bien);
	}

	@Override
	public void updateProperty(Bien bien) {
		biDAO.updateProperty(bien);
	}

	@Override
	public void deleteProperty(int id_bi) {
		biDAO.deleteProperty(id_bi);
	}

}