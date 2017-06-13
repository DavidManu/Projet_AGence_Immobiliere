package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;

public interface IClientDao {
	
	/**
	 * Declaration des methodes
	 */
	
	public Client createClient(Client c);
	
	public List<Client> getAllClient(int idco);
	
	public Client getClientById(int id);
	
	public Client updateClient(Client c);
		
	public void deleteClient(int id);	
	
	


}
