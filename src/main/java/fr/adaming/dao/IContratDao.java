package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Contrat;

public interface IContratDao {

	/**
	 * Declaration des methodes
	 */
	
	public Contrat createContrat(Contrat c);
	public List<Contrat> getAllContrat();
	public Contrat updateContrat(Contrat c);
	public void deleteContrat(int id);
	public Contrat getContratById(int id);
}
