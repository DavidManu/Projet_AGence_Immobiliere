package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
	
	/**
	 * Declaration des methodes
	 */
	
	public Client createClient(Client c);
	
	public List<Client> getAllClient();
	
	public Client getClientById(int id);
	
	public Client updateClient(Client c);
		
	public void deleteClient(int id);	
	

}
