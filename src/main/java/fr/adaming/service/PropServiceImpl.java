package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IPropDao;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class PropServiceImpl implements IPropService {

	@Autowired
	private IPropDao propDao;

	public IPropDao getPropDao() {
		return propDao;
	}

	public void setPropDao(IPropDao propDao) {
		this.propDao = propDao;
	}

	@Override
	public Proprietaire createProprietaire(Proprietaire p) {

		return propDao.createProprietaire(p);
	}

	@Override
	public List<Proprietaire> getAllProprietaire(int id) {

		return propDao.getAllProprietaire(id);
	}

	@Override
	public Proprietaire getProprietaireById(int id) {

		return propDao.getProprietaireById(id);
	}

	@Override
	public Proprietaire updateProprietaire(Proprietaire p) {

		return propDao.updateProprietaire(p);
	}

	@Override
	public void deleteProprietaire(int id) {

		propDao.deleteProprietaire(id);

	}

}
