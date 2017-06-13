package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {
	
	/**
	 * Declaration des methodes
	 */
	
	public Client createClient(Client c);
	
	public List<Client> getAllClient();
	
	public Client getClientById(int id);
	
	public Client updateClient(Client c);
		
	public void deleteClient(int id);	
	
	


}
