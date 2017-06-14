/**
 * 
 */
package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;

/**
 * @author INTI-0365
 *
 */
@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	/**
	 * Injection de dependance
	 */
	@Autowired
	private IClientDao clientDao;

	/**
	 * @return the clientDao
	 */
	public IClientDao getClientDao() {
		return clientDao;
	}

	/**
	 * @param clientDao
	 *            the clientDao to set
	 */
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	/**
	 * Methode Creer un Client
	 */
	@Override
	public Client createClient(Client c) {

		return clientDao.createClient(c);
	}

	/**
	 * Methode Recuperer tout les Clients
	 */
	@Override
	public List<Client> getAllClient(int idco) {
		return clientDao.getAllClient(idco);
	}

	/**
	 * Recuperer un client par un id
	 */
	@Override
	public Client getClientById(int id) {
		return clientDao.getClientById(id);
	}

	/**
	 * Modifier un client
	 */
	@Override
	public Client updateClient(Client c) {
		
		return clientDao.updateClient(c);
	}

	/**
	 * Supprimer un client
	 */
	@Override
	public void deleteClient(int id) {
		clientDao.deleteClient(id);

	}

	@Override
	public List<Client> getAllClient() {
		return clientDao.getAllClient();
	}

}
